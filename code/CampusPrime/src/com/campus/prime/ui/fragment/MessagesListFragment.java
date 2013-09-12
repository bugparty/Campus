package com.campus.prime.ui.fragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Network.Network;
import RemoteImage.ImageTools.ImageToolsDelegate;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.campus.prime.adapter.MessageListViewAdapter;
import com.campus.prime.constant.AppConstant;
import com.campus.prime.model.Message;
import com.campus.prime.protocol.MessageProtocol;
import com.campus.prime.protocol.ProtocolDelegate;
import com.campus.prime.R;

public class MessagesListFragment extends ListFragment implements 
		ProtocolDelegate<Message>, ImageToolsDelegate{
		
		
	//�����ȡ��Ϣ�ɹ�
	private static final int MESSAGE_GETMESSAGE_SUCCESS = 0;
	//�����ȡ��Ϣʧ��
	private static final int MESSAGE_GETMESSAGE_FAILED = 1;
	
	//private ArrayAdapter<String> mAdapter;
	private MessageListViewAdapter mAdapter;
	//��Ҫ��listView����ʾ��data
	private List<Message> mData;
	
	/**
	 * ��������������Ϣ�̷߳��͵�message
	 */
	Handler handler = new Handler(){
		
		
		@Override
		public void handleMessage(android.os.Message msg) {
			switch(msg.what){
			case MESSAGE_GETMESSAGE_SUCCESS:
				//�����ܵ�����Ϣ�󶨵�listView
				bindListView();
				break;
			case MESSAGE_GETMESSAGE_FAILED:
				break;
			default:
				break;
			}
			super.handleMessage(msg);
		};
	};
	/**
	 * 
	 */
	private void getMessagesFromNetwork(){
		//������Ӧ��model��protocolʵ��
		MessageProtocol protocol = new MessageProtocol().setDelegate(this)
				.setContext(this.getActivity());
		//����Networkʵ��
		Network network = new Network();
		//����URL
		network.setURL(MessageProtocol.URL + MessageProtocol.COMMAND);
		//����http����
		//network.send(protocol, Network.POST);
		//û��server����
		network.sendForTest(protocol,MessageProtocol.COMMAND,Network.GET);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//�������ȡ��Ϣ    
		getMessagesFromNetwork();
		//��ʼ��mData   ���Ǿ޿��ޱȣ�����������
		//mData = new ArrayList<Message>();
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		setEmptyText("No Messages");
		//actionbar�����menu
		setHasOptionsMenu(true);
		
	}
	
	private void bindListView(){
		//mAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_expandable_list_item_1,mData);
		mAdapter = new MessageListViewAdapter(this.getActivity(), mData, R.layout.messages_listitem);
		setListAdapter(mAdapter);
	}

	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		MenuItem item = menu.add("Search");
		item.setIcon(android.R.drawable.ic_menu_search);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		SearchView sv = new SearchView(getActivity());
		sv.setOnQueryTextListener(null);
		item.setActionView(sv);
	}

	@Override
	public void getMessageSuccess(List<Message> messages) {
		// TODO Auto-generated method stub
		
		//log
		if(messages != null){
			//��ȡ������õ�����Ϣ-----messages
			Iterator<Message> iterator = messages.iterator();
			while(iterator.hasNext()){
				Log.d(AppConstant.DEBUG_TAG,"get message success" + iterator.next().toString());
			}
			
		}
		
		mData = messages;
		Log.d(AppConstant.DEBUG_TAG,"mData "+ mData.get(0).toString());
		
		handler.sendEmptyMessage(MESSAGE_GETMESSAGE_SUCCESS);
	}

	@Override
	public void getMessageFailed() {
		// TODO Auto-generated method stub
		handler.sendEmptyMessage(MESSAGE_GETMESSAGE_FAILED);
		Log.d(AppConstant.DEBUG_TAG,"get messages failed");
	}


	@Override
	public void downlaodImageFailed() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void downloadImageSuccess() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}
		

}
