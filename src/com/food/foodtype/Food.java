package com.food.foodtype;

import java.util.ArrayList;
import java.util.List;

import com.food.ingredients.FoodExtra;
import com.food.ingredients.Happiness;

public abstract class Food {
	private final List<FoodExtra> extraList = new ArrayList<>();

	public double getHappiness(final double clientHappiness) {
		Happiness happiness = getFoodHappiness();
		for (final FoodExtra extra : extraList) {
			happiness = extra.getHappiness(happiness);
		}
		return calculateHappiness(clientHappiness, happiness);
	}

	public abstract Happiness getFoodHappiness();

	public abstract double calculateHappiness(double clientHappiness, Happiness happiness);

	public void addExtra(final FoodExtra extra) {
		extraList.add(extra);
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName() + " [extraList=");
		builder.append(extraList);
		builder.append(", happiness=");
		builder.append(getFoodHappiness());
		builder.append("]");
		return builder.toString();
	}
}
