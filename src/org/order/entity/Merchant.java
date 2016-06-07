package org.order.entity;

import java.util.Date;

public class Merchant {

	private String merchantId;
	private String merchant_name;
	private String password;
	private String merchant_picture_url;
	private String merchant_address;
	private String phone_num;
	private String email;
	private Integer merchant_permission;
	private Date merchant_create_time;
	private Integer merchant_sales;
	private String merchant_type;
	private Integer avg_time;
	private Double score;
	private Integer merchant_all_sales;

	public Merchant() {

	}

	public Merchant(String merchantId, String merchant_name, String password,
			String merchant_picture_url, String merchant_address,
			String phone_num, String email, Integer merchant_permission,
			Date merchant_create_time, Integer merchant_sales,
			String merchant_type, Integer avg_time, Double score,
			Integer merchant_all_sales) {
		super();
		this.merchantId = merchantId;
		this.merchant_name = merchant_name;
		this.password = password;
		this.merchant_picture_url = merchant_picture_url;
		this.merchant_address = merchant_address;
		this.phone_num = phone_num;
		this.email = email;
		this.merchant_permission = merchant_permission;
		this.merchant_create_time = merchant_create_time;
		this.merchant_sales = merchant_sales;
		this.merchant_type = merchant_type;
		this.avg_time = avg_time;
		this.score = score;
		this.merchant_all_sales = merchant_all_sales;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMerchant_picture_url() {
		return merchant_picture_url;
	}

	public void setMerchant_picture_url(String merchant_picture_url) {
		this.merchant_picture_url = merchant_picture_url;
	}

	public String getMerchant_address() {
		return merchant_address;
	}

	public void setMerchant_address(String merchant_address) {
		this.merchant_address = merchant_address;
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

	public Integer getMerchant_permission() {
		return merchant_permission;
	}

	public void setMerchant_permission(Integer merchant_permission) {
		this.merchant_permission = merchant_permission;
	}

	public Date getMerchant_create_time() {
		return merchant_create_time;
	}

	public void setMerchant_create_time(Date merchant_create_time) {
		this.merchant_create_time = merchant_create_time;
	}

	public Integer getMerchant_sales() {
		return merchant_sales;
	}

	public void setMerchant_sales(Integer merchant_sales) {
		this.merchant_sales = merchant_sales;
	}

	public String getMerchant_type() {
		return merchant_type;
	}

	public void setMerchant_type(String merchant_type) {
		this.merchant_type = merchant_type;
	}

	public Integer getAvg_time() {
		return avg_time;
	}

	public void setAvg_time(Integer avg_time) {
		this.avg_time = avg_time;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getMerchant_all_sales() {
		return merchant_all_sales;
	}

	public void setMerchant_all_sales(Integer merchant_all_sales) {
		this.merchant_all_sales = merchant_all_sales;
	}

	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchant_name="
				+ merchant_name + ", password=" + password
				+ ", merchant_picture_url=" + merchant_picture_url
				+ ", merchant_address=" + merchant_address + ", phone_num="
				+ phone_num + ", email=" + email + ", merchant_permission="
				+ merchant_permission + ", merchant_create_time="
				+ merchant_create_time + ", merchant_sales=" + merchant_sales
				+ ", merchant_type=" + merchant_type + ", avg_time=" + avg_time
				+ ", score=" + score + ", merchant_all_sales="
				+ merchant_all_sales + "]";
	}

}
