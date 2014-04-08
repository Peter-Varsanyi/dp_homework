package com.food.foodtype;

import java.util.ArrayList;
import java.util.List;

import com.food.ingredients.FoodExtra;
import com.food.ingredients.Happiness;

public abstract class Food {
	private List<FoodExtra> extraList = new ArrayList<>();

	public double getHappiness(double clientHappiness) {
		System.out.println("Gethappy");
		System.out.println(extraList.size());
		Happiness happiness = getFoodHappiness();
		for (FoodExtra extra : extraList) {
			happiness = extra.getHappiness(happiness);

		}
		System.out.println("Final happiness" + happiness);
		return calculateHappiness(clientHappiness, happiness);
	}

	public abstract Happiness getFoodHappiness();

	public abstract double calculateHappiness(double clientHappiness, Happiness happiness);

	public void addExtra(FoodExtra extra) {
		extraList.add(extra);

	}
}
