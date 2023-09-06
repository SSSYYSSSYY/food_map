package com.example.food_map.service.ifs;

import java.util.List;

import com.example.food_map.entity.Restaurant;
import com.example.food_map.service.vo.RAndMRes;
import com.example.food_map.service.vo.RestaurantAndMealVo;
import com.example.food_map.service.vo.RestaurantRes;

public interface RestaurantService {

	//�s�W���a��T
	public RestaurantRes addRestaurant(Restaurant restaurant);

	//�j�M�S�w���������a�åi�����
	public RAndMRes findByCityLimit(String city, int limitNum);
	
	//��ܯS�w�����H�W�����a�M�\�I�è̵�����>�C�Ƨ�
	public RAndMRes findByRateOrderByRateDesc(double rate);
	
	//��ܯS�w�����H�W�����a�M�S�w�����H�W���\�I�è̵�����>�C�Ƨ�
	public RAndMRes findByRateOrderByRateDescRAndM(double rate);
}
