package com.example.food_map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.food_map.entity.Meal;
import com.example.food_map.repository.MealDao;
import com.example.food_map.service.ifs.MealService;
import com.example.food_map.service.vo.MealRes;
import com.example.food_map.service.vo.RateRes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = FoodMapApplication.class)
public class MealServiceTest {

	@Autowired
	private MealService mealService;
	
	@Autowired
	private MealDao mealDao;
	
	@Test
	public void addMealTest() {
		Meal m = new Meal("�K�y����", "��á�A����", 200);
		MealRes res = mealService.addMeal(m);
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
	public void editMealTest() {
		Meal newM = new Meal("�S��ͳ����j�����q", "�߿߼�����", 800);
		MealRes res = mealService.editMeal("�S��ͳ����j��", "�߿߼�����", newM);
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
	public void addRateTest() {
		RateRes res = mealService.addRate("���Ū���", "��á�A����", 4);
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
