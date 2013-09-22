package com.campus.prime.ui.widget;


import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * �������ı��ؼ�
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
public class LinkView extends TextView {
	private OnLinkClickListener mLinkClickListener = new LinkView.OnLinkClickListener() {
		@Override
		public void onLinkClick() {

		}
	};

	public LinkView(Context context) {
		super(context);
	}

	public LinkView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LinkView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public OnLinkClickListener getLinkClickListener() {
		return mLinkClickListener;
	}

	public void setLinkClickListener(OnLinkClickListener linkClickListener) {
		this.mLinkClickListener = linkClickListener;
	}

	public void setLinkText(String linktxt) {
		Spanned span = Html.fromHtml(linktxt);
		setText(span);
		setMovementMethod(LinkMovementMethod.getInstance());
		parseLinkText(span);
	}

	public void parseLinkText(Spanned spanhtml) {
		CharSequence text = getText();
		if (text instanceof Spannable) {
			int end = text.length();
			Spannable sp = (Spannable) getText();
			URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);

			URLSpan[] htmlurls = spanhtml != null ? spanhtml.getSpans(0, end,
					URLSpan.class) : new URLSpan[] {};

			if (urls.length == 0 && htmlurls.length == 0)
				return;

			SpannableStringBuilder style = new SpannableStringBuilder(text);
			// style.clearSpans();// ��������֮ǰ���е���ʽ
			for (URLSpan url : urls) {
				if (!isNormalUrl(url)) {
					style.removeSpan(url);// ֻ��Ҫ�Ƴ�֮ǰ��URL��ʽ������������
					NoLinkSpan span = new NoLinkSpan(url.getURL());
					style.setSpan(span, sp.getSpanStart(url),
							sp.getSpanEnd(url),
							Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
					continue;
				}
				style.removeSpan(url);// ֻ��Ҫ�Ƴ�֮ǰ��URL��ʽ������������
				MyURLSpan myURLSpan = new MyURLSpan(url.getURL());
				style.setSpan(myURLSpan, sp.getSpanStart(url),
						sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			for (URLSpan url : htmlurls) {
				style.removeSpan(url);// ֻ��Ҫ�Ƴ�֮ǰ��URL��ʽ������������
				MyURLSpan myURLSpan = new MyURLSpan(url.getURL());
				style.setSpan(myURLSpan, spanhtml.getSpanStart(url),
						spanhtml.getSpanEnd(url),
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
			setText(style);
		}
	}

	public void parseLinkText() {
		parseLinkText(null);
	}

	public class MyURLSpan extends ClickableSpan {
		private String mUrl;

		public MyURLSpan(String url) {
			mUrl = url;
		}

		@Override
		public void onClick(View widget) {
			mLinkClickListener.onLinkClick();
			/**
			URLs urls = URLs.parseURL(mUrl);
			if (urls != null) {
				UIHelper.showLinkRedirect(widget.getContext(),
						urls.getObjType(), urls.getObjId(), urls.getObjKey());
			} else {
				UIHelper.openBrowser(widget.getContext(), mUrl);
			}
			**/
		}
	}

	/**
	 * ����Ӧ��ClickableSpan
	 * 
	 * @author yeguozhong@yeah.net
	 * 
	 */
	public class NoLinkSpan extends ClickableSpan {
		private String text;

		public NoLinkSpan(String text) {
			super();
			this.text = text;
		}

		@Override
		public void updateDrawState(TextPaint ds) {
			ds.setColor(Color.BLACK);
			ds.setUnderlineText(false); // ȥ���»���
		}

		@Override
		public void onClick(View widget) {
			// doNothing...
		}

	}

	public interface OnLinkClickListener {
		void onLinkClick();
	}

	/**
	 * ���˵�һЩ������������
	 * 
	 * @param url
	 * @return
	 */
	public boolean isNormalUrl(URLSpan url) {
		String urlStr = url.getURL();
		if (urlStr.endsWith(".sh")) {
			return false;
		}
		return true;
	}
}
