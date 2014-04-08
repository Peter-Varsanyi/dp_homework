package com.food.strategy;

import com.food.ingredients.Happiness;

public interface HappinessStrategy {
	public double getClientHappiness(double clientHappiness, Happiness productHappiness);
}
