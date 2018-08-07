package com.sczh.core.web.dto;

/** 通用数据格式  */

public class Result {
	private boolean success;
	private String message;
	private Object userdata;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

	public Result(boolean success, String message, Object userdata) {
		this(success, message);
		this.userdata = userdata;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getUserdata() {
		return userdata;
	}

	public void setUserdata(Object userdata) {
		this.userdata = userdata;
	}
}
