import static org.junit.Assert.assertEquals;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Before;
import org.junit.Test;

import com.food.foodtype.Chips;
import com.food.foodtype.Hotdog;
import com.food.foodtype.Order;
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

	@Before
	public void setupTest() {
		hotdog = new Hotdog(flatStrategy);
		chips = new Chips(percentageStrategy);
	}

	@Test
	public void testKetchupMustardMustardHotdog() throws InvalidAttributesException {
		System.out.println("mustard ketchup ketchup");
		Order order = new Order.Builder().addFood(hotdog).addExtra(ketchup).addExtra(mustard).addExtra(mustard).build();
		assertEquals(2, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testMustardMustardKetchupHotdog() throws InvalidAttributesException {
		Order order = new Order.Builder().addFood(hotdog).addExtra(mustard).addExtra(mustard).addExtra(ketchup).build();
		assertEquals(2, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupKetchupKetchupHotdog() throws Exception {
		Order order = new Order.Builder().addFood(hotdog).addExtra(ketchup).addExtra(ketchup).addExtra(ketchup).build();
		assertEquals(16, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupHotdog() throws Exception {
		Order order = new Order.Builder().addFood(hotdog).addExtra(ketchup).build();
		assertEquals(4, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testEmptyHotdog() throws Exception {
		Order order = new Order.Builder().addFood(hotdog).build();
		assertEquals(2, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testEmptyChips() throws Exception {
		Order order = new Order.Builder().addFood(chips).build();
		assertEquals(10.5, order.getFood().getHappiness(10), 1E-15);
	}

	@Test
	public void testKetchupChips() throws Exception {
		Order order = new Order.Builder().addFood(chips).addExtra(ketchup).build();
		assertEquals(11.025, order.getFood().getHappiness(10), 1E-15);
	}

}
