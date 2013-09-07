package com.campus.prime.ui.widget;

import com.campus.prime.constant.AppConstant;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class LinkView extends TextView{
	
	//����link������Ľӿ�ʵ��
	public OnLinkClickListner mLinkClickListner = new OnLinkClickListner() {
		
		@Override
		public void onLinkClick() {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	public LinkView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	
	public LinkView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}


	public LinkView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	public void setOnLinkClickListener(OnLinkClickListner mLinkClickListner){
		this.mLinkClickListner = mLinkClickListner;
	}
	
	public OnLinkClickListner getOnLinkClickListner(){
		return mLinkClickListner;
	}
	
	/**
	 * ����link��text
	 * @param linkTxt
	 */
	public void setLinkText(String linkTxt){
		//Spanned span = Html.fromHtml(linkTxt);
		Log.d(AppConstant.DEBUG_TAG,"set link text");
		setText(linkTxt);
		//
	}
	
	
	//����link����ļ������ӿ�
	public interface OnLinkClickListner{
		void onLinkClick();
	}
	
	/**
	 * �̳�ClickableSpan�ӿ� 
	 * ����onClick����
	 * @author absurd
	 *
	 */
	public class MyURLSpan extends ClickableSpan{
		
		private String mUrl;
		
		public MyURLSpan(String url) {
			// TODO Auto-generated constructor stub
			this.mUrl = url;
		}
		
		@Override
		public void onClick(View widget) {
			// TODO Auto-generated method stub
			//���ü������ӿڵ�onClick����
			mLinkClickListner.onLinkClick();
			Log.d(AppConstant.DEBUG_TAG,"on click link");
			
		}
		
	}
	
	
	
}
