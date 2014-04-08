package com.food.restaurant;

import javax.naming.directory.InvalidAttributesException;

import com.food.foodtype.Food;
import com.food.foodtype.Hotdog;
import com.food.foodtype.Order;
import com.food.ingredients.Ketchup;
import com.food.ingredients.Mustard;
import com.food.strategy.FlatHappinessStrategy;
import com.food.strategy.HappinessStrategy;

public class Restaurant {
	public static void main(String[] args) {
		HappinessStrategy strategy = new FlatHappinessStrategy();

		Hotdog hotdog = new Hotdog(strategy);

		Ketchup ketchup = new Ketchup();
		Mustard mustard = new Mustard();

		try {
			Order x = new Order.Builder().addFood(hotdog).addExtra(ketchup).addExtra(ketchup).build();
			Food food = x.getFood();
			System.out.println(food.getHappiness(100));
		} catch (InvalidAttributesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
