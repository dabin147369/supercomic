package com.iis.supercomic.api;
public interface Api {
	/*******访问网络的公共接口************/
	// parameter
	String PARAM_APP_ID = "appId";
	String PARAM_USER_ID = "userId";
	String PARAM_OS_VERSION = "osVersion";
	String PARAM_MAC = "mac";
	String PARAM_SOURCE = "source";
	String PARAM_MOBILE_VERSION = "mobileVersion";
	String PARAM_MOBILE = "mobile";
	
	// action
	String ACTION_DEVICE_REGISTER = "/device/register";
	String ACTION_DEVICE_CONFIG = "/device/config";
	String NOVEL_CATEGORY = "/novel/category";
	String NOVEL_RAND = "/novel/rank";



}
