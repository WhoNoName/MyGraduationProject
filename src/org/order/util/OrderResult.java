package org.order.util;

import java.io.Serializable;

public class OrderResult implements Serializable {
	private int status;// ״̬
	private String msg;// ��Ϣ
	private Object data;// ���ص�����

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "OrderResult [status=" + status + ", msg=" + msg + ", data="
				+ data + "]";
	}

}
