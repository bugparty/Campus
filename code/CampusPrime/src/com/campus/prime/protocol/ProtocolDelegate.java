package com.campus.prime.protocol;

import java.util.List;

import com.campus.prime.model.ModelBase;


/**
 * ����protocol�Ľӿ�
 * @author absurd
 *
 * @param <T>
 */
public interface ProtocolDelegate<T extends Object> {
	public void getMessageSuccess(T t);
	public void getMessageFailed();
}
