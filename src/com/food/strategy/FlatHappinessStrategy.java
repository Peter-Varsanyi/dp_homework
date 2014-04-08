package com.food.strategy;

import com.food.ingredients.Happiness;

public class FlatHappinessStrategy implements HappinessStrategy {

	@Override
	public double getClientHappiness(double clientHappiness, Happiness productHappiness) {

		double calculatedClientHappiness = productHappiness.getFlatHappiness();
		if (productHappiness.getProductHappinessEffect() > 0) {
			double multiplyEffect = productHappiness.getProductHappinessEffect();
			for (int i = 0; i < productHappiness.getProductMultiplier() - 1; i++) {
				System.out.println(i + " " + multiplyEffect);
				multiplyEffect *= 2;
			}
			calculatedClientHappiness += multiplyEffect;
		}
		return calculatedClientHappiness;
	}

}
