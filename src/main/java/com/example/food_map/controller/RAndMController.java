package com.example.food_map.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_map.entity.Meal;
import com.example.food_map.entity.Restaurant;
import com.example.food_map.service.ifs.MealService;
import com.example.food_map.service.ifs.RestaurantService;
import com.example.food_map.service.vo.AddRateReq;
import com.example.food_map.service.vo.EditMealReq;
import com.example.food_map.service.vo.MealRes;
import com.example.food_map.service.vo.RAndMRes;
import com.example.food_map.service.vo.RateRes;
import com.example.food_map.service.vo.RestaurantRes;

@CrossOrigin
@RestController
public class RAndMController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private MealService mealService;
	
	@PostMapping(value = "/food_map/")
	public RestaurantRes addRestaurant(@RequestBody Restaurant r) {
		return restaurantService.addRestaurant(r);
	}
	
	@PostMapping(value = "/food_map/meal")
	public MealRes addMeal(@RequestBody Meal m) {
		return mealService.addMeal(m);
	}
	
	@PatchMapping(value = "/food_map/meal")
	public MealRes editMeal(@RequestBody EditMealReq editMealReq) {
		return mealService.editMeal(editMealReq.getMealName(), editMealReq.getRestaurantName(), editMealReq.getNewMeal());
	}
	
	@PostMapping(value = "/food_map/add_rate")
	public RateRes addRate(@RequestBody AddRateReq addRateReq) {
		return mealService.addRate(addRateReq.getMealName(), addRateReq.getRestaurantName(), addRateReq.getRate());
	}
	
	@GetMapping(value = "/food_map/{city}")
	public RAndMRes findByCityLimit(@PathVariable String city, @RequestParam int limit) {
		//注意RequestParam要用Postman中的Query Param來作測試
		
		return restaurantService.findByCityLimit(city, limit);

	}
	
	@GetMapping(value = "/food_map/find_by_rate/")
	public RAndMRes findByRate(@RequestParam double rate) {
		return restaurantService.findByRateOrderByRateDesc(rate);
	}
	
	@GetMapping(value = "/food_map/find_by_rate/r_and_m")
	public RAndMRes findByRateRAndM(@RequestParam double rate) {
		return restaurantService.findByRateOrderByRateDescRAndM(rate);
	}

}
