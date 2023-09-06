package com.example.food_map.service.vo;

import com.example.food_map.entity.Meal;

public class MealRes {
	
	private String code;
	
	private String msg;
	
	private Meal meal;
	
	//=====================

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

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	//======================

	public MealRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MealRes(String code, String msg, Meal meal) {
		super();
		this.code = code;
		this.msg = msg;
		this.meal = meal;
	}
	
	

}
