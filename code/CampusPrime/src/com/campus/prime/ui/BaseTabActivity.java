package com.campus.prime.ui;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;

/**
 * ����ʵ��tabs fragment�ĸ���
 * ʹ�÷�����
 * �̳и���
 * ʵ�ֳ��󷽷�   ������ʹ�ü����巽��˵��
 * @author absurd
 *
 */
public abstract class BaseTabActivity extends BaseActivity implements TabListener,OnNavigationListener{
	
	private ViewPager mPager;
	private FragmentPagerAdapter mAdapter;
	private List<String> tabNames;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(id());
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		tabNames = tabNames();
		initTabFragmentPager(actionBar);
	}
	
	/**
	 * configure FragmentPager
	 * @param actionBar
	 */
	private void initTabFragmentPager(final ActionBar actionBar){
		mPager = viewPager();
		mAdapter = adapter();
		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		actionBar.addTab(actionBar.newTab().setText(tabNames.get(0)).setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(tabNames.get(1)).setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(tabNames.get(2)).setTabListener(this));
	}
	/**
	 * ����activity��layout resource id
	 * @return
	 */
	protected abstract int id();
	/**
	 * ����ViewPager resource id
	 * @return
	 */
	protected abstract ViewPager viewPager();
	/**
	 * ����FragmentPageAdapter
	 * @return
	 */
	protected abstract FragmentPagerAdapter adapter();
	/**
	 * ����Fragment�����б�
	 * @return
	 */
	protected abstract List<String> tabNames();
	
	@Override
	public boolean onNavigationItemSelected(int arg0, long arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		mPager.setCurrentItem(arg0.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
