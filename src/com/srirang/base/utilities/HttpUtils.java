package com.srirang.base.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class HttpUtils {
	
	
public static JSONObject getData(String url) {
		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		JSONObject json = new JSONObject();
		
		try {
			
			HttpResponse response = client.execute(get);
			
			if(response!=null){
				
				InputStream in = response.getEntity().getContent();
				String result= convertStreamToString(in);

				json = new JSONObject(result);
				in.close();
			}
			
		} catch (Exception ex) {
			
		} 

		return json;
	}
	
	private static String convertStreamToString(InputStream is) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
