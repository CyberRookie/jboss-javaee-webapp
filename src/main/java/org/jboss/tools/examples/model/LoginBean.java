package org.jboss.tools.examples.model;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Table;

@Named
@Table(name="login")
@RequestScoped
public class LoginBean implements Serializable {
	
	
	private int id;
	private String username;
	private String password;


	public LoginBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}


}
