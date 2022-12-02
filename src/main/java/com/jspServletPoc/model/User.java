package com.jspServletPoc.model;

import java.io.Serializable;



public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	
	private String emailId;
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
