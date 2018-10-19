package com.vns.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	public static String get(String urls){
        String strRead = null;
		try {
			HttpURLConnection conn = null;
		    BufferedReader reader = null;
			URL url = new URL(urls);
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-Length","content.length");
	        conn.setUseCaches(false);
	        conn.setInstanceFollowRedirects(false);
	        conn.connect();
	        InputStream is = conn.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is));
	        strRead = reader.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		return strRead;
	}
}
