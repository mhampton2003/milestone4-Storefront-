package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.junit.Test;

import junit.framework.Assert;
import storefront.InventoryManager;
import storefront.Product;

public class InventoryManagerTest {
	InventoryManager im = new InventoryManager();

	@Test
	public void testStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testSendMessage() throws IOException {
		assertEquals(im.in.readLine(), im.sendMessage("OK"));
	}

	@Test
	public void testAscendingPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testDescendingPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testAscendingName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDescendingName() {
		fail("Not yet implemented");
	}

	@Test
	public void testItemRemove() {
		Product p = new Product("product", "prod desc", 1.0, 1, "p");
		im.itemRemove(p, 1);
		assertEquals(0, p.getQuantity());
	}

	@Test
	public void testItemAdd() {
		Product p = new Product("product", "prod desc", 1.0, 1, "p");
		im.itemAdd(p, 1);
		assertEquals(2, p.getQuantity());
	}

	@Test
	public void testReturnInventory() {
		//Assert.assertEquals(, false);
	}

}
