package com.example.food_map.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.food_map.entity.Meal;
import com.example.food_map.entity.Restaurant;
import com.example.food_map.service.vo.RAndMList;
import com.example.food_map.service.vo.RateRes;
import com.example.food_map.service.vo.RestaurantAndMealVo;
import com.example.food_map.service.vo.RestaurantRes;

public interface RestaurantDao extends JpaRepository<Restaurant, String>{

	//把店家評價設置成餐點評價的平均
//	@Modifying
//	@Transactional
//	@Query(value = "update Restaurant as r set r.rate = avg(Meal.rate) where Meal.restaurantName = :restaurant")
	@Query(value = "select round(avg(m.rate), 1) from Meal as m where m.restaurantName = :restaurant ")
	public double getAvgRate(@Param("restaurant")String restaurant);
	
//	@Query(value = "select * from restaurant as r where "
//			+ "city like concat('%', :city, '%') limit :limitNum", nativeQuery = true)
//	public List<Restaurant> findByCityLimit(@Param("city")String city, @Param("limitNum")int limitNum);
//	
//	@Query(value = "select * from restaurant as r where "
//			+ "city like concat('%', :city, '%')", nativeQuery = true)
//	public List<Restaurant> findByCityNotLimit(@Param("city")String city);
//
//	
//	//把兩個join方法的SQL語句再加上where做城市搜尋
//	
//	@Query(value = "select new com.example.food_map.service.vo.RestaurantAndMealVo(r.name, r.city, r.rate, m.mealName, m.rate, m.price)"
//			+ " from Restaurant as r join Meal as m on r.name = m.restaurantName "
//			+ " where r.city like :city")
//	public List<RestaurantAndMealVo> joinRAndM(@Param("city") String city);
//	
//	@Query(value = "select new com.example.food_map.service.vo.RestaurantAndMealVo(r.name, r.city, r.rate, m.mealName, m.rate, m.price)"
//			+ " from Restaurant as r join Meal as m on r.name = m.restaurantName "
//			+ " where r.city like :city")
//	public List<RestaurantAndMealVo> joinRAndMLimit(@Param("city") String city);
//	
//	//, @Param("limitNum") int limitNum
//	
//	@Query(value = "select new com.example.food_map.service.vo.RestaurantAndMealVo(r.name, r.city, r.rate, m.mealName, m.rate, m.price)"
//			+ " from Restaurant as r join Meal as m on r.name = m.restaurantName"
//			+ " where r.rate >= :rate")
//	public List<RAndMList> findByRate(@Param("rate") double rate);
	
	public List<Restaurant> findByCityContaining(String city);
	
	public List<Restaurant> findByRateGreaterThanEqualOrderByRateDesc(double rate);
}
