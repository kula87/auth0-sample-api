package com.auth0.samples.secure;

public class User {
	private String connection;
	private String email;
	private boolean email_verified;
	private String user_id;
	private String password;
	private boolean verify_email;
	private String username;
	private boolean blocked;
	private String given_name;
	private String family_name;
	
	
	public User(String connection, String email, boolean email_verified, String user_id, String password,
			boolean verify_email, String username, boolean blocked, String given_name, String family_name) {
		super();
		this.connection = connection;
		this.email = email;
		this.email_verified = email_verified;
		this.user_id = user_id;
		this.password = password;
		this.verify_email = verify_email;
		this.username = username;
		this.blocked = blocked;
		this.given_name = given_name;
		this.family_name = family_name;
	}


	public String getConnection() {
		return connection;
	}


	public void setConnection(String connection) {
		this.connection = connection;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isEmail_verified() {
		return email_verified;
	}


	public void setEmail_verified(boolean email_verified) {
		this.email_verified = email_verified;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isVerify_email() {
		return verify_email;
	}


	public void setVerify_email(boolean verify_email) {
		this.verify_email = verify_email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public boolean isBlocked() {
		return blocked;
	}


	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}


	public String getGiven_name() {
		return given_name;
	}


	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}


	public String getFamily_name() {
		return family_name;
	}


	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}


	@Override
	public String toString() {
		return "User [connection=" + connection + ", email=" + email + ", email_verified=" + email_verified
				+ ", user_id=" + user_id + ", password=" + password + ", verify_email=" + verify_email + ", username="
				+ username + ", blocked=" + blocked + ", given_name=" + given_name + ", family_name=" + family_name
				+ "]";
	}
	
	
}
