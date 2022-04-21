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
		assertEquals(2, sc.cart.get(0));
	}

	@Test
	public void testCartRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnCart() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmptyCart() {
		fail("Not yet implemented");
	}

}
