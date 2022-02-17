package storefront;

public class Armor extends Product {
	
	/**
	 * Default armor constructor
	 */
	private Armor() {}
	
	/**
	 * Non-default Armor constructor. Creates armor object
	 * @param n name Creates the name
	 * @param t type Creates the type
	 * @param h durability Creates the durability
	 * @param d description Creates the description
	 * @param p price Creates the price
	 * @param q quantity Creates the quantity
	 */
	protected Armor(String n, String t, double h, String d, double p, int q) {
		name = n;
		type = t;
		durability = h;
		description = d;
		price = p;
		quantity = q;
	}
}