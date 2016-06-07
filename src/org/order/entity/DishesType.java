package org.order.entity;

import java.io.Serializable;

public class DishesType implements Serializable {

	private String type_id;
	private String type_des;

	public DishesType() {
	
	}

	public DishesType(String type_id, String type_des) {
		this.type_id = type_id;
		this.type_des = type_des;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_des() {
		return type_des;
	}

	public void setType_des(String type_des) {
		this.type_des = type_des;
	}

	@Override
	public String toString() {
		return "DishesType [type_id=" + type_id + ", type_des=" + type_des
				+ "]";
	}

}
