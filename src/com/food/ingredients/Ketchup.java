package com.food.ingredients;

public class Ketchup implements FoodExtra {

	@Override
	public Happiness getHappiness(Happiness happiness) {
		System.out.println("In ketchup: " + happiness);
		return new Happiness(happiness.getFlatHappiness(), happiness.getProductMultiplier() + 1,
				happiness.getProductHappinessEffect());
	}

}
