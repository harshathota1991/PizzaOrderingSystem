


package com.gsu.pos.dao;




import java.util.ArrayList;

import com.gsu.pos.bean.FoodBean;



public interface FoodDAO {
	String createFood (FoodBean foodbean);
	int deleteFood (ArrayList<String> foodId);
	ArrayList<FoodBean> findAll ();
	ArrayList<String> findAllID ();
	FoodBean findByID (String foodId);
	boolean updateFood (FoodBean foodbean);
}
