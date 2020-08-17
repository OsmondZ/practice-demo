package com.osmond.common;

public class StoreResult {
	private int code;
	private String msg;
	private Object data;
	public StoreResult(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public StoreResult(Object data) {
		this.code = 200;
		this.msg = "ok";
		this.data = data;
	}
	
	public StoreResult() {
		this.code = 200;
		this.msg = "ok";
	}
	public static StoreResult build(int code,String msg,Object data) {
		return new StoreResult(code, msg, data);
	}
	public static StoreResult ok(Object data) {
		return new StoreResult(data);

	}
	public static StoreResult ok() {
		
		return new StoreResult();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	
}
