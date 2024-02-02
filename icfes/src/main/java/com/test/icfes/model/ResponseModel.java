package com.test.icfes.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8234563707332032529L;
	private int code;  
	private String message;
	private Object body;	
	
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int ok) {
		this.code = ok;
	}

}
