package com.food.ingredients;

public class Happiness {
	
	private double flatHappiness;
	private double productMultiplier;
	private double productHappinessEffect;
	
	public Happiness(double flatHappiness, double productMultiplier, double productHappinessEffect) {
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
