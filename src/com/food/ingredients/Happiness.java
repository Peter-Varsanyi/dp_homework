package com.food.ingredients;

public class Happiness {

	private final double flatHappiness;
	private final double productMultiplier;
	private final double productHappinessEffect;

	public Happiness(final double flatHappiness, final double productMultiplier, final double productHappinessEffect) {
		this.flatHappiness = flatHappiness;
		this.productMultiplier = productMultiplier;
		this.productHappinessEffect = productHappinessEffect;
	}

	public double getFlatHappiness() {
		return flatHappiness;
	}

	public double getProductMultiplier() {
		return productMultiplier;
	}

	public double getProductHappinessEffect() {
		return productHappinessEffect;
	}

	@Override
	public String toString() {
		return "Happiness [flatHappiness=" + flatHappiness + ", productMultiplier=" + productMultiplier
				+ ", productHappinessEffect=" + productHappinessEffect + "]";
	}

}
