package com.example.food_map.service.ifs;

import com.example.food_map.entity.Meal;
import com.example.food_map.service.vo.MealRes;
import com.example.food_map.service.vo.RateRes;

public interface MealService {

	//�s�W�\�I��T
	public MealRes addMeal(Meal meal);
	
	//�ק��\�I��T
	public MealRes editMeal(String meal, String restaurant, Meal newInfo);
	
	//���\�I�s�W����
	public RateRes addRate(String meal, String restaurant, double rate);
}
