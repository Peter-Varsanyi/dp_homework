package com.food.foodtype;

import com.food.ingredients.Happiness;
import com.food.strategy.HappinessStrategy;

public class Hotdog extends Food {
	private final HappinessStrategy strategy;

	public Hotdog(final HappinessStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public double calculateHappiness(final double clientHappiness, final Happiness happiness) {
		return strategy.getClientHappiness(clientHappiness, happiness);
	}

	@Override
	public Happiness getFoodHappiness() {
		return new Happiness(0, 1, 2);
	}

}
