package com.campus.prime.ui.group;

import com.campus.prime.R;
import com.campus.prime.ui.indicator.PageIndicator;
import com.campus.prime.ui.indicator.TitlePageIndicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

/**
 * Ⱥ����ϸ���ϵ�activity
 * ��������Fragment GroupBasicFragment��GroupmembersFragment,GroupRecentFragment
 * @author absurd
 *
 */
public class GroupActivity extends FragmentActivity{
	
	private int groupId;
	
	GroupPagerAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;
	
	/**
	 * get groupId
	 * @return
	 */
	public int getGroupId(){
		return groupId;
	}
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.group_pager);
		mAdapter = new GroupPagerAdapter(getSupportFragmentManager());
		mPager = (ViewPager)findViewById(R.id.group_pager);
		mPager.setAdapter(mAdapter);
		mIndicator = (TitlePageIndicator)findViewById(R.id.group_indicator);
		mIndicator.setViewPager(mPager);

		
		Intent intent = getIntent();
		groupId = intent.getIntExtra("groupId", -1);
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}
	
	
}