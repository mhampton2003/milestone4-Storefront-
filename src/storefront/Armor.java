package storefront;

public class Armor extends Product {
	
	/**
	 * Default armor constructor
	 */
	public Armor() {}
	
	/**
	 * Non-default Armor constructor. Creates armor object
	 * @param n name Creates the name
	 * @param d description Creates the description
	 * @param p price Creates the price
	 * @param q quantity Creates the quantity
	 */
	public Armor(String n, String d, double p, int q) {
		name = n;
		description = d;
		price = p;
		quantity = q;
	}
}