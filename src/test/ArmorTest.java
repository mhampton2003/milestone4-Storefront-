package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import storefront.Armor;

public class ArmorTest {
	Armor armor = new Armor("armor", "protect", 12.0, 12);

	@Test
	public void testArmor() {
		Assert.assertEquals(armor, armor);
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(armor.getName(), "armor");
	}

	@Test
	public void testSetName() {
		armor.setName("helmet");
		Assert.assertEquals(armor.getName(), "helmet");
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(armor.getDescription(), "protect");
	}

	@Test
	public void testSetDescription() {
		armor.setDescription("protection");
		Assert.assertEquals(armor.getDescription(), "protection");
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(armor.getPrice() == 12.0);
	}

	@Test
	public void testSetPrice() {
		armor.setPrice(10);
		Assert.assertTrue(armor.getPrice() == 10);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(armor.getQuantity() == 12);
	}

	@Test
	public void testSetQuantity() {
		armor.setQuantity(5);
		Assert.assertTrue(armor.getQuantity() == 5);
	}

}
