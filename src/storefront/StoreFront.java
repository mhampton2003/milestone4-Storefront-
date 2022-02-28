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
		//initializes Inventory
		InventoryManager im = new InventoryManager();
		//Initializes Cart
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
					System.out.println("Ah a weapon! Good choice. We have a " + sword.getName() + " and a " + bow.getName());
					System.out.println("If you'd like to learn more about the " + sword.getName() + " press 1");
					System.out.println("If you'd like to learn more about the " + bow.getName() + " press 2");
					System.out.println("To go back press 0");
					int weaponChoice = scnr.nextInt();
					//information about sword
					if (weaponChoice == 1) {
						System.out.println("This " + sword.getName() + " " + sword.getDescription());
						System.out.println("Durability: " + sword.getDurability());
						System.out.println("Price: " + sword.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
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
							else if (userQuantity > sword.getQuantity()) {
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
						System.out.println("This " + bow.getName() + " " + bow.getDescription());
						System.out.println("Durability: " + bow.getDurability());
						System.out.println("Price: " + bow.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
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
							else if (userQuantity > bow.getQuantity()) {
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
					System.out.println("Armor! Defense is always good. We have a " + helmet.getName() + " and a " + chestplate.getName());
					System.out.println("If you'd like to learn more about the " + helmet.getName() + " press 1");
					System.out.println("If you'd like to learn more about the " + chestplate.getName() + " press 2");
					System.out.println("To go back press 0");
					int armorChoice = scnr.nextInt();
					//information about helmet
					if (armorChoice == 1) {
						System.out.println("This " + helmet.getName() + " " + helmet.getDescription());
						System.out.println("Durability: " + helmet.getDurability());
						System.out.println("Price: " + helmet.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
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
							else if (userQuantity > helmet.getQuantity()) {
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
						System.out.println("This " + chestplate.getName() + " " + chestplate.getDescription());
						System.out.println("Type: " + chestplate.getType());
						System.out.println("Durability: " + chestplate.getDurability());
						System.out.println("Price: " + chestplate.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
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
							else if (userQuantity > chestplate.getQuantity()) {
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
					System.out.println("You look rough. A health potion is a good idea. We have a " + health.getName());
					System.out.println("If you'd like to learn more about the " + health.getName() + " press 1");
					System.out.println("To go back press 0");
					int healthChoice = scnr.nextInt();
					//information about health
					if (healthChoice == 1) {
						System.out.println("This " + health.getName() + " " + health.getDescription());
						System.out.println("The " + health.getName() + " costs " + health.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
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
							else if (userQuantity > health.getQuantity()) {
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
		
	}
}