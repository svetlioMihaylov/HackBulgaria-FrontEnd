package com.hack.application.logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpLogger extends AbstractLogger {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Scanner scanner = new Scanner(System.in);
		int level=scanner.nextInt();
		String messag=scanner.nextLine();
		scanner.close();
		Logger logger = new HttpLogger();
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://www.a-domain.com/foo/");
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("param-1", logger.log(level, messag)));
		 httpclient.execute(httppost);
	}
}
