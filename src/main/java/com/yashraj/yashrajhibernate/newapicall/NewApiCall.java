package com.yashraj.yashrajhibernate.newapicall;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewApiCall {
	public static String getApiResponse(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);

        HttpURLConnection newConnection = (HttpURLConnection) url.openConnection();

        newConnection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(newConnection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        newConnection.disconnect();

        return response.toString();
    }
	
}
