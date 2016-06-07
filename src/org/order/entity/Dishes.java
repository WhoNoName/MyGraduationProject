package org.order.entity;

import java.io.Serializable;

public class Dishes implements Serializable {

	private String dishesId;
	private String dishes_name;
	private double dishes_price;
	private String saller_id;
	private String dishes_imgurl;
	private String dishes_type;
	private Integer dishes_sales;
	private Double dishes_score;
	private String dishes_createtime;

	public Dishes() {

	}

	public Dishes(String dishesId, String dishes_name, double dishes_price,
			String saller_id, String dishes_imgurl, String dishes_type,
			Integer dishes_sales, Double dishes_score, String dishes_createtime) {
		super();
		this.dishesId = dishesId;
		this.dishes_name = dishes_name;
		this.dishes_price = dishes_price;
		this.saller_id = saller_id;
		this.dishes_imgurl = dishes_imgurl;
		this.dishes_type = dishes_type;
		this.dishes_sales = dishes_sales;
		this.dishes_score = dishes_score;
		this.dishes_createtime = dishes_createtime;
	}

	public String getDishesId() {
		return dishesId;
	}

	public void setDishesId(String dishesId) {
		this.dishesId = dishesId;
	}

	public String getDishes_name() {
		return dishes_name;
	}

	public void setDishes_name(String dishes_name) {
		this.dishes_name = dishes_name;
	}

	public double getDishes_price() {
		return dishes_price;
	}

	public void setDishes_price(double dishes_price) {
		this.dishes_price = dishes_price;
	}

	public String getSaller_id() {
		return saller_id;
	}

	public void setSaller_id(String saller_id) {
		this.saller_id = saller_id;
	}

	public String getDishes_imgurl() {
		return dishes_imgurl;
	}

	public void setDishes_imgurl(String dishes_imgurl) {
		this.dishes_imgurl = dishes_imgurl;
	}

	public String getDishes_type() {
		return dishes_type;
	}

	public void setDishes_type(String dishes_type) {
		this.dishes_type = dishes_type;
	}

	public Integer getDishes_sales() {
		return dishes_sales;
	}

	public void setDishes_sales(Integer dishes_sales) {
		this.dishes_sales = dishes_sales;
	}

	public Double getDishes_score() {
		return dishes_score;
	}

	public void setDishes_score(Double dishes_score) {
		this.dishes_score = dishes_score;
	}

	public String getDishes_createtime() {
		return dishes_createtime;
	}

	public void setDishes_createtime(String dishes_createtime) {
		this.dishes_createtime = dishes_createtime;
	}

	@Override
	public String toString() {
		return "Dishes [dishesId=" + dishesId + ", dishes_name=" + dishes_name
				+ ", dishes_price=" + dishes_price + ", saller_id=" + saller_id
				+ ", dishes_imgurl=" + dishes_imgurl + ", dishes_type="
				+ dishes_type + ", dishes_sales=" + dishes_sales
				+ ", dishes_score=" + dishes_score + ", dishes_createtime="
				+ dishes_createtime + "]";
	}

}
