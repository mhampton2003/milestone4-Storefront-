package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import storefront.Weapon;

public class WeaponTest {
	Weapon weapon = new Weapon("weapon", "fight", 10.0, 10);

	@Test
	public void testWeapon() {
		Assert.assertEquals(weapon, weapon);
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(weapon.getName(), "weapon");
	}

	@Test
	public void testSetName() {
		weapon.setName("sword");
		Assert.assertEquals(weapon.getName(), "sword");
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(weapon.getDescription(), "fight");
	}

	@Test
	public void testSetDescription() {
		weapon.setDescription("fighting");
		Assert.assertEquals(weapon.getDescription(), "fighting");
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(weapon.getPrice() == 10.0);
	}

	@Test
	public void testSetPrice() {
		weapon.setPrice(12);
		Assert.assertTrue(weapon.getPrice() == 12);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(weapon.getQuantity() == 10);
	}

	@Test
	public void testSetQuantity() {
		weapon.setQuantity(5);
		Assert.assertTrue(weapon.getQuantity() == 5);
	}

}
