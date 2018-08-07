package com.sczh.core.exception;

public class SystemException extends RuntimeException {
	private String errorCode;
	private String customMsg;

	public String getCustomMsg() {
		return customMsg;
	}

	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	private static final long serialVersionUID = 1L;
	
	public SystemException(String errorCode){
		super();
		this.errorCode = errorCode;
	}

	public SystemException(String errorCode,String message) {
		super(message);
		this.customMsg = message;
		this.errorCode = errorCode;
	}

	public SystemException(String errorCode,Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public SystemException(String errorCode,String message, Throwable cause) {
		super(message, cause);
		this.customMsg = message;
		this.errorCode = errorCode;
	}
	
	

}
