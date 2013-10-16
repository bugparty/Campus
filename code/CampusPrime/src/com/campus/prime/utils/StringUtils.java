package com.campus.prime.utils;

public class StringUtils {
	
	/**
	 * �жϸ����ַ��Ƿ��ǿհ��ַ�
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input){
		if(input == null)
			return true;
		for(int i = 0; i< input.length();i++){
			char c = input.charAt(i);
			if(c != ' ' && c != '\t' && c != '\r' && c != '\n'){
				return false;
			}
		}
		return true;
	}
}
