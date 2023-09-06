package com.example.food_map.service.vo;

public class AddRateReq {

	private String mealName;
	
	private String restaurantName;
	
	private double rate;

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public AddRateReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddRateReq(String mealName, String restaurantName, double rate) {
		super();
		this.mealName = mealName;
		this.restaurantName = restaurantName;
		this.rate = rate;
	}
	
	
}
