package test;

import static org.junit.Assert.*;
import org.junit.Test;
import storefront.FileService;
import storefront.Product;

public class FileServiceTest {
	FileService fs = new FileService();

	@Test
	public void testSaveToFile() {
		Product p = new Product("product", "base", 1.0, 1, "product");
		fs.saveToFile("inventory.txt", p, true);
		assertTrue(fs.readFromFile("inventory.txt").get(fs.readFromFile("inventory.txt").size() - 1).getName().equals(p.getName()));
		assertFalse(fs.readFromFile("inventory.txt").get(fs.readFromFile("inventory.txt").size() - 1).getName().equals("p"));
	}

	@Test
	public void testReadFromFile() {
		assertTrue(fs.readFromFile("inventory.txt").get(0).getName().equals("Mighty Sword"));
		assertFalse(fs.readFromFile("inventory.txt").get(0).getPrice() == 0.0);
	}

}
