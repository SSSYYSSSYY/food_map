package com.example.food_map.service.ifs;

import com.example.food_map.entity.Meal;
import com.example.food_map.service.vo.MealRes;
import com.example.food_map.service.vo.RateRes;

public interface MealService {

	//新增餐點資訊
	public MealRes addMeal(Meal meal);
	
	//修改餐點資訊
	public MealRes editMeal(String meal, String restaurant, Meal newInfo);
	
	//為餐點新增評價
	public RateRes addRate(String meal, String restaurant, double rate);
}
