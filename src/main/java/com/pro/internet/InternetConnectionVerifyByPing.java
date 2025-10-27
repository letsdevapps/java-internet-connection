package com.pro.internet;

public class InternetConnectionVerifyByPing {

	public static boolean isInternetAvailable() {
		try {
			Process process = Runtime.getRuntime().exec("ping -c 1 www.google.com");
			int returnVal = process.waitFor();
			return (returnVal == 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
