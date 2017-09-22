package com.webservice.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class SalesforceHandler
 */
public class SalesforceHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String WebServiceURL="https://ap5.salesforce.com/services/apexrest/AccountDetails";
	
    /**
     * Default constructor. 
     */
    public SalesforceHandler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Client restClient=null;
		ArrayList<String> ArrayList=new ArrayList<String>();
		try {
		String accessToken=Salesforce_Utility.generateAccessToken();
		JSONParser parser=new JSONParser();
		restClient=Client.create();
		WebResource resource2=restClient.resource(WebServiceURL);
		String resp= resource2.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer "+accessToken).get(String.class);
		System.out.println(resp);
		List<JSONObject> object2=(List<JSONObject>)parser.parse(resp);
		for(JSONObject oj:object2) {
			ArrayList.add(oj.get("Name").toString());
		}
		restClient.destroy();
		}catch(Exception e) {
			restClient.destroy();
		}	
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Html="<html><body><h2>Account Detail Page</h2><form action=\"SalesforceHandler\" method=\"ge\"><input type=\"submit\" value=\"Get Account Details\"/>"
				+"</form>"
				+ "<table border=\"1\">"
				+"<thead><th>Account Name From Salesforce</th></thead>";
				for(String s:ArrayList) {
					
					Html+="<tr><td>"+s+"</td></tr>";
				}
				Html+="</table></body></html>";
				
				out.print(Html);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
