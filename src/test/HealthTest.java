package test;

import org.junit.Assert;
import org.junit.Test;

import storefront.Health;

public class HealthTest {
	Health health = new Health("health", "heal", 5.0, 5);

	@Test
	public void testGetName() {
		Assert.assertEquals(health.getName(), "health");
		Assert.assertFalse(health.getName().equals("health2"));
	}

	@Test
	public void testSetName() {
		health.setName("potion");
		Assert.assertEquals(health.getName(), "potion");
		Assert.assertFalse(health.getName().equals("health"));
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(health.getDescription(), "heal");
		Assert.assertFalse(health.getDescription().equals("healing"));
	}

	@Test
	public void testSetDescription() {
		health.setDescription("healing");
		Assert.assertEquals(health.getDescription(), "healing");
		Assert.assertFalse(health.getDescription().equals("heal"));
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(health.getPrice() == 5.0);
		Assert.assertFalse(health.getPrice() == 6);
	}

	@Test
	public void testSetPrice() {
		health.setPrice(10);
		Assert.assertTrue(health.getPrice() == 10);
		Assert.assertFalse(health.getPrice() == 5.0);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(health.getQuantity() == 5);
		Assert.assertFalse(health.getQuantity() == 6);
	}

	@Test
	public void testSetQuantity() {
		health.setQuantity(10);
		Assert.assertTrue(health.getQuantity() == 10);
		Assert.assertFalse(health.getQuantity() == 5);
	}

}
