package com.food.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Before;
import org.junit.Test;

import com.food.foodtype.Chips;
import com.food.foodtype.Hotdog;
import com.food.foodtype.Order;
import com.food.ingredients.Happiness;
import com.food.ingredients.Ketchup;
import com.food.ingredients.Mustard;
import com.food.strategy.FlatHappinessStrategy;
import com.food.strategy.HappinessStrategy;
import com.food.strategy.PercentageHappinessStrategy;

public class OrderTest {

	private static final HappinessStrategy flatStrategy = new FlatHappinessStrategy();
	private static final HappinessStrategy percentageStrategy = new PercentageHappinessStrategy();
	private Hotdog hotdog;
	private Chips chips;
	private static final Ketchup ketchup = new Ketchup();
	private static final Mustard mustard = new Mustard();

	@Test
	public void a() {
		fail();
	}

	@Before
	public void setupTest() {
		hotdog = new Hotdog(flatStrategy);
		chips = new Chips(percentageStrategy);
	}

	@Test
	public void testKetchupMustardMustardHotdog() throws InvalidAttributesException {
		System.out.println("mustard ketchup ketchup");
		final Order order = new Order.Builder().addFood(hotdog).addExtra(ketchup).addExtra(mustard).addExtra(mustard)
				.build();
		assertEquals(2, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testMustardMustardKetchupHotdog() throws InvalidAttributesException {
		final Order order = new Order.Builder().addFood(hotdog).addExtra(mustard).addExtra(mustard).addExtra(ketchup)
				.build();
		assertEquals(2, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupKetchupKetchupHotdog() throws Exception {
		final Order order = new Order.Builder().addFood(hotdog).addExtra(ketchup).addExtra(ketchup).addExtra(ketchup)
				.build();
		assertEquals(16, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupHotdog() throws Exception {
		final Order order = new Order.Builder().addFood(hotdog).addExtra(ketchup).build();
		assertEquals(4, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testEmptyHotdog() throws Exception {
		final Order order = new Order.Builder().addFood(hotdog).build();
		assertEquals(2, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupWithHotdog() {
		final Happiness base = new Happiness(0, 1, 2);
		final Happiness ketchupResult = ketchup.getHappiness(base);
		final double result = flatStrategy.getClientHappiness(10, ketchupResult);
		assertEquals(4, result, 0);
	}

	@Test
	public void testMustardWithHotdog() {
		final Happiness base = new Happiness(0, 1, 2);
		final Happiness ketchupResult = mustard.getHappiness(base);
		final double result = flatStrategy.getClientHappiness(10, ketchupResult);
		assertEquals(1, result, 0);
	}

	@Test
	public void testKetchupWithChips() {
		final Happiness base = new Happiness(0, 1, 1.05);
		final Happiness ketchupResult = ketchup.getHappiness(base);
		final double result = percentageStrategy.getClientHappiness(10, ketchupResult);
		assertEquals(11.025, result, 0);
	}

	@Test
	public void testMustardWithChips() {
		final Happiness base = new Happiness(0, 1, 1.05);
		final Happiness ketchupResult = mustard.getHappiness(base);
		final double result = percentageStrategy.getClientHappiness(10, ketchupResult);
		assertEquals(1, result, 0);
	}

	@Test
	public void testEmptyChips() throws Exception {
		final Order order = new Order.Builder().addFood(chips).build();
		assertEquals(10.5, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupChips() throws Exception {
		final Order order = new Order.Builder().addFood(chips).addExtra(ketchup).build();
		assertEquals(11.025, order.getFood().getHappiness(10), 1E-15);
	}

}
