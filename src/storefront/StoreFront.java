package storefront;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreFront {
	
	/**
	 * Initializes store and sells 2 weapons, 2 pieces of armor, and a healing potion
	 * @param args Takes in any number of arguments
	 * @throws IOException Catches any input or output exceptions
	 */
	public static void main(String[] args) throws IOException{
		Scanner scnr = new Scanner(System.in);
		//initializes Inventory
		InventoryManager im = new InventoryManager();
		//Initializes Cart
		ShoppingCart sc = new ShoppingCart();
		
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("inventory.txt");
		Scanner s = new Scanner(file);
		
		//initializes inventory from JSON file
		//String json = s.nextLine();
		//Weapon sword = objectMapper.readValue(json, Weapon.class);
		//json = s.nextLine();
		//Weapon bow = objectMapper.readValue(json, Weapon.class);
		//json = s.nextLine();
		//Armor helmet = objectMapper.readValue(json, Armor.class);
		//json = s.nextLine();
		//Armor chestplate = objectMapper.readValue(json, Armor.class);
		//json = s.nextLine();
		//Health health = objectMapper.readValue(json, Health.class);
		//s.close();
		Weapon sword = new Weapon("Mighty Sword", "is the sharpest in the land", 50, 4);
		Weapon bow = new Weapon("Longbow", "This beginner's Elvin bow can shoot enemies from a distance", 120, 2);
		Armor helmet = new Armor("Basic Helmet", "prevents minor concussions", 60, 12);
		Armor chestplate = new Armor("Basic Chestplate", "prevents bruising", 80, 10);
		Health health = new Health("Healing Potion", "heals 75% of the player's health", 30.0, 120);
		
		im.saveToFile("inventory.txt", sword, true);
		im.saveToFile("inventory.txt", bow, true);
		im.saveToFile("inventory.txt", helmet, true);
		im.saveToFile("inventory.txt", chestplate, true);
		im.saveToFile("inventory.txt", health, true);
		
		
		im.readFromFile("inventory.txt").get(0).setQuantity(im.readFromFile("inventory.txt").get(0).getQuantity() - 2);
		System.out.println(im.readFromFile("inventory.txt").get(0).getQuantity());
		
		String json = s.nextLine();
		//Product product = objectMapper.readValue(json, Product.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(json);
		JsonNode statusNode = jsonNode.get("quantity");
		String statusValue = statusNode.textValue();
		System.out.println(statusValue);
		
		/*
		//initializes store and allows user to return back to the main menu
		System.out.println("Hello! Welcome to Fallen Kingdom Artefacts");
		
		while (true) {
			System.out.println("Anything interest you?");
			System.out.println("Press 1 for weapons");
			System.out.println("Press 2 for armor");
			System.out.println("Press 3 for health");
			System.out.println("Press 0 to leave");
			
			int choice = scnr.nextInt();

			//weapons
			if (choice == 1) {
				while (true) {
					System.out.println("Ah a weapon! Good choice. We have a " + im.readFromFile("inventory.txt").get(0).getName() + " and a " + im.readFromFile("inventory.txt").get(1).getName());
					System.out.println("If you'd like to learn more about the " + im.readFromFile("inventory.txt").get(0).getName() + " press 1");
					System.out.println("If you'd like to learn more about the " + im.readFromFile("inventory.txt").get(1).getName() + " press 2");
					System.out.println("To go back press 0");
					int weaponChoice = scnr.nextInt();
					//information about sword
					if (weaponChoice == 1) {
						System.out.println("This " + im.readFromFile("inventory.txt").get(0).getName() + " " + im.readFromFile("inventory.txt").get(0).getDescription());
						//System.out.println("Durability: " + im.readFromFile("inventory.txt").get(0).getDurability());
						System.out.println("Price: " + im.readFromFile("inventory.txt").get(0).getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						//offers chance to buy
						int purchaseChoice = scnr.nextInt();
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.readFromFile("inventory.txt").get(0).getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.readFromFile("inventory.txt").get(0).getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.readFromFile("inventory.txt").get(0), userQuantity);
								im.itemRemove(im.readFromFile("inventory.txt").get(0), userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping? Type 1 for yes or 2 for no");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart? Type 1 to buy all or type 2 to buy nothing");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										sc.cart.clear();
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
									}
									else {
										System.out.println("An error occurred");
									}
									break;
								}
								else {
									System.out.println("An error occurred");
								}
								break;
							}
							//prints error if user tries to buy more than is available
							else if (userQuantity > im.readFromFile("inventory.txt").get(0).getQuantity()) {
								System.out.println("Your requested quantity was too large");
							}
							else {
								System.out.println("An error occurred");
							}
						}
						//prints out if user doesn't want to buy this item
						else if (purchaseChoice == 2) {
							System.out.println("Okay, hopefully you find something else you like!");
						}
						else {
							System.out.println("An error occurred");
						}
					}
					//information about bow
					else if(weaponChoice == 2) {
						System.out.println("This " + im.readFromFile("inventory.txt").get(1).getName() + " " + im.readFromFile("inventory.txt").get(1).getDescription());
						//System.out.println("Durability: " + im.readFromFile("inventory.txt").get(1).getDurability());
						System.out.println("Price: " + im.readFromFile("inventory.txt").get(1).getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						//offers chance to buy
						int purchaseChoice = scnr.nextInt();
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.readFromFile("inventory.txt").get(1).getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.readFromFile("inventory.txt").get(1).getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.readFromFile("inventory.txt").get(1), userQuantity);
								im.itemRemove(im.readFromFile("inventory.txt").get(1), userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping? Type 1 for yes or 2 for no");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart? Type 1 to buy all or type 2 to buy nothing");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										sc.cart.clear();
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
									}
									else {
										System.out.println("An error occurred");
									}
									break;
								}
								else {
									System.out.println("An error occurred");
								}
								break;
							}
							//prints error if user tries to buy more than is available
							else if (userQuantity > im.readFromFile("inventory.txt").get(1).getQuantity()) {
								System.out.println("Your requested quantity was too large");
							}
							else {
								System.out.println("An error occurred");
							}
						}
						//prints out if user doesn't want to buy this item
						else if (purchaseChoice == 2) {
							System.out.println("Okay, hopefully you find something else you like!");
						}
						else {
							System.out.println("An error occurred");
						}
					}
					else if (weaponChoice == 0) {
						//go back a menu
						break;
					}
					else {
						System.out.println("An error occurred");
					}
				}
			}
			//armor
			if (choice == 2) {
				while (true) {
					System.out.println("Armor! Defense is always good. We have a " + im.readFromFile("inventory.txt").get(2).getName() + " and a " + im.readFromFile("inventory.txt").get(3).getName());
					System.out.println("If you'd like to learn more about the " + im.readFromFile("inventory.txt").get(2).getName() + " press 1");
					System.out.println("If you'd like to learn more about the " + im.readFromFile("inventory.txt").get(3).getName() + " press 2");
					System.out.println("To go back press 0");
					int armorChoice = scnr.nextInt();
					//information about helmet
					if (armorChoice == 1) {
						System.out.println("This " + im.readFromFile("inventory.txt").get(2).getName() + " " + im.readFromFile("inventory.txt").get(2).getDescription());
						//System.out.println("Durability: " + im.readFromFile("inventory.txt").get(2).getDurability());
						System.out.println("Price: " + im.readFromFile("inventory.txt").get(2).getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.readFromFile("inventory.txt").get(2).getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.readFromFile("inventory.txt").get(2).getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.readFromFile("inventory.txt").get(2), userQuantity);
								im.itemRemove(im.readFromFile("inventory.txt").get(2), userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping? Type 1 for yes or 2 for no");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart? Type 1 to buy all or type 2 to buy nothing");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										sc.cart.clear();
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
									}
									else {
										System.out.println("An error occurred");
									}
									break;
								}
								else {
									System.out.println("An error occurred");
								}
							}
							//prints error if user tries to buy more than is available
							else if (userQuantity > im.readFromFile("inventory.txt").get(2).getQuantity()) {
								System.out.println("Your requested quantity was too large");
							}
							else {
								System.out.println("An error occurred");
							}
						}
						//prints out if user doesn't want to buy this item
						else if (purchaseChoice == 2) {
							System.out.println("Okay, hopefully you find something else you like!");
						}
						else {
							System.out.println("An error occurred");
						}
					}
					//information about chestplate
					else if (armorChoice == 2) {
						System.out.println("This " + im.readFromFile("inventory.txt").get(3).getName() + " " + im.readFromFile("inventory.txt").get(3).getDescription());
						//System.out.println("Type: " + im.readFromFile("inventory.txt").get(3).getType());
						//System.out.println("Durability: " + im.readFromFile("inventory.txt").get(3).getDurability());
						System.out.println("Price: " + im.readFromFile("inventory.txt").get(3).getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.readFromFile("inventory.txt").get(3).getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.readFromFile("inventory.txt").get(3).getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.readFromFile("inventory.txt").get(3), userQuantity);
								im.itemRemove(im.readFromFile("inventory.txt").get(3), userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping? Type 1 for yes or 2 for no");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart? Type 1 to buy all or type 2 to buy nothing");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										sc.cart.clear();
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
									}
									else {
										System.out.println("An error occurred");
									}
									break;
								}
								else {
									System.out.println("An error occurred");
								}
							}
							//prints error if user tries to buy more than is available
							else if (userQuantity > im.readFromFile("inventory.txt").get(3).getQuantity()) {
								System.out.println("Your requested quantity was too large");
							}
							else {
								System.out.println("An error occurred");
							}
						}
						//prints out if user doesn't want to buy this item
						else if (purchaseChoice == 2) {
							System.out.println("Okay, hopefully you find something else you like!");
						}
						else {
							System.out.println("An error occurred");
						}
					}
					else if (armorChoice == 0) {
						//go back a menu
						break;
					}
					else {
						System.out.println("An error occurred");
					}
				}
			}
			//health
			if (choice == 3) {
				while (true) {
					System.out.println("You look rough. A health potion is a good idea. We have a " + im.readFromFile("inventory.txt").get(4).getName());
					System.out.println("If you'd like to learn more about the " + im.readFromFile("inventory.txt").get(4).getName() + " press 1");
					System.out.println("To go back press 0");
					int healthChoice = scnr.nextInt();
					//information about health
					if (healthChoice == 1) {
						System.out.println("This " + im.readFromFile("inventory.txt").get(4).getName() + " " + im.readFromFile("inventory.txt").get(4).getDescription());
						System.out.println("The " + im.readFromFile("inventory.txt").get(4).getName() + " costs " + im.readFromFile("inventory.txt").get(4).getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.readFromFile("inventory.txt").get(4).getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.readFromFile("inventory.txt").get(4).getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.readFromFile("inventory.txt").get(4), userQuantity);
								im.itemRemove(im.readFromFile("inventory.txt").get(4), userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping? Type 1 for yes or 2 for no");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart? Type 1 to buy all or type 2 to buy nothing");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										sc.cart.clear();
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
									}
									else {
										System.out.println("An error occurred");
									}
									break;
								}
								else {
									System.out.println("An error occurred");
								}
							}
							//prints error if user tries to buy more than is available
							else if (userQuantity > im.readFromFile("inventory.txt").get(4).getQuantity()) {
								System.out.println("Your requested quantity was too large");
							}
							else {
								System.out.println("An error occurred");
							}
						}
						//prints out if user doesn't want to buy this item
						else if (purchaseChoice == 2) {
							System.out.println("Okay, hopefully you find something else you like!");
						}
						else {
							System.out.println("An error occurred");
						}
					}
					else if (healthChoice == 0) {
						//go back a menu
						break;
					}
					else {
						System.out.println("An error occurred");
					}
				}
			}
			if (choice == 0) {
				System.out.println("Come again!");
				break;
			}
		}
		*/
	}
}