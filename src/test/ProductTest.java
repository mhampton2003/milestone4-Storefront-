package test;

import org.junit.Assert;
import org.junit.Test;

import storefront.Product;

public class ProductTest {
	Product product = new Product("product", "base", 10.0, 10, "p");

	@Test
	public void testCompareTo() {
		Product p = new Product("product", "base", 10.0, 10, "p");
		Assert.assertEquals(0, product.compareTo(p));
		Assert.assertFalse(product.compareTo(p) == 1);
	}

	@Test
	public void testToString() {
		Assert.assertEquals("product", product.toString());
		Assert.assertFalse(product.toString().equals("p"));
	}

	@Test
	public void testGetType() {
		Assert.assertEquals(product.getType(), "p");
		Assert.assertFalse(product.getType().equals("product"));
	}

	@Test
	public void testSetType() {
		product.setType("prod");
		Assert.assertEquals(product.getType(), "prod");
		Assert.assertFalse(product.getType().equals("p"));
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(product.getName(), "product");
		Assert.assertFalse(product.getName().equals("p"));
	}

	@Test
	public void testSetName() {
		product.setName("pt");
		Assert.assertEquals(product.getName(), "pt");
		Assert.assertFalse(product.getName().equals("product"));
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(product.getDescription(), "base");
		Assert.assertFalse(product.getDescription().equals("parent"));
	}

	@Test
	public void testSetDescription() {
		product.setDescription("parent");
		Assert.assertEquals(product.getDescription(), "parent");
		Assert.assertFalse(product.getDescription().equals("base"));
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(product.getPrice() == 10.0);
		Assert.assertFalse(product.getPrice() == 11.0);
	}

	@Test
	public void testSetPrice() {
		product.setPrice(12);
		Assert.assertTrue(product.getPrice() == 12.0);
		Assert.assertFalse(product.getPrice() == 10.0);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(product.getQuantity() == 10);
		Assert.assertFalse(product.getQuantity() == 12);
	}

	@Test
	public void testSetQuantity() {
		product.setQuantity(5);
		Assert.assertTrue(product.getQuantity() == 5);
		Assert.assertFalse(product.getQuantity() == 10);
	}

}
