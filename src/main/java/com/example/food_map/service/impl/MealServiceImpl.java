package com.example.food_map.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.food_map.constants.RtnCode;
import com.example.food_map.entity.Meal;
import com.example.food_map.entity.Restaurant;
import com.example.food_map.repository.MealDao;
import com.example.food_map.repository.RestaurantDao;
import com.example.food_map.service.ifs.MealService;
import com.example.food_map.service.vo.MealRes;
import com.example.food_map.service.vo.RateRes;

@Service
public class MealServiceImpl implements MealService{

	@Autowired
	private MealDao mealDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	private boolean isParamOk(Meal meal) {
//		if(meal == null) {
//			return false;
//		}
		if(meal == null || !StringUtils.hasText(meal.getMealName()) || !StringUtils.hasText(meal.getRestaurantName()) || meal.getPrice() <= 0) {
			return false;
		}

		return true;
	}
	
	@Override
	public MealRes addMeal(Meal meal) {
		
		if(!isParamOk(meal)) {
			return new MealRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), null);
		}
		
		if(!restaurantDao.existsById(meal.getRestaurantName())) {
			return new MealRes(RtnCode.ERROR_NOT_FOUNT.getCode(), RtnCode.ERROR_NOT_FOUNT.getMsg(), null);
		}
		
		if(mealDao.findByRestaurantAndMeal(meal.getRestaurantName(), meal.getMealName()) != 0) {
			return new MealRes(RtnCode.ERROR_EXISTED.getCode(), RtnCode.ERROR_EXISTED.getMsg(), null);
		}
		
		if(mealDao.findByRestaurant(meal.getRestaurantName()) >= 3) {
			return new MealRes(RtnCode.ERROR_MAX.getCode(), RtnCode.ERROR_MAX.getMsg(), null);
		}

		mealDao.save(meal);
		return new MealRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), meal);
		
	}

	@Override
	public MealRes editMeal(String meal, String restaurant, Meal newInfo) {
		if(!StringUtils.hasText(meal) || !StringUtils.hasText(restaurant) || newInfo == null) {
			return new MealRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), null);
		}
		
		if(mealDao.findByRestaurantAndMeal(restaurant, meal) == 0) {
			return new MealRes(RtnCode.ERROR_NOT_FOUNT.getCode(), RtnCode.ERROR_NOT_FOUNT.getMsg(), null);
		}
		
		if(!StringUtils.hasText(newInfo.getMealName()) && newInfo.getPrice() > 0) {
			//修改價格
		}else if(StringUtils.hasText(newInfo.getMealName()) && newInfo.getPrice() <= 0) {
			//修改餐點名稱
		}else {
			//修改價格和名稱
		}
		
		mealDao.updateMeal(restaurant, meal,newInfo.getMealName(), newInfo.getRestaurantName(), newInfo.getPrice());
		
		Meal res = mealDao.getAMeal(newInfo.getRestaurantName(), newInfo.getMealName());
//		res.setMealName(newInfo.getMealName());
//		res.setRestaurantName(newInfo.getRestaurantName());
//		res.setPrice(newInfo.getPrice());
		
		mealDao.save(res);
		return new MealRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), res);
		
	}

	@Override
	public RateRes addRate(String meal, String restaurant, double rate) {
		if(!StringUtils.hasText(meal) || !StringUtils.hasText(restaurant) || rate < 1 || rate > 5) {
			return new RateRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), 0, 0, null);
		}
		
		if(mealDao.findByRestaurantAndMeal(restaurant, meal) == 0) {
			return new RateRes(RtnCode.ERROR_NOT_FOUNT.getCode(), RtnCode.ERROR_NOT_FOUNT.getMsg(), 0, 0, null);
		}

		
		double rateBefore = restaurantDao.getAvgRate(restaurant);
		Meal m = mealDao.getAMeal(restaurant, meal); 
		m.setRate(rate);
		mealDao.save(m);
		double rateAfter = restaurantDao.getAvgRate(restaurant);
		Optional<Restaurant> rOp = restaurantDao.findById(restaurant);
		Restaurant r = rOp.get();
		r.setRate(rateAfter);
		restaurantDao.save(r);
		return new RateRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), rateBefore, rateAfter, m);
	}

}
