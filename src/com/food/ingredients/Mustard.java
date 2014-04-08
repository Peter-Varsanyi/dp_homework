package com.food.ingredients;

public class Mustard implements FoodExtra {
	@Override
	public Happiness getHappiness(Happiness happiness) {
		System.out.println("In mustard" + happiness);
		return new Happiness(happiness.getFlatHappiness() + 1, happiness.getProductMultiplier(), 0);
	}
}
