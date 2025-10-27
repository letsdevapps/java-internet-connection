package com.pro.internet.connection;

import java.net.HttpURLConnection;
import java.net.URL;

public class InternetConnectionVerifyByUrlConn {

	public static boolean isInternetAvailable() {
		try {
			URL url = new URL("http://www.google.com");
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setConnectTimeout(2000); // 2 segundos
			urlConn.connect();
			if (urlConn.getResponseCode() == 200) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isInternetAvailable(String testUrl) {
		try {
			URL url = new URL(testUrl);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setConnectTimeout(2000); // 2 segundos
			urlConn.connect();
			if (urlConn.getResponseCode() == 200) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isInternetAvailableHttps() {
		try {
			// URL do Google (ou qualquer outro site confiável)
			URL url = new URL("https://www.google.com");

			// Estabelecendo a conexão
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD"); // Usando HEAD para não baixar o conteúdo
			connection.setConnectTimeout(2000); // Timeout de 2 segundos
			connection.setReadTimeout(2000); // Timeout de leitura de 2 segundos

			// Se a resposta for 200 (OK), a Internet está funcionando
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				System.out.println("Conexão com a Internet estabelecida.");
				return true;
			} else {
				System.out.println("Sem conexão com a Internet. Código de resposta: " + responseCode);
				return false;
			}
		} catch (Exception e) {
			System.out.println("Erro ao verificar a conexão com a Internet: " + e.getMessage());
			return false;
		}
	}

//	Exemplo de URL para testar: http://www.google.com, https://www.cloudflare.com/cdn-cgi/trace 
//	(alguns serviços retornam rapidamente).
	public static boolean checkHttp(String urlString, int timeoutMs) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.setConnectTimeout(timeoutMs);
			conn.setReadTimeout(timeoutMs);
			conn.connect();
			int code = conn.getResponseCode();
			conn.disconnect();
			return (code >= 200 && code < 400);
		} catch (Exception e) {
			return false;
		}
	}
}
