package com.food.foodtype;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import com.food.ingredients.FoodExtra;

public class Order {

	private final List<FoodExtra> extraList;
	private final Food food;

	private Order(final Builder b) {
		this.extraList = b.extraList;
		this.food = b.food;

		for (final FoodExtra extra : b.extraList) {
			food.addExtra(extra);
		}

	}

	public void execute() {
		System.out.println("Serving food: " + food);
	}

	public Food getFood() {
		return food;
	}

	public static class Builder {
		private final List<FoodExtra> extraList = new ArrayList<>();
		private Food food;

		public Builder() {

		}

		public Builder addFood(final Food newFood) {
			if (food != null) {
				throw new IllegalArgumentException("You must not specifiy two food type for one order");
			}
			food = newFood;
			return this;
		}

		public Builder addExtra(final FoodExtra extra) {
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
