package com.pro.internet;

import java.net.InetAddress;

public class InternetConnectionVerifyByInetAddress {

	public static boolean isInternetAvailable() {
		try {
			InetAddress address = InetAddress.getByName("www.google.com");
			return !address.equals("");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isInternetAvailable(String host) {
		try {
			InetAddress address = InetAddress.getByName(host);
			return !address.equals("");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isInternetAvailableDns() {
		try {
			// Tentando se conectar ao Google DNS (8.8.8.8)
			InetAddress inetAddress = InetAddress.getByName("8.8.8.8");

			// Verificando se a máquina consegue se conectar ao Google DNS
			if (inetAddress.isReachable(2000)) { // Timeout de 2 segundos
				System.out.println("Conexão com a Internet estabelecida.");
				return true;
			} else {
				System.out.println("Sem conexão com a Internet.");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Erro ao verificar a conexão com a Internet: " + e.getMessage());
			return false;
		}
	}
}
