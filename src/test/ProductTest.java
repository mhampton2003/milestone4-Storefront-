package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import storefront.Product;

public class ProductTest {
	Product product = new Product("product", "base", 10.0, 10, "p");

	@Test
	public void testProduct() {
		Assert.assertEquals(product, product);
	}

	@Test
	public void testProductStringStringDoubleIntString() {
		Assert.assertEquals(product, product);
	}

	@Test
	public void testCompareTo() {
		Product p = new Product("product", "base", 10.0, 10, "p");
		Assert.assertEquals(0, product.compareTo(p));
	}

	@Test
	public void testToString() {
		Assert.assertEquals("product", product.toString());
	}

	@Test
	public void testGetType() {
		Assert.assertEquals(product.getType(), "p");
	}

	@Test
	public void testSetType() {
		product.setType("prod");
		Assert.assertEquals(product.getType(), "prod");
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(product.getName(), "product");
	}

	@Test
	public void testSetName() {
		product.setName("pt");
		Assert.assertEquals(product.getName(), "pt");
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals(product.getDescription(), "base");
	}

	@Test
	public void testSetDescription() {
		product.setDescription("parent");
		Assert.assertEquals(product.getDescription(), "parent");
	}

	@Test
	public void testGetPrice() {
		Assert.assertTrue(product.getPrice() == 10.0);
	}

	@Test
	public void testSetPrice() {
		product.setPrice(12);
		Assert.assertTrue(product.getPrice() == 12);
	}

	@Test
	public void testGetQuantity() {
		Assert.assertTrue(product.getQuantity() == 10);
	}

	@Test
	public void testSetQuantity() {
		product.setQuantity(5);
		Assert.assertTrue(product.getQuantity() == 5);
	}

}
