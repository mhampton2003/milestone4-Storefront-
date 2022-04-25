package test;

import org.junit.Assert;
import org.junit.Test;

import storefront.Weapon;

public class WeaponTest {
	Weapon weapon = new Weapon("weapon", "fight", 10.0, 10);

	@Test
	public void testGetName() {
		Assert.assertEquals(weapon.getName(), "weapon");
		Assert.assertFalse(weapon.getName().equals("weapon2"));
	}

	@Test
	public void testSetName() {
		weapon.setName("sword");
		Assert.assertEquals(weapon.getName(), "sword");
		Assert.assertFalse(weapon.getName().equals("weapon"));
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(weapon.getDescription(), "fight");
		Assert.assertFalse(weapon.getDescription().equals("fighting"));
	}

	@Test
	public void testSetDescription() {
		weapon.setDescription("fighting");
		Assert.assertEquals(weapon.getDescription(), "fighting");
		Assert.assertFalse(weapon.getDescription().equals("fight"));
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(weapon.getPrice() == 10.0);
		Assert.assertFalse(weapon.getPrice() == 11.0);
	}

	@Test
	public void testSetPrice() {
		weapon.setPrice(12);
		Assert.assertTrue(weapon.getPrice() == 12);
		Assert.assertFalse(weapon.getPrice() == 10);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(weapon.getQuantity() == 10);
		Assert.assertFalse(weapon.getQuantity() == 11);
	}

	@Test
	public void testSetQuantity() {
		weapon.setQuantity(5);
		Assert.assertTrue(weapon.getQuantity() == 5);
		Assert.assertFalse(weapon.getQuantity() == 10);
	}

}
