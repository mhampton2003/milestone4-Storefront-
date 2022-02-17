package storefront;
import java.util.Scanner;

public class StoreFront {
	
	/**
	 * Initializes store and sells 2 weapons, 2 pieces of armor, and a healing potion
	 * @param args Takes in any number of arguments
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		//initializes Inventory
		InventoryManager im = new InventoryManager();
		//Initializes Cart
		ShoppingCart sc = new ShoppingCart();

		
		/**
		 * initializes store and allows user to return back to the main menu
		 */
		
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
					System.out.println("Ah a weapon! Good choice. We have a " + im.sword.getName() + " and a " + im.bow.getName());
					System.out.println("If you'd like to learn more about the " + im.sword.getName() + " press 1");
					System.out.println("If you'd like to learn more about the " + im.bow.getName() + " press 2");
					System.out.println("To go back press 0");
					int weaponChoice = scnr.nextInt();
					//information about sword
					if (weaponChoice == 1) {
						System.out.println("This " + im.sword.getName() + " " + im.sword.getDescription());
						System.out.println("Durability: " + im.sword.getDurability());
						System.out.println("Price: " + im.sword.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						//offers chance to buy
						int purchaseChoice = scnr.nextInt();
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.sword.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.sword.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.sword, userQuantity);
								im.itemRemove(im.sword, userQuantity);
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
							else if (userQuantity > im.sword.getQuantity()) {
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
						System.out.println("This " + im.bow.getName() + " " + im.bow.getDescription());
						System.out.println("Durability: " + im.bow.getDurability());
						System.out.println("Price: " + im.bow.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						//offers chance to buy
						int purchaseChoice = scnr.nextInt();
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.bow.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.bow.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.bow, userQuantity);
								im.itemRemove(im.bow, userQuantity);
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
							else if (userQuantity > im.bow.getQuantity()) {
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
					System.out.println("Armor! Defense is always good. We have a " + im.helmet.getName() + " and a " + im.chestplate.getName());
					System.out.println("If you'd like to learn more about the " + im.helmet.getName() + " press 1");
					System.out.println("If you'd like to learn more about the " + im.chestplate.getName() + " press 2");
					System.out.println("To go back press 0");
					int armorChoice = scnr.nextInt();
					//information about helmet
					if (armorChoice == 1) {
						System.out.println("This " + im.helmet.getName() + " " + im.helmet.getDescription());
						System.out.println("Durability: " + im.helmet.getDurability());
						System.out.println("Price: " + im.helmet.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.helmet.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.helmet.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.helmet, userQuantity);
								im.itemRemove(im.helmet, userQuantity);
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
							else if (userQuantity > im.helmet.getQuantity()) {
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
						System.out.println("This " + im.chestplate.getName() + " " + im.chestplate.getDescription());
						System.out.println("Type: " + im.chestplate.getType());
						System.out.println("Durability: " + im.chestplate.getDurability());
						System.out.println("Price: " + im.chestplate.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.chestplate.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.chestplate.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.chestplate, userQuantity);
								im.itemRemove(im.chestplate, userQuantity);
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
							else if (userQuantity > im.chestplate.getQuantity()) {
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
					System.out.println("You look rough. A health potion is a good idea. We have a " + im.health.getName());
					System.out.println("If you'd like to learn more about the " + im.health.getName() + " press 1");
					System.out.println("To go back press 0");
					int healthChoice = scnr.nextInt();
					//information about health
					if (healthChoice == 1) {
						System.out.println("This " + im.health.getName() + " " + im.health.getDescription());
						System.out.println("The " + im.health.getName() + " costs " + im.health.getPrice() + " shards");
						System.out.println("Would you like to make a purchase? Type 1 for yes or 2 for no");
						int purchaseChoice = scnr.nextInt();
						//offers chance to buy
						if (purchaseChoice == 1) {
							System.out.println("How many would you like to buy? We have " + im.health.getQuantity() + " in stock");
							int userQuantity = scnr.nextInt();
							//if the desired amount is less than stock add to cart and remove from inventory
							if ((userQuantity <= im.health.getQuantity()) && (userQuantity > 0)) {
								sc.cartAdd(im.health, userQuantity);
								im.itemRemove(im.health, userQuantity);
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
							else if (userQuantity > im.health.getQuantity()) {
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