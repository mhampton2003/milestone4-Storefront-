package storefront;

public class Health extends Product{
	
	/**
	 * Default Health constructor
	 */
	private Health() {}
	
	/**
	 * Non-default health constructor. Creates health object
	 * @param n name Creates the name
	 * @param d description Creates the description
	 * @param p price Creates the price
	 * @param q quantity Creates the quantity
	 */
	public Health(String n, String d, double p, int q) {
		name = n;
		description = d;
		price = p;
		quantity = q;
	}
}