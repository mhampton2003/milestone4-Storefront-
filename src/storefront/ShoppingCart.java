package storefront;

import java.util.ArrayList;

public class ShoppingCart {
	//protected int totalItems; - to be used later?
	//protected int totalCost; - to be used later?
	
	//tracks items added to the cart
	ArrayList<Product> cart = new ArrayList<Product>();
	//tracks quantity of items added to the cart
	ArrayList<Integer> amount = new ArrayList<Integer>();
	
	/**
	 * Adds item to cart array of Products
	 * @param p product that is being added to cart of type product
	 * @param quantity amount of the product that is being added
	 */
	public void cartAdd(Product p, int quantity) {
		cart.add(p); // adds product to cart
		amount.add(quantity); // adds amount that is being purchased to amount array
		//totalItems += quantity; - to be used later?
		//totalCost += p.price * quantity; - to be used later?
		System.out.println(quantity + " " + p.getName() + "s were added to the cart");
	}
	
	/**
	 * removes item from cart array of Products
	 * @param p product that is being removed from cart of type product
	 * @param quantity amount of the product that is being removed
	 */
	public void remove(Product p, int quantity) {
		//for the size of the cart array:
		for (int i = 0; i < cart.size(); ++i) {
			//if the index is equal to the product being removed
			//remove the product from the cart and remove the amount associated with it
			if (cart.get(i) == p) {
				cart.remove(i);
				amount.remove(i);
			}
		}
		//totalItems -= quantity; - to be used later?
		//totalCost -= p.price * quantity; - to be used later?
		System.out.println(quantity + " " + p.getName() + "s were removed from the cart");
	}
	
	/**
	 * returns the contents of the cart to the screen
	 */
	public void returnCart() {
		//for the size of the cart
		//print out name of product and amount of it
		for (int i = 0; i < cart.size(); ++i) {
			System.out.println(cart.get(i).getName() + " - " + amount.get(i));
		}
	}
	
	/**
	 * returns the cart's contents to the inventory
	 * empties the contents of the cart
	 */
	public void emptyCart() {
		//for the size of the cart
		//the item's stock is set to the quantity plus what is already in the cart (amount array)
		for (int i = 0; i < cart.size(); ++i) {
			cart.get(i).setQuantity(cart.get(i).getQuantity() + amount.get(i));
		}
		//empties cart and amount arrays of all contents
		cart.clear();
		amount.clear();
		System.out.println("Your cart was emptied");
	}
}
