package com.test.schedule.domain.condition;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserQueryModel implements Serializable {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
