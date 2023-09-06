package com.example.food_map.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.food_map.constants.RtnCode;
import com.example.food_map.entity.Meal;
import com.example.food_map.entity.Restaurant;
import com.example.food_map.repository.MealDao;
import com.example.food_map.repository.RestaurantDao;
import com.example.food_map.service.ifs.RestaurantService;
import com.example.food_map.service.vo.RAndMList;
import com.example.food_map.service.vo.RAndMRes;
import com.example.food_map.service.vo.RestaurantAndMealVo;
import com.example.food_map.service.vo.RestaurantRes;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private MealDao mealDao;
	
	private boolean isParamOk(Restaurant restaurant) {
		if(restaurant == null) {
			return false;
		}
		
		if(!StringUtils.hasText(restaurant.getName()) || !StringUtils.hasText(restaurant.getCity())) {
			return false;
		}
		
		return true;
	}

	@Override
	public RestaurantRes addRestaurant(Restaurant restaurant) {
		
		if(!isParamOk(restaurant)) {
			return new RestaurantRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), null);
		}
		
		if(restaurantDao.existsById(restaurant.getName())) {
			return new RestaurantRes(RtnCode.ERROR_EXISTED.getCode(), RtnCode.ERROR_EXISTED.getMsg(), null);
		}
		
		restaurantDao.save(restaurant);
		return new RestaurantRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), new ArrayList<Restaurant>(Arrays.asList(restaurant)));
	}

	@Override
	public RAndMRes findByCityLimit(String city, int limitNum) {
		
		if(!StringUtils.hasText(city) || limitNum < 0) {
			return new RAndMRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), null);
		}
		
		List<Restaurant> rList = restaurantDao.findByCityContaining(city);
		List<RAndMList> rAndMList = new ArrayList<>();
		
		for(Restaurant r : rList) {
			List<Meal> mList = mealDao.findByRestaurantName(r.getName());
			RAndMList rAndM = new RAndMList();
			rAndM.setRestaurant(r.getName());
			rAndM.setCity(r.getCity());
			rAndM.setRate(r.getRate());
			rAndM.setmList(mList);
			rAndMList.add(rAndM);
		}
		
		
		if(limitNum == 0) {
//			List<RAndMList> res = restaurantDao.findByCityNotLimitWithJoin(city);
//			return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), res);
			return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), rAndMList);
			
		}else {
//			List<RAndMList> res = restaurantDao.findByCityLimitWithJoin(city, limitNum);
//			return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), res);
			List<RAndMList> subList = rAndMList.subList(0, limitNum);
			return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), subList);
		}
	
	}

	@Override
	public RAndMRes findByRateOrderByRateDesc(double rate) {
		if(rate <= 0) {
			return new RAndMRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), null);
		}
		List<Restaurant> rList = restaurantDao.findByRateGreaterThanEqualOrderByRateDesc(rate);
		List<RAndMList> rAndMList = new ArrayList<>();
//		return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), res);
		for(Restaurant r : rList) {
			List<Meal> mList = mealDao.findByRestaurantName(r.getName());
			RAndMList rAndM = new RAndMList();
			rAndM.setRestaurant(r.getName());
			rAndM.setCity(r.getCity());
			rAndM.setRate(r.getRate());
			rAndM.setmList(mList);
			rAndMList.add(rAndM);
		}
		return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), rAndMList);
	}

	@Override
	public RAndMRes findByRateOrderByRateDescRAndM(double rate) {
		if(rate <= 0) {
			return new RAndMRes(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMsg(), null);
		}
		
		//回傳用 每筆資料代表一個餐廳 每個餐廳底下都有一個餐點list跟餐廳資訊
		List<RAndMList> rAndMList = new ArrayList<>();
		
		//符合條件的餐廳List
		List<Restaurant> rList = restaurantDao.findByRateGreaterThanEqualOrderByRateDesc(rate);
		
		//符合條件的餐點List
		List<Meal> mList = mealDao.findByRateGreaterThanEqual(rate);
		
		for(Restaurant r : rList) {
			RAndMList rAndM = new RAndMList();
			ArrayList<Meal> mListInR = new ArrayList<>();
			for(Meal m : mList) {
				if(m.getRestaurantName().equals(r.getName())) {
					mListInR.add(m);
				}
			}
			rAndM.setRestaurant(r.getName());
			rAndM.setCity(r.getCity());
			rAndM.setRate(r.getRate());
			rAndM.setmList(mListInR);
			rAndMList.add(rAndM);
			
		}
		return new RAndMRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMsg(), rAndMList);
	}

}
