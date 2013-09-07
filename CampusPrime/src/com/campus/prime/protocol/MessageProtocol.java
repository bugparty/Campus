package com.campus.prime.protocol;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.campus.prime.common.utils.JsonUtil;
import com.campus.prime.constant.AppConstant;
import com.campus.prime.database.MessageDB;
import com.campus.prime.model.Message;
import com.google.gson.reflect.TypeToken;

import Database.DAOHelper;
import Protocol.ProtocolBase;

public class MessageProtocol extends ProtocolBase{
	
	public static final String URL = "http://www.freeabsurd.com/";
	
	public static final String COMMAND = "getMessages";

	
	/**
	 * ����ί��
	 * �۲���ģʽ
	 * @author absurd
	 *
	 */
	public interface ProtocolMessageDelegate{
		public void getMessageSuccess(List<Message> messages);
		public void getMessageFailed();
	}
	
	//����delegate�Ķ���
	ProtocolMessageDelegate delegate;
	Context context;
	
	public MessageProtocol setContext(Context context){
		this.context = context;
		return this;
	}
	
	public MessageProtocol setDelegate(ProtocolMessageDelegate delegate){
		this.delegate = delegate;
		return this;
	}
	
	
	@Override
	public String packageProtocol() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ���������json�ַ���
	 * @param arg0
	 * @return
	 */
	@Override
	public boolean parseProtocol(String arg0) {
		// TODO Auto-generated method stub
		// ��վɵĻ���
		MessageDB db = (MessageDB)DAOHelper.getInstance().getTable(MessageDB.TABLE);
		db.clearAll();
		//����json
		List<Message> messages = (List<Message>) JsonUtil.jsonToList(arg0,new TypeToken<List<Message>>(){}.getType());
		if(messages != null){
			//��ӵ����ݿ�
			Message message = null;
			Iterator<Message> iterator = messages.iterator();
			while(iterator.hasNext()){
				message = iterator.next();
				message.setContext(context);
				Log.d(AppConstant.DEBUG_TAG,message.toString());
				message.saveToDB();
				
			}
		}
		delegate.getMessageSuccess(messages);
		return true;
	}
	
}
