package com.food.main;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import com.food.foodtype.Chips;
import com.food.foodtype.Food;
import com.food.foodtype.Hotdog;
import com.food.foodtype.Order;
import com.food.ingredients.Ketchup;
import com.food.ingredients.Mustard;
import com.food.strategy.FlatHappinessStrategy;
import com.food.strategy.HappinessStrategy;
import com.food.strategy.PercentageHappinessStrategy;

public class Restaurant {
	private final Hotdog hotdog;
	private final Ketchup ketchup;
	private final Mustard mustard;

	private final List<Order> orders;
	private final Food chips;
	private final HappinessStrategy flatStrategy;
	private final HappinessStrategy percentStrategy;

	public Restaurant() {
		orders = new ArrayList<>();
		flatStrategy = new FlatHappinessStrategy();
		percentStrategy = new PercentageHappinessStrategy();

		hotdog = new Hotdog(flatStrategy);
		chips = new Chips(percentStrategy);
		ketchup = new Ketchup();
		mustard = new Mustard();

	}

	public void takeOrders() {
		try {
			orders.add(new Order.Builder().addFood(new Hotdog(flatStrategy)).addExtra(ketchup).addExtra(ketchup)
					.build());
			orders.add(new Order.Builder().addFood(new Hotdog(flatStrategy)).addExtra(mustard).addExtra(ketchup)
					.build());
			orders.add(new Order.Builder().addFood(new Hotdog(flatStrategy)).addExtra(mustard).addExtra(mustard)
					.build());

			orders.add(new Order.Builder().addFood(new Chips(percentStrategy)).addExtra(ketchup).addExtra(ketchup)
					.build());
			orders.add(new Order.Builder().addFood(new Chips(percentStrategy)).addExtra(mustard).addExtra(ketchup)
					.build());
			orders.add(new Order.Builder().addFood(new Chips(percentStrategy)).addExtra(mustard).addExtra(mustard)
					.build());

			orders.add(new Order.Builder().addFood(new Chips(percentStrategy)).addExtra(mustard).addExtra(ketchup)
					.build());
		} catch (final InvalidAttributesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void open() {
		takeOrders();
		serveOrders();
	}

	private void serveOrders() {
		for (final Order order : orders) {
			order.execute();
		}

	}
}
