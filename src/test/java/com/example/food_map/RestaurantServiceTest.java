package com.example.food_map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.food_map.entity.Restaurant;
import com.example.food_map.repository.RestaurantDao;
import com.example.food_map.service.ifs.RestaurantService;
import com.example.food_map.service.vo.RAndMRes;
import com.example.food_map.service.vo.RestaurantRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = FoodMapApplication.class)
public class RestaurantServiceTest {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Test
	public void addRestaurantTest() {
		Restaurant r = new Restaurant("海獺鮮魚店", "台南市");
		RestaurantRes res = restaurantService.addRestaurant(r);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String str = mapper.writeValueAsString(res);
			System.out.println(str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("====================");
		
//		Assert.isTrue(res != null, "add failed!");
	}
	
	@Test
	public void findByCityLimitTest() {
		RAndMRes res = restaurantService.findByCityLimit("台", 0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String str = mapper.writeValueAsString(res);
			System.out.println(str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("====================");
	}
	
	@Test
	public void findByRate() {
		RAndMRes res = restaurantService.findByRateOrderByRateDesc(2);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String str = mapper.writeValueAsString(res);
			System.out.println(str);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("====================");
	}
}
