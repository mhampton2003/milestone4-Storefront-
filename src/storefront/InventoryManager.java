package storefront;

import java.util.ArrayList;

public class InventoryManager {
	//tracks products in the inventory
	ArrayList<Product> inventory = new ArrayList<Product>();
	//initializes inventory
	Weapon sword = new Weapon("Mighty Sword", 100.0, "is the sharpest in the land", 50, 4);
	Weapon bow = new Weapon("Longbow", 100.0, "is a beginner's Elvin bow that can shoot enemies from a distance", 120, 2);
	Armor helmet = new Armor("Basic Helmet", "Basic", 30.0, "prevents minor concussions", 60, 12);
	Armor chestplate = new Armor("Basic Chestplate", "Basic", 75.0, "prevents bruising", 80, 10);
	Health health = new Health("Healing Potion", "heals 75% of the player's health", 30.0, 120);
	
	/**
	 * removes an item from the inventory's stock
	 * @param p product that is being removed from the inventory
	 * @param userQuantity quantity of the product that is being removed
	 */
	public void itemRemove(Product p, int userQuantity) {
		//removes desired quantity from the product's stock
		p.quantity = p.quantity - userQuantity;
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
	 * initializes and returns the inventory
	 */
	public void returnInventory() {
		//initializes inventory
		inventory.add(sword);
		inventory.add(bow);
		inventory.add(helmet);
		inventory.add(chestplate);
		inventory.add(health);
		//prints out each item on a new line
		for (int i = 0; i < inventory.size(); ++i) {
			System.out.println(inventory.get(i) + " - " + inventory.get(i).getQuantity());
		}
	}
}