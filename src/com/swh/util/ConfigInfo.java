package com.swh.util;

import java.util.ResourceBundle;

/**
 * ��ȡ�����ļ�
 * @author lenovo
 *
 */
public class ConfigInfo {
	
	private static ResourceBundle cache = null;
	static {
		try {
			cache = ResourceBundle.getBundle("merchantInfo");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡָ����key��ֵ
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return cache.getString(key);
	}
	

}
