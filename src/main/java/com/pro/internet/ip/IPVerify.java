package com.pro.internet.ip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class IPVerify {
	
	public IPVerify() {
	}

	public static void getExternalIP() {
        try {
            // URL do serviço que retorna o IP externo
            URL url = new URL("http://checkip.amazonaws.com");
            
            // Estabelecendo a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Lendo a resposta do serviço
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String externalIP = reader.readLine();  // O IP retornado será uma linha só
            reader.close();
            
            // Exibindo o IP externo
            System.out.println("Seu IP externo é: " + externalIP);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void getInternalIP() {
        try {
            // Obtém o endereço IP da máquina local
            InetAddress localHost = InetAddress.getLocalHost();
            
            // Exibe o endereço IP da máquina local
            System.out.println("Seu IP interno é: " + localHost.getHostAddress());
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
