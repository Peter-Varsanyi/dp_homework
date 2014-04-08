package com.food.strategy;

import com.food.ingredients.Happiness;

public class PercentageHappinessStrategy implements HappinessStrategy {

	@Override
	public double getClientHappiness(double clientHappiness, Happiness productHappiness) {

		double calculatedClientHappiness = 1;
		if (productHappiness.getProductHappinessEffect() > 0) {
			double multiplyEffect = productHappiness.getProductHappinessEffect();
			for (int i = 0; i < productHappiness.getProductMultiplier() - 1; i++) {
				multiplyEffect *= 2;
			}
			calculatedClientHappiness = clientHappiness * multiplyEffect;
		}
		return calculatedClientHappiness;
	}

}
