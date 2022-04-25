package test;

import org.junit.Assert;
import org.junit.Test;

import storefront.Armor;

public class ArmorTest {
	Armor armor = new Armor("armor", "protect", 12.0, 12);
	
	@Test
	public void testGetName() {
		Assert.assertEquals(armor.getName(), "armor");
		Assert.assertFalse(armor.getName().equals("armor2"));
	}

	@Test
	public void testSetName() {
		armor.setName("helmet");
		Assert.assertEquals(armor.getName(), "helmet");
		Assert.assertFalse(armor.getName().equals("armor"));
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(armor.getDescription(), "protect");
		Assert.assertFalse(armor.getDescription().equals("protect2"));
	}

	@Test
	public void testSetDescription() {
		armor.setDescription("protection");
		Assert.assertEquals(armor.getDescription(), "protection");
		Assert.assertFalse(armor.getDescription().equals("protect"));
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(armor.getPrice() == 12.0);
		Assert.assertFalse(armor.getPrice() == 13.0);
	}

	@Test
	public void testSetPrice() {
		armor.setPrice(10);
		Assert.assertTrue(armor.getPrice() == 10.0);
		Assert.assertFalse(armor.getPrice() == 12.0);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(armor.getQuantity() == 12);
		Assert.assertFalse(armor.getQuantity() == 10);
	}

	@Test
	public void testSetQuantity() {
		armor.setQuantity(5);
		Assert.assertTrue(armor.getQuantity() == 5);
		Assert.assertFalse(armor.getQuantity() == 12);
	}

}
