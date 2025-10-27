package com.pro;

import com.pro.internet.InternetConnectionVerify;

public class App {
	public static void main(String[] args) {
		InternetConnectionVerify internetConnectionVerify = new InternetConnectionVerify();

		System.out.println("Teste de conexão de internet por Ping: " + internetConnectionVerify.isInternetAvailableByPing());
		
		System.out.println("Teste de conexão de internet por InetAddress: " + internetConnectionVerify.isInternetAvailableByInetAddress());
		
		System.out.println("Teste de conexão de internet por URL Connection: " + internetConnectionVerify.isInternetAvailableByUrlConn());
	}
}
