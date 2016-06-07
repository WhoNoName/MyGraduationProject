package org.order.entity;

import java.util.Date;

public class User {

	private String userId;
	private String user_name;
	private String password;
	private String user_picture_url;
	private String dishes_address;
	private String phone_num;
	private String email;
	private Integer user_permission;
	private Date user_create_time;

	public User() {

	}

	public User(String userId, String user_name) {
		this.userId = userId;
		this.user_name = user_name;
	}

	public User(String userId, String user_name, String password,
			String user_picture_url, String dishes_address, String phone_num,
			String email, Integer user_permission, Date user_create_time) {
		super();
		this.userId = userId;
		this.user_name = user_name;
		this.password = password;
		this.user_picture_url = user_picture_url;
		this.dishes_address = dishes_address;
		this.phone_num = phone_num;
		this.email = email;
		this.user_permission = user_permission;
		this.user_create_time = user_create_time;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_picture_url() {
		return user_picture_url;
	}

	public void setUser_picture_url(String user_picture_url) {
		this.user_picture_url = user_picture_url;
	}

	public String getDishes_address() {
		return dishes_address;
	}

	public void setDishes_address(String dishes_address) {
		this.dishes_address = dishes_address;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUser_permission() {
		return user_permission;
	}

	public void setUser_permission(Integer user_permission) {
		this.user_permission = user_permission;
	}

	public Date getUser_create_time() {
		return user_create_time;
	}

	public void setUser_create_time(Date user_create_time) {
		this.user_create_time = user_create_time;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", user_name=" + user_name
				+ ", password=" + password + ", user_picture_url="
				+ user_picture_url + ", dishes_address=" + dishes_address
				+ ", phone_num=" + phone_num + ", email=" + email
				+ ", user_permission=" + user_permission
				+ ", user_create_time=" + user_create_time + "]";
	}

}
