package com.example.food_map.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meal")
public class Meal {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "meal_name")
	private String mealName;
	
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "rate")
	private double rate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}


	
	//=====================

	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meal(String mealName, String restaurantName, int price) {
		super();
		this.mealName = mealName;
		this.restaurantName = restaurantName;
		this.price = price;
	}
	
	

}
