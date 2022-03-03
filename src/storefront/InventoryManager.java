package storefront;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryManager {
	
	/**
	 * creates file and writes the JSON of products to it
	 * @param filename The name of the file to be written to
	 * @param car The Product that is being written
	 * @param append Allows more text to be written
	 */
	public void saveToFile(String filename, Product p, boolean append) {
		PrintWriter pw;
		try {
			//create a file File to write
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			//write car as JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(p);
			pw.println(json);
			
			//cleanup printwriter
			pw.close();
		}
		//prints IOException message
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * reads JSON from file and returns as Products
	 * @param filename The file that is being read from
	 * @return cars The arraylist that contains the products
	 */
	public ArrayList<Product> readFromFile(String filename){
		ArrayList<Product> inventory = new ArrayList<Product>();
		try {
			//open the file File to read
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			//create list of Products by reading JSON file
			while(s.hasNext()) {
				//read a string of JSON and convert to a Product
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				Product product = objectMapper.readValue(json, Product.class);
				inventory.add(product);
			}
			
			//cleanup scanner
			s.close();
		}
		//prints IOException message
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return inventory;
	}
	
	/**
	 * removes an item from the inventory's stock
	 * @param p product that is being removed from the inventory
	 * @param userQuantity quantity of the product that is being removed
	 */
	public void itemRemove(Product p, int userQuantity) {
		//removes desired quantity from the product's stock
		p.setQuantity(p.getQuantity() - userQuantity);
		//p.quantity = p.quantity - userQuantity;
	}
	
	/**
	 * adds an item to the inventory's stock
	 * @param p product that is being added to the inventory
	 * @param userQuantity quantity of the product that is being added
	 */
	public void itemAdd(Product p, int userQuantity) {
		//adds desired quantity to the product's stock
		p.quantity = p.quantity + userQuantity;
	}
	
	/**
	 * returns the inventory
	 */
	public void returnInventory() {
		//creates arrayList of items from JSON
		ArrayList<Product> itemsList = readFromFile("inventory.txt");
		for (Product p : itemsList) {
			//prints each product with commas between each attribute
			String text = p.getName() + "," + p.getDescription() + "," +
					Integer.toString(p.getQuantity()) + "," +
					Double.toString(p.getPrice()) + "," +
					Double.toString(p.getDurability());
			System.out.println(text);
		}
	}
}