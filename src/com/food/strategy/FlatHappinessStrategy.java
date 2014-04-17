package com.food.strategy;

import com.food.ingredients.Happiness;

public class FlatHappinessStrategy implements HappinessStrategy {

	@Override
	public double getClientHappiness(final double clientHappiness, final Happiness productHappiness) {

		double calculatedClientHappiness = productHappiness.getFlatHappiness();
		if (productHappiness.getProductHappinessEffect() > 0) {
			double multiplyEffect = productHappiness.getProductHappinessEffect();
			for (int i = 0; i < productHappiness.getProductMultiplier() - 1; i++) {
				multiplyEffect *= 2;
			}
			calculatedClientHappiness += multiplyEffect;
		}
		return calculatedClientHappiness;
	}

}
