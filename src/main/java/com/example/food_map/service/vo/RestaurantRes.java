package com.example.food_map.service.vo;

import java.util.List;

import com.example.food_map.entity.Restaurant;

public class RestaurantRes {
	
	private String code;
	
	private String msg;
	
	private Restaurant restaurant;
	
	private List<Restaurant> rList;
	
	//===========================

	public List<Restaurant> getrList() {
		return rList;
	}

	public void setrList(List<Restaurant> rList) {
		this.rList = rList;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	//=========================

	public RestaurantRes() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public RestaurantRes(String code, String msg, Restaurant restaurant) {
//		super();
//		this.code = code;
//		this.msg = msg;
//		this.restaurant = restaurant;
//	}

	public RestaurantRes(String code, String msg, List<Restaurant> rList) {
		super();
		this.code = code;
		this.msg = msg;
		this.rList = rList;
	}
	
	

}
