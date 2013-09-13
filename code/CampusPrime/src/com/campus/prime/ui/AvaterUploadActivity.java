package com.campus.prime.ui;

import java.io.File;

import com.campus.prime.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AvaterUploadActivity extends Activity {
	
	private Button photoButton;
	private Button galleryButton;
	
	// �������־
	private static final int FLAG_ACTION_IAMGE_CAPTURE = 0;
	// �ü�ͼƬ��־
	private static final int FLAG_IMAGE_CAPTURE_CROP = 1;
	// ����־
	private static final int FLAG_IMAGE_GALLERY = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_avater_upload);
		
		photoButton = (Button)findViewById(R.id.photo_button);
		galleryButton = (Button)findViewById(R.id.gallery_button);
		photoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//���ջ�ȡͼƬ
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				//intent.putExtra(MediaStore.EXTRA_OUTPUT, uri); ��ͼƬ���뱾�ش洢
				startActivityForResult(intent, FLAG_ACTION_IAMGE_CAPTURE);
			}
		});
		
		galleryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//���������ѡͼƬ
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(intent,FLAG_IMAGE_GALLERY);

			}
		});
	}
	
	
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
		
		if(arg0 == FLAG_ACTION_IAMGE_CAPTURE){
			cropImageUri(arg2);
			return;
		}else if(arg0 == FLAG_IMAGE_CAPTURE_CROP){
			return;
		}else if(arg0 == FLAG_IMAGE_GALLERY){
			return;
		}
	}
	
	/**
	 * �ü�photo
	 * @param data
	 */
	private void cropImageUri(Intent data){
		if(data == null){
			return;
		}
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(data.getData(), "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1); //���ð����Ϳ�ı����ü�
        intent.putExtra("aspectY", 1);
        int sizeImageHead = getResources().getDimensionPixelSize(R.dimen.s_70);
        intent.putExtra("outputX", sizeImageHead); //��������Ĵ�С
        intent.putExtra("outputY", sizeImageHead);
        intent.putExtra("scale", true); //�����Ƿ���������
        // ���Ҫ�ڸ�����uri�л�ȡͼƬ�����������Ϊfalse���������Ϊtrue����ô�㲻���ڸ�����uri�л�ȡ���ü���ͼƬ
        intent.putExtra("return-data", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//���������ʽ
        intent.putExtra("noFaceDetection", true); // ��������ʶ��  Ĭ�ϲ���Ҫ����
        startActivityForResult(intent, FLAG_IMAGE_CAPTURE_CROP);
	}
	
	
	private void setAvatarImage(Intent intent){
		if(intent == null){
			return;
		}
		//��intent�л�ȡͼƬ
		final Bitmap avatar = (Bitmap)intent.getExtras().get("data");
		if(avatar == null){
			return;
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.avater_upload, menu);
		return true;
	}

}
