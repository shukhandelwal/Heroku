package com.webservice.Pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Employee")
public class InputXML {
	
	private String employeeId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
