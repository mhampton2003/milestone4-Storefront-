package storefront;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryManager {
	
	/**
	 * Sorts the products in ascending order by price
	 */
	public void ascendingPrice() {
		ArrayList<Double> p = new ArrayList<Double>();
		//fills array with prices of products
		for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
			p.add(readFromFile("inventory.txt").get(i).getPrice());
		}
		
		//uses collections to sort prices
		Collections.sort(p);
	    
		System.out.println("Products in ascending order by price:");
		// For each loop to iterate
	    for (Double d : p) {
		    // Print the sorted ArrayList
	    	for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
	    		//if the price is equal to the price of the product, print out info for that product
		    	if (d == readFromFile("inventory.txt").get(i).getPrice()) {
		    		System.out.println(d + ", " + readFromFile("inventory.txt").get(i).getName() + ", " + 
		    				readFromFile("inventory.txt").get(i).getDescription() + ", " + 
		    				readFromFile("inventory.txt").get(i).getQuantity());
		    	}
	    	}
	    }
	}
	
	/**
	 * sorts products in descending order by price
	 */
	public void descendingPrice() {
		ArrayList<Double> p = new ArrayList<Double>();
		//fills array with prices of products
		for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
			p.add(readFromFile("inventory.txt").get(i).getPrice());
		}
		
		//uses collections to sort
	    Collections.sort(p, Collections.reverseOrder());
	    
	    System.out.println("Products in descending order by price:");
	    //for each loop to iterate
	    for (Double d : p) {
		    // Print the sorted ArrayList
	    	for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
	    		//if the price is equal to the price of the product, print out info for that product
		    	if (d == readFromFile("inventory.txt").get(i).getPrice()) {
		    		System.out.println(d + ", " + readFromFile("inventory.txt").get(i).getName() + ", " + 
		    				readFromFile("inventory.txt").get(i).getDescription() + ", " + 
		    				readFromFile("inventory.txt").get(i).getQuantity());
		    	}
	    	}
		}
	}
	
	/**
	 * sorts products in ascending order by name
	 */
	public void ascendingName() {
		ArrayList<String> s = new ArrayList<String>();
		//fills array with names of products
		for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
			s.add(readFromFile("inventory.txt").get(i).getName());
		}
		
		//uses collections to sort
		Collections.sort(s);
	    
		System.out.println("Products in ascending order by name:");
		// For each loop to iterate
	    for (String str : s) {
	      // Print the sorted ArrayList
	    	for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
	    		//if the name is equal to the name of the product, print out info for that product
	    		if (str.equals(readFromFile("inventory.txt").get(i).getName())) {
	    			System.out.println(str + ", " + 
	    				readFromFile("inventory.txt").get(i).getPrice() + ", " + 
	    				readFromFile("inventory.txt").get(i).getDescription() + ", " + 
	    				readFromFile("inventory.txt").get(i).getQuantity());
	    		}
	    	}
	    }
	}
	
	/**
	 * sorts products in descending order by name
	 */
	public void descendingName() {
		ArrayList<String> s = new ArrayList<String>();
		//fills array with names of products
		for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
			s.add(readFromFile("inventory.txt").get(i).getName());
		}

		//uses collections to sort
	    Collections.sort(s, Collections.reverseOrder());
	    
	    System.out.println("Products in descending order by name:");
	    //for each loop to iterate
	    for (String str : s) {
		    // Print the sorted ArrayList
	    	for (int i = 0; i < readFromFile("inventory.txt").size(); ++i) {
	    		//if the name is equal to the name of the product, print out info for that product
	    		if (str.equals(readFromFile("inventory.txt").get(i).getName())) {
	    			System.out.println(str + ", " + 
	    				readFromFile("inventory.txt").get(i).getPrice() + ", " + 
	    				readFromFile("inventory.txt").get(i).getDescription() + ", " + 
	    				readFromFile("inventory.txt").get(i).getQuantity());
	    		}
	    	}
		}
	}
	
	/**
	 * creates file and writes the JSON of products to it
	 * @param filename The name of the file to be written to
	 * @param p The Product that is being written
	 * @param append Allows more text to be written
	 */
	public void saveToFile(String filename, Product p, boolean append) {
		PrintWriter pw;
		try {
			//create a file File to write
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			//write product as JSON
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
					Double.toString(p.getPrice()) + ",";
			System.out.println(text);
		}
	}
}