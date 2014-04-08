package com.food.foodtype;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import com.food.ingredients.FoodExtra;
import com.food.strategy.HappinessStrategy;

public class Order {

	private List<FoodExtra> extraList;
	private Food food;

	private Order(Builder b) {
		this.extraList = b.extraList;
		this.food = b.food;

		for (FoodExtra extra : extraList) {
			this.food.addExtra(extra);
		}

	}

	public Food getFood() {
		return food;
	}

	public static class Builder {
		private List<FoodExtra> extraList = new ArrayList<>();
		private Food food;

		public Builder addFood(Food newFood) {
			if (food != null) {
				throw new IllegalArgumentException("You must not specifiy two food type for one order");
			}
			food = newFood;
			return this;
		}

		public Builder addExtra(FoodExtra extra) {
			extraList.add(extra);
			return this;
		}

		public Order build() throws InvalidAttributesException {
			if (food == null) {
				throw new IllegalArgumentException("You must specify at least one food type");
			}
			return new Order(this);
		}
	}

}
