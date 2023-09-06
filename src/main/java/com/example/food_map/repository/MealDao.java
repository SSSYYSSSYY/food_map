package com.example.food_map.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.food_map.entity.Meal;

public interface MealDao extends JpaRepository<Meal, String>{

	//查詢特定餐廳的餐點數量
	@Query(value = "select count(m) from Meal as m where m.restaurantName = :restaurant")
	public int findByRestaurant(@Param("restaurant") String restaurant);
	
	//確認表中是否有餐點名稱相同&餐廳名稱相同的資料
	@Query(value = "select count(m) from Meal as m where m.restaurantName = :restaurant and m.mealName = :meal")
	public int findByRestaurantAndMeal(@Param("restaurant") String restaurant,@Param("meal") String meal);

	@Query(value = "select m from Meal as m where m.restaurantName = :restaurant and m.mealName = :meal")
	public Meal getAMeal(@Param("restaurant") String restaurant,@Param("meal") String meal);
	
	public List<Meal> findByRestaurantName(String restaurantName);
	
	@Modifying
	@Transactional
	@Query(value = "update Meal as m set m.mealName = :newMealName, m.restaurantName = :newRestaurantName, m.price = :newPrice"
			+ " where restaurantName = :restaurant and mealName = :meal")
	public void updateMeal(@Param("restaurant") String restaurant, @Param("meal") String meal, 
			@Param("newMealName")String newMealName, @Param("newRestaurantName")String newRestaurantName, @Param("newPrice")int newPrice);
	
	public List<Meal> findByRateGreaterThanEqual(double rate);
}
