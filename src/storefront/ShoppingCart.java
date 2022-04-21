package storefront;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	protected double totalCost;
	protected int count = 1;
	
	//tracks items added to the cart
	Map<Integer, Product> cart = new HashMap<Integer, Product>();
	//tracks quantity of items added to the cart
	Map<Integer, Integer> amount = new HashMap<Integer, Integer>();
	
	/**
	 * Adds item to cart array of Products
	 * @param p product that is being added to cart of type product
	 * @param quantity amount of the product that is being added
	 */
	public void cartAdd(Product p, int quantity) {
		cart.put(count, p); // adds product to cart
		amount.put(count, quantity); // adds amount that is being purchased to amount array
		//totalItems += quantity; - to be used later?
		//totalCost += p.price * quantity; - to be used later?
		System.out.println(quantity + " " + p.getName() + "s were added to the cart");
		
		totalCost = totalCost + cart.get(count).getPrice() * quantity;
		
		count++;

		System.out.println("");
	}
	
	/**
	 * removes item from cart map of Products
	 * @param p product that is being removed from cart of type product
	 * @param quantity amount of the product that is being removed
	 */
	public void cartRemove(Product p, int quantity) {
		//for the size of the cart map:
		for (int i = 0; i < cart.size(); ++i) {
			//if the index is equal to the product being removed
			//remove the product from the cart and remove the amount associated with it
			if (cart.get(i) == p) {
				cart.remove(i);
				amount.remove(i);
				totalCost = totalCost - (cart.get(i).getPrice() * amount.get(i));
			}
		}
		//totalItems -= quantity; - to be used later?
		//totalCost -= p.price * quantity; - to be used later?
		System.out.println(quantity + " " + p.getName() + "s were removed from the cart");
		count--;
	}
	
	/**
	 * returns the contents of the cart to the console
	 */
	public void returnCart() {
		//for the size of the cart
		//print out name of product and amount of it
		for (int i = 1; i <= cart.size(); ++i) {
			System.out.println(cart.get(i).getName() + " - " + amount.get(i));
		}
		
		System.out.println("Total Cost: " + totalCost);
	}
	
	/**
	 * returns the cart's contents to the inventory
	 * empties the contents of the cart
	 */
	public void emptyCart() {
		//for the size of the cart
		//the item's stock is set to the quantity plus what is already in the cart (amount map)
		for (int i = 1; i <= cart.size(); ++i) {
			cart.get(i).setQuantity(cart.get(i).getQuantity() + amount.get(i));
		}
		//empties cart and amount maps of all contents. resets key count
		cart.clear();
		amount.clear();
		totalCost = 0;
		count = 1;
		System.out.println("Your cart was emptied");
	}
}
