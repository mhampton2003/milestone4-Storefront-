package storefront;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class InventoryManager {
	public Socket clientSocket;
	public PrintWriter out;
	public BufferedReader in;
	
	/**
	 * Connect to the remote Server on the specified IP address and Port
	 * 
	 * @param ip Remote IP Address to connect to
	 * @param port Remote Port to connect to
	 * @throws UnknownHostException Thrown if network resolution exception
	 * @throws IOException Thrown if anything bad happens from any of the networking classes
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException {
		//connect to the Remote Server on the specified IP Address and Port
		clientSocket = new Socket(ip, port);
		
		//create some input and output network buffers to communicate back and forth with the Server
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	/**
	 * Send a message to the Server
	 * 
	 * @param msg Message to send
	 * @return Response back from the Server 
	 * @throws IOException Thrown if anything bad happens from any of the networking classes
	 */
	public String sendMessage(String msg) throws IOException {
		//send/print a message to the Server with a terminating line feed
		out.println(msg);
		
		//return the response from the Server
		//System.out.println(in.readLine());
		return in.readLine();
	}
	
	/**
	 * cleanup logic to close all the network connections
	 * 
	 * @throws IOException Thrown if anything bad happens from the networking classes
	 */
	public void cleanup() throws IOException {
		//close all input and output network buffers and sockets
		in.close();
		out.close();
		clientSocket.close();
	}
	
	/**
	 * entry method for the Server application
	 * 
	 * @param args Takes in any number of values
	 * @throws IOException Thrown if anything bad happens from any of the networking classes
	 * @throws InterruptedException Thrown if anything bad happens while the thread is running
	 */
	public static void main(String args[]) throws IOException, InterruptedException {
		//create a Client and connect to the Remote Server on the specified IP Address and Port
		InventoryManager client = new InventoryManager();
		FileService fs = new FileService();
		Scanner scnr = new Scanner(System.in);
		client.start("127.0.0.1", 6666);
		
		Boolean cont = true;
		//while the user still wants to access the inventory:
		while (cont) {
			System.out.println("[R] Return inventory\n" + "[U] Update products");
			String input = scnr.next();
			
			//return inventory
			if (input.equals("R")) {
				client.sendMessage(client.returnInventory());
			}
			//add a product to the inventory
			else if (input.equals("U")) {
				System.out.println("[1] Add product");
				int prodChoice = scnr.nextInt();
				if (prodChoice == 1) {
					Product p = new Product();
					System.out.println("Type in the attributes of the product you want to add");
					System.out.print("Enter name of product: ");
					String name = scnr.next();
					p.setName(name);
					System.out.print("Enter description of product: ");
					String descript = scnr.next();
					p.setDescription(descript);
					System.out.print("Enter price of product: ");
					int price = scnr.nextInt();
					p.setPrice(price);
					System.out.print("Enter quantity of product: ");
					int quantity = scnr.nextInt();
					p.setQuantity(quantity);
					System.out.print("Enter the type of product: ");
					String type = scnr.next();
					p.setType(type);
					fs.saveToFile("inventory.txt", p, true);
				}
			}
			else {
				System.out.println("An error occured");
			}
			//if the user wants to do something else: repeats
			System.out.println("Would you like to do anything else?\n"
					+ "[1] Yes "
					+ "[2] No");
			int contChoice = scnr.nextInt();
			if (contChoice == 1) {
				continue;
			}
			else {
				cont = false;
				break;
			}
			
		}
		
		client.cleanup();
		scnr.close();
	}
	
	
	
	/**
	 * Sorts the products in ascending order by price
	 */
	public void ascendingPrice() {
		FileService fs = new FileService();
		ArrayList<Double> p = new ArrayList<Double>();
		//fills array with prices of products
		for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
			p.add(fs.readFromFile("inventory.txt").get(i).getPrice());
		}
		
		//uses collections to sort prices
		Collections.sort(p);
	    
		System.out.println("Products in ascending order by price:");
		// For each loop to iterate
	    for (Double d : p) {
		    // Print the sorted ArrayList
	    	for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
	    		//if the price is equal to the price of the product, print out info for that product
		    	if (d == fs.readFromFile("inventory.txt").get(i).getPrice()) {
		    		System.out.println(d + ", " + fs.readFromFile("inventory.txt").get(i).getName() + ", " + 
		    				fs.readFromFile("inventory.txt").get(i).getDescription() + ", " + 
		    				fs.readFromFile("inventory.txt").get(i).getQuantity());
		    	}
	    	}
	    }
	}
	
	/**
	 * sorts products in descending order by price
	 */
	public void descendingPrice() {
		FileService fs = new FileService();
		ArrayList<Double> p = new ArrayList<Double>();
		//fills array with prices of products
		for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
			p.add(fs.readFromFile("inventory.txt").get(i).getPrice());
		}
		
		//uses collections to sort
	    Collections.sort(p, Collections.reverseOrder());
	    
	    System.out.println("Products in descending order by price:");
	    //for each loop to iterate
	    for (Double d : p) {
		    // Print the sorted ArrayList
	    	for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
	    		//if the price is equal to the price of the product, print out info for that product
		    	if (d == fs.readFromFile("inventory.txt").get(i).getPrice()) {
		    		System.out.println(d + ", " + fs.readFromFile("inventory.txt").get(i).getName() + ", " + 
		    				fs.readFromFile("inventory.txt").get(i).getDescription() + ", " + 
		    				fs.readFromFile("inventory.txt").get(i).getQuantity());
		    	}
	    	}
		}
	}
	
	/**
	 * sorts products in ascending order by name
	 */
	public void ascendingName() {
		FileService fs = new FileService();
		ArrayList<String> s = new ArrayList<String>();
		//fills array with names of products
		for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
			s.add(fs.readFromFile("inventory.txt").get(i).getName());
		}
		
		//uses collections to sort
		Collections.sort(s);
	    
		System.out.println("Products in ascending order by name:");
		// For each loop to iterate
	    for (String str : s) {
	      // Print the sorted ArrayList
	    	for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
	    		//if the name is equal to the name of the product, print out info for that product
	    		if (str.equals(fs.readFromFile("inventory.txt").get(i).getName())) {
	    			System.out.println(str + ", " + 
	    				fs.readFromFile("inventory.txt").get(i).getPrice() + ", " + 
	    				fs.readFromFile("inventory.txt").get(i).getDescription() + ", " + 
	    				fs.readFromFile("inventory.txt").get(i).getQuantity());
	    		}
	    	}
	    }
	}
	
	/**
	 * sorts products in descending order by name
	 */
	public void descendingName() {
		FileService fs = new FileService();
		ArrayList<String> s = new ArrayList<String>();
		//fills array with names of products
		for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
			s.add(fs.readFromFile("inventory.txt").get(i).getName());
		}

		//uses collections to sort
	    Collections.sort(s, Collections.reverseOrder());
	    
	    System.out.println("Products in descending order by name:");
	    //for each loop to iterate
	    for (String str : s) {
		    // Print the sorted ArrayList
	    	for (int i = 0; i < fs.readFromFile("inventory.txt").size(); ++i) {
	    		//if the name is equal to the name of the product, print out info for that product
	    		if (str.equals(fs.readFromFile("inventory.txt").get(i).getName())) {
	    			System.out.println(str + ", " + 
	    				fs.readFromFile("inventory.txt").get(i).getPrice() + ", " + 
	    				fs.readFromFile("inventory.txt").get(i).getDescription() + ", " + 
	    				fs.readFromFile("inventory.txt").get(i).getQuantity());
	    		}
	    	}
		}
	}
	
	/**
	 * removes an item from the inventory's stock
	 * @param p product that is being removed from the inventory
	 * @param userQuantity quantity of the product that is being removed
	 */
	public void itemRemove(Product p, int userQuantity) {
		//removes desired quantity from the product's stock
		p.setQuantity(p.getQuantity() - userQuantity);
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
	public String returnInventory() {
		FileService fs = new FileService();
		//creates arrayList of items from JSON
		ArrayList<Product> itemsList = fs.readFromFile("inventory.txt");
		String text = "";
		for (Product p : itemsList) {
			//prints each product with commas between each attribute
			text = text + p.getName() + "," + p.getDescription() + "," +
					Integer.toString(p.getQuantity()) + "," +
					Double.toString(p.getPrice()) + "\n";
		}
		return text;
	}
}