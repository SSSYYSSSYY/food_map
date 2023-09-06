package com.example.food_map.service.ifs;

import java.util.List;

import com.example.food_map.entity.Restaurant;
import com.example.food_map.service.vo.RAndMRes;
import com.example.food_map.service.vo.RestaurantAndMealVo;
import com.example.food_map.service.vo.RestaurantRes;

public interface RestaurantService {

	//新增店家資訊
	public RestaurantRes addRestaurant(Restaurant restaurant);

	//搜尋特定城市的店家並可限制筆數
	public RAndMRes findByCityLimit(String city, int limitNum);
	
	//顯示特定評價以上的店家和餐點並依評價高>低排序
	public RAndMRes findByRateOrderByRateDesc(double rate);
	
	//顯示特定評價以上的店家和特定評價以上的餐點並依評價高>低排序
	public RAndMRes findByRateOrderByRateDescRAndM(double rate);
}
