package com.srirang.base.utilities;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://graph.facebook.com/4";
		System.out.println(HttpUtils.getData(url).toString());
	}

}
