package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import storefront.Health;

public class HealthTest {
	Health health = new Health("health", "heal", 5.0, 5);

	@Test
	public void testHealth() {
		Assert.assertEquals(health, health);
	}
	
	@Test
	public void testGetName() {
		Assert.assertEquals(health.getName(), "health");
	}

	@Test
	public void testSetName() {
		health.setName("potion");
		Assert.assertEquals(health.getName(), "potion");
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(health.getDescription(), "heal");
	}

	@Test
	public void testSetDescription() {
		health.setDescription("healing");
		Assert.assertEquals(health.getDescription(), "healing");
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(health.getPrice() == 5.0);
	}

	@Test
	public void testSetPrice() {
		health.setPrice(10);
		Assert.assertTrue(health.getPrice() == 10);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(health.getQuantity() == 5);
	}

	@Test
	public void testSetQuantity() {
		health.setQuantity(10);
		Assert.assertTrue(health.getQuantity() == 10);
	}

}
