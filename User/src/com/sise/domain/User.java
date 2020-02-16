package com.sise.domain;

public class User {
  private int uid;
  private String username;
  private String password;
  private String telephone;
	private int state;
	private String email;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
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
public String getPhone() {
	return telephone;
}
public void setPhone(String phone) {
	this.telephone = phone;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", telephone=" + telephone
			+ ", state=" + state + ", email=" + email + "]";
}

//shift+alt+s 生成tostring和get， set方法

}