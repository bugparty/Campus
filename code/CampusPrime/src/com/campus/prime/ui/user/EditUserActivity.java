package com.campus.prime.ui.user;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

import com.campus.prime.R;
import com.campus.prime.ui.user.CustomAdapter.OnItemClickListener;
import com.campus.prime.ui.view.LabelEditText;
import com.campus.prime.ui.view.LabelTextView;
import com.campus.prime.ui.view.ThemeDialog;
import com.campus.prime.ui.view.ThemeImageView;

public class EditUserActivity extends Activity implements OnItemClickListener
{
	private ThemeDialog dialog;
	List <String> loveStates = new ArrayList<String>();
	List <String> schools = new ArrayList<String>();
	List <String> academys = new ArrayList<String>();
	List <String> grades = new ArrayList<String>();
	
	ThemeImageView editUserAvatar;
	
	//ThemeEditText editGender;
	
	LabelTextView editRealName;
	LabelTextView editEmail;
	LabelEditText editNickName;
	LabelTextView editLoveState;
	LabelEditText editDescription;
	LabelTextView editSchool;
	LabelTextView editAcademy;
	LabelTextView editGrade;
	
	TextView currentView;
	
	@Override
	public  void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_user);	
		getData();
		getView();
		setParams();
		setEvent();	
		
	}
			
	public void getLoveStates()
	{
		
			loveStates.add("Alone");
			loveStates.add("Loving");
			loveStates.add("Wondering");
		
	}
	public void getSchools()
	{
		schools.add("������ѧ");
		schools.add("�㽭��ѧ");
		schools.add("�廪��ѧ");
		schools.add("��۴�ѧ");
		schools.add("�ྩ��ѧ");
		schools.add("������ѧ");
		schools.add("�ӱ���ѧ");
		schools.add("���ϴ�ѧ");
		schools.add("������ѧ");
		schools.add("������ѧ");
		schools.add("���ϴ�ѧ");
		schools.add("���ϴ�ѧ");		
	}
	public void getAcademys()
	{	
		academys.add("����ѧԺ");
		academys.add("����ѧԺ");
		academys.add("��Ϣ����ѧԺ");
		academys.add("��ѧ��ͳ��ѧԺ");
		academys.add("��ѧԺ");
		academys.add("���ѧԺ");
		academys.add("����ѧԺ");
		academys.add("����ѧԺ");
		academys.add("����ѧԺ");
		academys.add("���ù���ѧԺ");
		
		
		
	}
	public void getGrades()
	{
		grades.add("2013��");
		grades.add("2012��");
		grades.add("2011��");
		grades.add("2010��");
		grades.add("2009��");
		grades.add("2008��");
		grades.add("2007��");
		grades.add("2006��");
		grades.add("2005��");
		grades.add("2004��");
		
	}
	
	
	public void getData()
	{
		getLoveStates();
		getSchools();
		getAcademys();
		getGrades();
	}
	public void getView()
	{
		
		
		editUserAvatar = (ThemeImageView) this.findViewById(R.id.edit_user_avactar);
				
		//ThemeEditText editGender;
		editRealName = (LabelTextView) this.findViewById(R.id.edit_user_realname);
		editEmail = (LabelTextView) this.findViewById(R.id.edit_user_email);
		editNickName = (LabelEditText) this.findViewById(R.id.edit_user_nickname);
		editLoveState = (LabelTextView) this.findViewById(R.id.edit_user_love);
		editDescription = (LabelEditText) this.findViewById(R.id.edit_user_description);
		editSchool = (LabelTextView) this.findViewById(R.id.edit_user_school);
		editAcademy = (LabelTextView) this.findViewById(R.id.edit_user_academy);
		editGrade = (LabelTextView) this.findViewById(R.id.edit_user_grade);
			
	}
	
	public void setParams()
	{
		editRealName.setLabel("����");
		editEmail.setLabel("����");
		editNickName.setLabel("�ǳ�");
		editLoveState.setLabel("����״̬");
		editDescription.setLabel("��������");
		editSchool.setLabel("����ѧУ");
		editAcademy.setLabel("����ѧԺ");
		editGrade.setLabel("�����꼶");
		
		
	}
		
	public void setEvent()
	{
		
		editUserAvatar.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			}
		});	
		editLoveState.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				currentView = editLoveState;
				showDialog(loveStates);
					
				}
		});
			
		editSchool.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//Intent intent = new Intent(EditUserActivity.this,EditUserSchoolActivity.class);
				//startActivity(intent);
				showDialog(schools);
			}
		});		
		editAcademy.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				currentView = editAcademy;
				showDialog(academys);
			}
		});	
		editGrade.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				currentView = editGrade;
				showDialog(grades);
			}
		});	
	}
		
	
	@Override
	public void onClick(String string) 
	{
		// TODO Auto-generated method stub
		dialog.dismiss();
		currentView.setText(string);
	}
		
	public void showDialog(List<String> data)
	{
		dialog = new ThemeDialog(EditUserActivity.this,R.style.my_dialog);
		LayoutInflater inflater = LayoutInflater.from(EditUserActivity.this);
		View view = inflater.inflate(R.layout.dia_list, null);
		ListView listView = (ListView) view.findViewById(R.id.dia_list);
		CustomAdapter adapter = new CustomAdapter(EditUserActivity.this,R.layout.dia_item,R.id.dia_item,data);
		adapter.setListener(this);
		dialog.setCancelable(true);
		dialog.setCanceledOnTouchOutside(true);		
		listView.setAdapter(adapter);			
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);			
		dialog.show();
		dialog.setContentView(view,params);
	}


}
