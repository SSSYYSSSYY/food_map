package com.example.food_map.service.vo;

public class RestaurantAndMealVo {
	
	private String restaurantName;
	
	private double rateOfRestaurant;
	
	private String city;
	
	private String mealName;
	
	private double rateOfMeal;
	
	private int price;


	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public double getRateOfRestaurant() {
		return rateOfRestaurant;
	}

	public void setRateOfRestaurant(double rateOfRestaurant) {
		this.rateOfRestaurant = rateOfRestaurant;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public double getRateOfMeal() {
		return rateOfMeal;
	}

	public void setRateOfMeal(double rateOfMeal) {
		this.rateOfMeal = rateOfMeal;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public RestaurantAndMealVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantAndMealVo(String restaurantName, String city, double rateOfRestaurant, String mealName,
			double rateOfMeal, int price) {
		super();
		this.restaurantName = restaurantName;
		this.rateOfRestaurant = rateOfRestaurant;
		this.city = city;
		this.mealName = mealName;
		this.rateOfMeal = rateOfMeal;
		this.price = price;
	}


	
	

}
