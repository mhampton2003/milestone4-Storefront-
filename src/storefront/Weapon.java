package storefront;

public class Weapon extends Product {
	
	/**
	 * default weapon constructor
	 */
	public Weapon() {}
	
	/**
	 * non-default weapon constructor. creates weapon object
	 * @param n name Creates the name
	 * @param h durability Creates the durability
	 * @param d description Creates the durability
	 * @param p price Creates the price
	 * @param q quantity Creates the quantity
	 */
	public Weapon(String n, String d, double p, int q) {
		name = n;
		description = d;
		price = p;
		quantity = q;
	}
}