package com.campus.prime.ui.view;





import com.campus.prime.R;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;


public class DetectLinearLayout extends LinearLayout
{	
	public DetectLinearLayout(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor stub
	}
	public DetectLinearLayout(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	private static Boolean isDark = false;
	
	
	private static final int [] light_mode = {R.attr.state_light};
	private static final int [] dark_mode = {R.attr.state_dark};
	
	
	

	
	@Override
	protected int[] onCreateDrawableState(int extraSpace) 
	{
	    final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
	    if(isDark == true)
	    	mergeDrawableStates(drawableState,dark_mode);
	    else
	    	mergeDrawableStates(drawableState,light_mode);
	    return drawableState;
	}
	
	public void setIsDark(Boolean isDark)
	{
		this.isDark=isDark;
		refreshDrawableState();
	}
	
	public Boolean getIsDark()
	{
		return isDark;
	}

}
