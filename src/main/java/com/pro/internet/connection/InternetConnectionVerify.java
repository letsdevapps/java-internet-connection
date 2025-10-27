package com.pro.internet.connection;

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
