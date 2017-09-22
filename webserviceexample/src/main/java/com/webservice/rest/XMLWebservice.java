package com.webservice.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.webservice.Pojo.InputXML;
import com.webservice.Pojo.OutputXml;

@Path("/employeeDetails")
public class XMLWebservice {

	@POST
	@Path("/id")
	@Consumes(value=MediaType.APPLICATION_XML)
	@Produces(value=MediaType.APPLICATION_XML)
	public OutputXml sample(InputXML inputXml) {
		
		OutputXml output=new OutputXml();
		output.setName(inputXml.getEmployeeId());
		output.setAge("25");
		output.setCity("Mumbai");
		output.setState("MH");
		
		return output;
		
		
	}
	
}
