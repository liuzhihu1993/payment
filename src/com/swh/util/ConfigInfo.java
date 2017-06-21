package com.swh.util;

import java.util.ResourceBundle;

/**
 * 读取配置文件
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
	 * 获取指定的key的值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return cache.getString(key);
	}
	

}
