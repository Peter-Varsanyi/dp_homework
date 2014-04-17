package com.food.strategy;

import com.food.ingredients.Happiness;

public class PercentageHappinessStrategy implements HappinessStrategy {

	@Override
	public double getClientHappiness(final double clientHappiness, final Happiness productHappiness) {

		double calculatedClientHappiness = 1;
		if (productHappiness.getProductHappinessEffect() > 0) {
			double multiplyEffect = productHappiness.getProductHappinessEffect();

			for (int i = 0; i < productHappiness.getProductMultiplier() - 1; i++) {
				multiplyEffect *= multiplyEffect;
			}

			calculatedClientHappiness = clientHappiness * multiplyEffect;
		}
		return calculatedClientHappiness;
	}

}
