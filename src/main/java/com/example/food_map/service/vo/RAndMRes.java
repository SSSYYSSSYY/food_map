package com.example.food_map.service.vo;

import java.util.List;

public class RAndMRes {
	
	
	private String code;
	
	private String msg;
	
	private List<RAndMList> rAndMList;

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

	public List<RAndMList> getrAndMList() {
		return rAndMList;
	}

	public void setrAndMList(List<RAndMList> rAndMList) {
		this.rAndMList = rAndMList;
	}

	public RAndMRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RAndMRes(String code, String msg, List<RAndMList> rAndMList) {
		super();
		this.code = code;
		this.msg = msg;
		this.rAndMList = rAndMList;
	}
	
	
}
