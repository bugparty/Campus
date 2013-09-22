package com.campus.prime.protocol;

import android.content.Context;
import com.campus.prime.database.MessageDB;
import com.campus.prime.model.MessagesList;
import com.campus.prime.utils.JsonUtil;

import Database.DAOHelper;
import Protocol.ProtocolBase;

public class MessageProtocol extends ProtocolBase{
	
	public static final String URL = "http://0.campusv.duapp.com/api/circle/messages/user_timeline/2/";
	
	public static final String COMMAND = "";
	

	ProtocolDelegate<MessagesList> mDelegate;
	Context mContext;
	
	public MessageProtocol setContext(Context context){
		this.mContext = context;
		return this;
	}
	
	public MessageProtocol setDelegate(ProtocolDelegate<MessagesList> delegate){
		this.mDelegate = delegate;
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
		MessagesList messages = (MessagesList)JsonUtil.jsonToModel(arg0, MessagesList.class);
		/**
		 * ����
		@SuppressWarnings("unchecked")
		List<Message> messages = (List<Message>) JsonUtil.jsonToList(arg0,new TypeToken<List<Message>>(){}.getType());
		if(messages != null){
			//��ӵ����ݿ�
			Message message = null;
			Iterator<Message> iterator = messages.iterator();
			while(iterator.hasNext()){
				message = iterator.next();
				message.setContext(mContext);
				Log.d(AppConstant.DEBUG_TAG,message.toString());
				message.saveToDB();
				
			}
		}
		**/
		mDelegate.getMessageSuccess(messages);
		return true;
	}
	
}
