package com.yashraj.yashrajhibernate.handleobject;

import org.json.JSONObject;

import com.yashraj.yashrajhibernate.newapicall.NewApiCall;

public class ValueExtracterFromJSON {
	
	public static String valueExracter(String url) throws Exception {
        
		//url = "https://api.ipify.org/?format=json";
        String response = NewApiCall.getApiResponse(url);

        //String jsonResponse = "{\"ip\": \"117.97.144.223\"}";

        // Parse JSON response
        JSONObject jsonObject = new JSONObject(response);

        // Get the value of the "ip" key
        String ipAddress = jsonObject.getString("ip");
        
        return ipAddress;
    }
}
