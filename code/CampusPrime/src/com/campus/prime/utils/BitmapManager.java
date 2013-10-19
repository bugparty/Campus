package com.campus.prime.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

import com.campus.prime.core.utils.BCSUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * �첽�̼߳���ͼƬ������
 * bindAvatar(ImageView imageView, int userId)
 * @author absurd
 *
 */
public class BitmapManager {
	//����ͼƬ��cache  cache�����ڴ���
	private static HashMap<String,SoftReference<Bitmap>> cache;
	//
	private static ExecutorService pool;
	
	private static Map<ImageView, String> imageViews;
	
	private Bitmap defaultBmp;
	
	private static BitmapManager bitmapManager;
	
	private static Object classLock = BitmapManager.class;
	
	static{
		cache = new HashMap<String,SoftReference<Bitmap>>();
		pool = Executors.newFixedThreadPool(5);//�̳߳�
		imageViews = new HashMap<ImageView,String>();
		
	}
	
	protected BitmapManager(){
		
	}
	
	public static BitmapManager getInstance(){ 
		synchronized(classLock){
			if(bitmapManager == null){
				bitmapManager = new BitmapManager();
			}
			return bitmapManager;
		}
		
	}
	
		
	/**
	 * ����Ĭ��ͼƬ
	 * @param bmp
	 */
	public void setDefaultBmp(Bitmap bmp){
		defaultBmp = bmp;
	}
	/**
	 * ��imageView�м���ͼƬ--���ƶ�ͼƬ�ĸߺͿ�
	 * @param url
	 * @param imageView
	 * @param defaultBmp
	 * @param width
	 * @param height
	 */
	public void loadBitmap(String url, ImageView imageView, Bitmap defaultBmp, int width, int height){
		if(!StringUtils.isEmpty(url)){
			imageViews.put(imageView, url);
			
			Bitmap bitmap = getBitmapFromCache(url);
			//���cache���Ѿ��и�ͼƬ��ֱ�Ӽ��ظ�ͼƬ
			if(bitmap != null){
				imageView.setImageBitmap(bitmap);
			}else{
				//����ļ����Ƿ񻺴�ͼƬ
				String filename = FileUtils.getFileName(url);
				String filepath = imageView.getContext().getFilesDir() + File.separator + filename;
				
				File file = new File(filepath);
				if(file.exists()){
					Bitmap bmp = ImageUtils.getBitmap(imageView.getContext(),filename);
					imageView.setImageBitmap(bmp);
				}else{
					// if not,get from net
					imageView.setImageBitmap(defaultBmp);
					queueJob("/media/" + filename,imageView,width,height);
				}
			}
		}
	}
	
	
	/**
	 * load photo from net
	 * @param url
	 * @param imageView
	 * @param width
	 * @param height
	 */
	private void queueJob(final String url,final ImageView imageView, final int width, final int height){
		final Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				String tag = imageViews.get(imageView);
				if(tag != null && tag.equals(url)){
					if(msg.obj != null){
						imageView.setImageBitmap((Bitmap)msg.obj);
						//��SD��д�뻺��
						try{
							ImageUtils.saveImage(imageView.getContext(),FileUtils.getFileName(url),(Bitmap)msg.obj);
							
						}catch(IOException e){
							e.printStackTrace();
						}
						
					}
				}
			}
		};
		
		//�̳߳�  ���5�����ͬʱִ��
		pool.execute(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Message message = new Message();
				message.obj = downloadBitmap(url,width,height);
				handler.sendMessage(message);
			}
		});
	}
	
	
	private Bitmap downloadBitmap(String urlPath,int width, int height){
		Bitmap bitmap = null;
		try{
			//http����   ��ȡͼƬ
			/**
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(6 * 1000);
			int responseCode = conn.getResponseCode();
			if(responseCode == 200){
				InputStream inputStream = conn.getInputStream();
				byte[] data = (byte[]) readStream(inputStream);
				bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
				
			}
			**/
			InputStream inputStream = BCSUtils.getObjectContent("/media/test.jpg");
			byte[] data = (byte[]) readStream(inputStream);
			bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			if(width > 0 && height > 0){
				//�ƶ���ʾͼƬ�Ĵ�С
				bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
			}
			cache.put(urlPath,new SoftReference<Bitmap>(bitmap));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bitmap;
	}
	
	/**
	 * ��ȡ������õ���IO��
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	private byte[] readStream(InputStream inputStream)throws Exception{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = inputStream.read(buffer)) != -1){
			outStream.write(buffer,0,len);
		}
		outStream.close();
		inputStream.close();
		
		return outStream.toByteArray();
		
	}
	
	
	/**
	 * ��cache�л�ȡͼƬ
	 * @param url
	 * @return
	 */
	private Bitmap getBitmapFromCache(String url){
		Bitmap bitmap = null;
		if(cache.containsKey(url)){
			bitmap = cache.get(url).get();
		}
		return bitmap;
	}
	
}
