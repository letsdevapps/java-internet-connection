package com.pro.internet.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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

	public static boolean isInternetAvailable(String host) {
		try {
			Process process = Runtime.getRuntime().exec("ping -c 1 " + host);
			int returnVal = process.waitFor();
			return (returnVal == 0);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	flags diferentes por SO: -c 1 em Linux/macOS; -n 1 em Windows.
	public static boolean pingHost(String host) {
		String countFlag = System.getProperty("os.name").toLowerCase().contains("win") ? "-n" : "-c";
		ProcessBuilder pb = new ProcessBuilder(Arrays.asList("ping", countFlag, "1", host));
		pb.redirectErrorStream(true);
		try {
			Process p = pb.start();
			try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				String line;
				StringBuilder sb = new StringBuilder();
				while ((line = r.readLine()) != null)
					sb.append(line).append('\n');
				int exit = p.waitFor();
				return exit == 0; // exit 0 normalmente significa sucesso
			}
		} catch (Exception e) {
			return false;
		}
	}
}
