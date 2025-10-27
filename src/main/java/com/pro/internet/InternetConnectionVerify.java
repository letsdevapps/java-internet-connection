package com.pro.internet;

public class InternetConnectionVerify {

	public InternetConnectionVerify() {
	}

	public boolean isInternetAvailableByPing() {
		return InternetConnectionVerifyByPing.isInternetAvailable();
	}
	
	public boolean isInternetAvailableByInetAddress() {
		return InternetConnectionVerifyByInetAddress.isInternetAvailable();
	}
	
	public boolean isInternetAvailableByUrlConn() {
		return InternetConnectionVerifyByUrlConn.isInternetAvailable();
	}
}
