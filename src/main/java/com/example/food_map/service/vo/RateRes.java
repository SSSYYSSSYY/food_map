package com.example.food_map.service.vo;

import com.example.food_map.entity.Meal;

public class RateRes {

	private String code;
	
	private String msg;
	
	private double rateBefore;
	
	private double rateAfter;
	
	private Meal meal;
	
	//===================

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

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

	public double getRateBefore() {
		return rateBefore;
	}

	public void setRateBefore(double rateBefore) {
		this.rateBefore = rateBefore;
	}

	public double getRateAfter() {
		return rateAfter;
	}

	public void setRateAfter(double rateAfter) {
		this.rateAfter = rateAfter;
	}
	
	//=======================

	public RateRes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RateRes(String code, String msg, double rateBefore, double rateAfter, Meal meal) {
		super();
		this.code = code;
		this.msg = msg;
		this.rateBefore = rateBefore;
		this.rateAfter = rateAfter;
		this.meal = meal;
	}
	
	
}
