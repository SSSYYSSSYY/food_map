package com.example.food_map.service.vo;

import com.example.food_map.entity.Meal;

public class EditMealReq {

	private String mealName;
	
	private String restaurantName;
	
	private Meal newMeal;

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

	public Meal getNewMeal() {
		return newMeal;
	}

	public void setNewMeal(Meal newMeal) {
		this.newMeal = newMeal;
	}

	public EditMealReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditMealReq(String mealName, String restaurantName, Meal newMeal) {
		super();
		this.mealName = mealName;
		this.restaurantName = restaurantName;
		this.newMeal = newMeal;
	}
	
	
}
