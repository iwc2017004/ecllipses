package com.ekumeed.help.ctrl;

public class Contact {
	
	private String name;
	private String password;
	private String emailid;
	private String phoneno;
	
	@Override
	public String toString() {
		return "Contact [emailid=" + emailid + ", phoneno=" + phoneno + "]";
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
