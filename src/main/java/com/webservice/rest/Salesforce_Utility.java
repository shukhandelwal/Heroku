package com.webservice.rest;

import java.io.BufferedReader;
import java.net.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Salesforce_Utility {
	
	private static final String URL="https://login.salesforce.com/services/oauth2/token?";
	private static final String USERNAME="shubhamk0392@gmail.com";
	private static final String PASSWORD="$Tom121$s4GYSDzkV1baXpRlgMEB97QJ";
	private static final String GRANT_TYPE="password";
	private static final String CLIENT_ID="3MVG9d8..z.hDcPLDwff3rt_o38B8Oq8hJG.y1xUNpZChZFA6_3.CdH42AIa1S.xVwFGFaf5FGOMCG6mxMkoh";
	private static final String CLIENT_SECRET="9000079168882344807";
	
	
	public static String generateAccessToken() throws ParseException {
		String accessToken=null;
		
		String oAuthURL=URL+"username="+USERNAME+"&password="+PASSWORD+"&grant_type="+GRANT_TYPE+"&client_id="+CLIENT_ID
				+"&client_secret="+CLIENT_SECRET;
		
		Client webServiceClient=Client.create();
		WebResource resource=webServiceClient.resource(oAuthURL);
		String response=resource.post(String.class);
		JSONParser parser=new JSONParser();
		JSONObject object=(JSONObject)parser.parse(response);
		accessToken=object.get("access_token").toString();
		webServiceClient.destroy();
		return accessToken;
	} 
	

}
