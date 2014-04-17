package com.food.ingredients;

public class Ketchup implements FoodExtra {

	@Override
	public Happiness getHappiness(final Happiness happiness) {
		return new Happiness(happiness.getFlatHappiness(), happiness.getProductMultiplier() + 1,
				happiness.getProductHappinessEffect());
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Ketchup");
		return builder.toString();
	}

}
