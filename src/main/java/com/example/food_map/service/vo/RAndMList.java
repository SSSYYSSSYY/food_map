package com.example.food_map.service.vo;

import java.util.List;

import com.example.food_map.entity.Meal;

public class RAndMList {
	
	private String restaurant;
	
	private String city;
	
	private double rate;
	
	private List<Meal> mList;

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public List<Meal> getmList() {
		return mList;
	}

	public void setmList(List<Meal> mList) {
		this.mList = mList;
	}

	public RAndMList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RAndMList(String restaurant, String city, double rate, List<Meal> mList) {
		super();
		this.restaurant = restaurant;
		this.city = city;
		this.rate = rate;
		this.mList = mList;
	}
	
	
}
