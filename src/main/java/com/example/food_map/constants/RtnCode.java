package com.example.food_map.constants;

public enum RtnCode {
	
	SUCCESSFUL("200", "successful!"),
	DATA_ERROR("400", "data error!"),
	ERROR_EXISTED("400", "existed!"),
	ERROR_MAX("400", "meals max!"),
	ERROR_NOT_FOUNT("404", "not found!");
	
	
	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private RtnCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
	
	
}
