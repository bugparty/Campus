package com.campus.prime.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;

import Network.Network;
import android.app.ApplicationErrorReport;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * �첽�̼߳���ͷ�񹤾���
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
	
	
	static{
		cache = new HashMap<String,SoftReference<Bitmap>>();
		pool = Executors.newFixedThreadPool(5);//�̳߳�
		imageViews = new HashMap<ImageView,String>();
		
	}
	
	public BitmapManager() {
		// TODO Auto-generated constructor stub
	}
	
	public BitmapManager(Bitmap defaultBmp){ 
		this.defaultBmp = defaultBmp;  
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
		imageViews.put(imageView, url);
		
		Bitmap bitmap = getBitmapFromCache(url);
		//���cache���Ѿ��и�ͼƬ��ֱ�Ӽ��ظ�ͼƬ
		if(bitmap != null){
			imageView.setImageBitmap(bitmap);
		}else{
			//���SD������
			String filename = FileUtils.getFileName(url);
			String filepath = imageView.getContext().getFilesDir() + File.separator + filename;
			
			File file = new File(filepath);
			if(file.exists()){
				Bitmap bmp = ImageUtils.getBitmap(imageView.getContext(),filename);
				imageView.setImageBitmap(bmp);
			}else{
				//���û��  �������л�ȡ
				imageView.setImageBitmap(defaultBmp);
				queueJob(url,imageView,width,height);
			}
		}
	}
	
	/**
	 * �������м���ͼƬ
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
	
	
	private Bitmap downloadBitmap(String url,int width, int height){
		Bitmap bitmap = null;
		try{
			//http���� ����ͼƬ
			
			if(width > 0 && height > 0){
				//�ƶ���ʾͼƬ�Ĵ�С
				bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
			}
			cache.put(url,new SoftReference<Bitmap>(bitmap));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bitmap;
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
