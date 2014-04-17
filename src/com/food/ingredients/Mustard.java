package com.food.ingredients;

public class Mustard implements FoodExtra {
	@Override
	public Happiness getHappiness(final Happiness happiness) {
		return new Happiness(happiness.getFlatHappiness() + 1, happiness.getProductMultiplier(), 0);
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Mustard");
		return builder.toString();
	}
}
