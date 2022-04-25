package test;

import static org.junit.Assert.*;
import org.junit.Test;
import storefront.InventoryManager;
import storefront.Product;

public class InventoryManagerTest {
	InventoryManager im = new InventoryManager();
	
	@Test
	public void testItemRemove() {
		Product p = new Product("product", "prod desc", 1.0, 1, "p");
		im.itemRemove(p, 1);
		assertTrue(p.getQuantity() == 0);
		assertFalse(p.getQuantity() == 1);
	}

	@Test
	public void testItemAdd() {
		Product p = new Product("product", "prod desc", 1.0, 1, "p");
		im.itemAdd(p, 1);
		assertTrue(p.getQuantity() == 2);
		assertFalse(p.getQuantity() == 0);
	}

	@Test
	public void testReturnInventory() {
		assertTrue(im.returnInventory().equals("Mighty Sword,is the sharpest in the land,4,50.0\n"
+"Longbow,is a beginner's Elvin bow that can shoot enemies from a distance,2,120.0\n"
+"Basic Helmet,prevents minor concussions,12,60.0\n"
+"Basic Chestplate,prevents bruising,10,80.0\n"
+"Healing Potion,heals 75% of the player's health,120,30.0\n"));
		assertFalse(im.returnInventory().equals(""));
	}
}
