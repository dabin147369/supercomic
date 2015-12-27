package com.iis.supercomic.api;

public class ApiImpl implements Api {
	private static volatile ApiImpl mApiImpl;

	public static ApiImpl getInstance(){
		if(mApiImpl==null){
			synchronized (ApiImpl.class) {
				if(mApiImpl==null){
					mApiImpl = new ApiImpl();
				}
			}
		}
		return mApiImpl;
	}
	



}
