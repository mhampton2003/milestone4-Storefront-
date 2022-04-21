package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import junit.framework.Assert;
import storefront.FileService;

public class FileServiceTest {
	FileService fs = new FileService();

	@Test
	public void testSaveToFile() {
		Assert.assertTrue(new File("inventory.txt"));
	}

	@Test
	public void testReadFromFile() {
		fail("Not yet implemented");
	}

}
