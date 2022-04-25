package storefront;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreFront {
	
	/**
	 * Initializes store and sells 2 weapons, 2 pieces of armor, and a healing potion
	 * @param args Takes in any number of arguments
	 * @throws IOException Catches any input or output exceptions
	 */
	public static void main(String[] args) throws IOException{
		Scanner scnr = new Scanner(System.in);
		InventoryManager im = new InventoryManager();
		ShoppingCart sc = new ShoppingCart();
		
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("inventory.txt");
		Scanner s = new Scanner(file);
		
		//initializes inventory from JSON file
		String json = s.nextLine();
		Weapon sword = objectMapper.readValue(json, Weapon.class);
		json = s.nextLine();
		Weapon bow = objectMapper.readValue(json, Weapon.class);
		json = s.nextLine();
		Armor helmet = objectMapper.readValue(json, Armor.class);
		json = s.nextLine();
		Armor chestplate = objectMapper.readValue(json, Armor.class);
		json = s.nextLine();
		Health health = objectMapper.readValue(json, Health.class);
		s.close();
		
		/*
		Weapon sword1 = new Weapon("Mighty Sword", "is the sharpest in the land", 50, 4);
		Weapon bow1 = new Weapon("Longbow", "This beginner's Elvin bow can shoot enemies from a distance", 120, 2);
		Armor helmet1 = new Armor("Basic Helmet", "prevents minor concussions", 60, 12);
		Armor chestplate1 = new Armor("Basic Chestplate", "prevents bruising", 80, 10);
		Health health1 = new Health("Healing Potion", "heals 75% of the player's health", 30.0, 120);
		
		fs.saveToFile("inventory.txt", sword, true);
		fs.saveToFile("inventory.txt", bow, true);
		fs.saveToFile("inventory.txt", helmet, true);
		fs.saveToFile("inventory.txt", chestplate, true);
		fs.saveToFile("inventory.txt", health, true);
		*/
		
		//initializes store and allows user to return back to the main menu
		System.out.println("Hello! Welcome to Fallen Kingdom Artifacts");
		
		while (true) {
			System.out.println("Anything interest you?");
			System.out.println("------------------------------");
			System.out.println("[1] Weapons");
			System.out.println("[2] Armor");
			System.out.println("[3] Health");
			System.out.println("[0] Exit");
			System.out.println("------------------------------");
			
			int choice = scnr.nextInt();
			
			//weapons
			if (choice == 1) {
				while (true) {
					System.out.println("A weapon! Good choice. We have a " + sword.getName() + " and a " + bow.getName());
					System.out.println("------------------------------");
					System.out.println("[1] To learn more about the " + sword.getName());
					System.out.println("[2] To learn more about the " + bow.getName());
					System.out.println("[0] To go back");
					System.out.println("------------------------------");
					int weaponChoice = scnr.nextInt();
					//information about sword
					if (weaponChoice == 1) {
						System.out.println("This " + sword.getName() + " " + sword.getDescription());
						//System.out.println("Durability: " + sword.getDurability());
						System.out.println("Price: " + sword.getPrice() + " shards");
						System.out.println("Would you like to make a purchase?");
						System.out.println("------------------------------");
						System.out.println("[1] Yes\n[2] No");
						System.out.println("------------------------------");
						//offers chance to buy
						int purchaseChoice = scnr.nextInt();
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + sword.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= sword.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(sword, userQuantity);
								im.itemRemove(sword, userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping?");
								System.out.println("------------------------------");
								System.out.println("[1] Yes\n[2] No");
								System.out.println("------------------------------");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart?");
									System.out.println("------------------------------");
									System.out.println("[1] Buy all\n[2] Buy nothing");
									System.out.println("------------------------------");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										System.out.println("==============================\n");
										sc.cart.clear();
										sc.amount.clear();
										sc.totalCost = 0;
										sc.count = 1;
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
										sc.amount.clear();
										System.out.println("==============================\n");
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
							else if (userQuantity > sword.getQuantity()) {
								if (sword.getQuantity() == 0) {
									System.out.println("Unfortunately we have no more " + sword.getName() + "s in stock");
								}
								else {
									System.out.println("Your requested quantity was too large");
								}
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
					else if (weaponChoice == 2) {
						System.out.println("This " + bow.getName() + " " + bow.getDescription());
						//System.out.println("Durability: " + bow.getDurability());
						System.out.println("Price: " + bow.getPrice() + " shards");
						System.out.println("Would you like to make a purchase?");
						System.out.println("------------------------------");
						System.out.println("[1] Yes\n[2] No");
						System.out.println("------------------------------");
						//offers chance to buy
						int purchaseChoice = scnr.nextInt();
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + bow.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= bow.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(bow, userQuantity);
								im.itemRemove(bow, userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping?");
								System.out.println("------------------------------");
								System.out.println("[1] Yes\n[2] No");
								System.out.println("------------------------------");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart?");
									System.out.println("------------------------------");
									System.out.println("[1] Buy all\n[2] Buy nothing");
									System.out.println("------------------------------");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										System.out.println("==============================\n");
										sc.cart.clear();
										sc.amount.clear();
										sc.totalCost = 0;
										sc.count = 1;
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
										sc.amount.clear();
										System.out.println("==============================\n");
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
							else if (userQuantity > bow.getQuantity()) {
								if (sword.getQuantity() == 0) {
									System.out.println("Unfortunately we have no more " + bow.getName() + "s in stock");
								}
								else {
									System.out.println("Your requested quantity was too large");
								}
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
					System.out.println("Armor! Defense is always good. We have a " + helmet.getName() + " and a " + chestplate.getName());
					System.out.println("------------------------------");
					System.out.println("[1] To learn more about the " + helmet.getName());
					System.out.println("[2] To learn more about the " + chestplate.getName());
					System.out.println("[0] To go back");
					System.out.println("------------------------------");
					int armorChoice = scnr.nextInt();
					//information about helmet
					if (armorChoice == 1) {
						System.out.println("This " + helmet.getName() + " " + helmet.getDescription());
						//System.out.println("Durability: " + helmet.getDurability());
						System.out.println("Price: " + helmet.getPrice() + " shards");
						System.out.println("Would you like to make a purchase?");
						System.out.println("------------------------------");
						System.out.println("[1] Yes\n[2] No");
						System.out.println("------------------------------");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + helmet.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= helmet.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(helmet, userQuantity);
								im.itemRemove(helmet, userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping?");
								System.out.println("------------------------------");
								System.out.println("[1] Yes\n[2] No");
								System.out.println("------------------------------");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart?");
									System.out.println("------------------------------");
									System.out.println("[1] Buy all\n[2] Buy nothing");
									System.out.println("------------------------------");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										System.out.println("==============================\n");
										sc.cart.clear();
										sc.amount.clear();
										sc.totalCost = 0;
										sc.count = 1;
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
										sc.amount.clear();
										System.out.println("==============================\n");
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
							else if (userQuantity > helmet.getQuantity()) {
								if (sword.getQuantity() == 0) {
									System.out.println("Unfortunately we have no more " + helmet.getName() + "s in stock");
								}
								else {
									System.out.println("Your requested quantity was too large");
								}
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
						System.out.println("This " + chestplate.getName() + " " + chestplate.getDescription());
						//System.out.println("Type: " + chestplate.getType());
						//System.out.println("Durability: " + chestplate.getDurability());
						System.out.println("Price: " + chestplate.getPrice() + " shards");
						System.out.println("Would you like to make a purchase?");
						System.out.println("------------------------------");
						System.out.println("[1] Yes\n[2] No");
						System.out.println("------------------------------");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + chestplate.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= chestplate.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(chestplate, userQuantity);
								im.itemRemove(chestplate, userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping?");
								System.out.println("------------------------------");
								System.out.println("[1] Yes\n[2] No");
								System.out.println("------------------------------");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart?");
									System.out.println("------------------------------");
									System.out.println("[1] Buy all\n[2] Buy nothing");
									System.out.println("------------------------------");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										System.out.println("==============================\n");
										sc.cart.clear();
										sc.amount.clear();
										sc.totalCost = 0;
										sc.count = 1;
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
										sc.amount.clear();
										System.out.println("==============================\n");
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
							else if (userQuantity > chestplate.getQuantity()) {
								if (sword.getQuantity() == 0) {
									System.out.println("Unfortunately we have no more " + chestplate.getName() + "s in stock");
								}
								else {
									System.out.println("Your requested quantity was too large");
								}
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
					System.out.println("You look rough. A health potion is a good idea. We have a " + health.getName());
					System.out.println("------------------------------");
					System.out.println("[1] To learn more about the " + health.getName());
					System.out.println("[0] To go back");
					System.out.println("------------------------------");
					int healthChoice = scnr.nextInt();
					//information about health
					if (healthChoice == 1) {
						System.out.println("This " + health.getName() + " " + health.getDescription());
						System.out.println("The " + health.getName() + " costs " + health.getPrice() + " shards");
						System.out.println("Would you like to make a purchase?");
						System.out.println("------------------------------");
						System.out.println("[1] Yes\n[2] No");
						System.out.println("------------------------------");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + health.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= health.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(health, userQuantity);
								im.itemRemove(health, userQuantity);
								//user can continue shopping
								System.out.println("Would you like to continue shopping?");
								System.out.println("------------------------------");
								System.out.println("[1] Yes\n[2] No");
								System.out.println("------------------------------");
								int continueChoice = scnr.nextInt();
								if (continueChoice == 1) {
									//continue shopping - goes back a menu
								}
								//if user wants to purchase items the cart is emptied
								else if (continueChoice == 2) {
									System.out.println("Would you like to purchase the items in your cart?");
									System.out.println("------------------------------");
									System.out.println("[1] Buy all\n[2] Buy nothing");
									System.out.println("------------------------------");
									sc.returnCart();
									int cartChoice = scnr.nextInt();
									if (cartChoice == 1) {
										System.out.println("Your purchase was completed successfully");
										System.out.println("==============================\n");
										sc.cart.clear();
										sc.amount.clear();
										sc.totalCost = 0;
										sc.count = 1;
									}
									//if user doesn't want to purchase items the cart is emptied and stock is returned to inventory
									else if (cartChoice == 2) {
										sc.emptyCart();
										sc.amount.clear();
										System.out.println("==============================\n");
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
							else if (userQuantity > health.getQuantity()) {
								if (sword.getQuantity() == 0) {
									System.out.println("Unfortunately we have no more " + health.getName() + "s in stock");
								}
								else {
									System.out.println("Your requested quantity was too large");
								}
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
		scnr.close();
	}
}