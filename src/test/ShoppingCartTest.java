package test;

import static org.junit.Assert.*;

import org.junit.Test;

import storefront.Product;
import storefront.ShoppingCart;

public class ShoppingCartTest {
	ShoppingCart sc = new ShoppingCart();

	@Test
	public void testCartAdd() {
		Product p = new Product("product", "prod desc", 1.0, 1, "p");
		sc.cartAdd(p, 1);
		assertTrue(sc.totalCost == 1);
		assertFalse(sc.totalCost == 0);
	}

	@Test
	public void testCartRemove() {
		Product p = new Product("product", "prod desc", 1.0, 1, "p");
		sc.cartRemove(p, 1);
		assertTrue(sc.totalCost == 0);
		assertFalse(sc.totalCost == 1);
	}

	@Test
	public void testReturnCart() {
		sc.returnCart();
		assertTrue(sc.totalCost == 0);
		assertFalse(sc.totalCost == 1);
	}

	@Test
	public void testEmptyCart() {
		assertTrue(sc.totalCost == 0);
		assertTrue(sc.count == 1);
	}

}
