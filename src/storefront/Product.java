package storefront;

public class Product implements Comparable<Product>{
	protected String name;
	protected String type;
	protected String description;
	protected double price;
	protected int quantity;
	protected double durability;
	
	/**
	 * Product default constructor
	 */
	protected Product() {}
	
	/**
	 * non-default constructor. Creates a product
	 * @param n name Creates the name
	 * @param d description Creates the description
	 * @param p price Creates the price
	 * @param q quantity Creates the quantity
	 */
	public Product(String n, String d, double p, int q) {
		name = n;
		description = d;
		price = p;
		quantity = q;
	}
	
	/**
	 * Overridden function
	 * Compares products and sorts by first name
	 */
	@Override
	public int compareTo(Product p) {
		int value = this.name.toLowerCase().compareTo(p.name.toLowerCase());
		if (value == 0) {
			return this.description.compareTo(p.description);
		}
		else {
			return value;
		}
	}
	
	/**
	 * Overridden function
	 * returns name as a string
	 */
	@Override
	public String toString() {
		return this.getName();
	}
	/*
	/**
	 * gets type of product
	 * @return type an int representing the type
	 
	public String getType() {
		return type;
	}

	/**
	 * sets the type of product
	 * @param type an int containing the product's type
	 
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * gets the durability of the product
	 * @return durability a double representing the durability
	 *
	public double getDurability() {
		return durability;
	}

	/**
	 * sets the product's durability
	 * @param durability a double containing the product's durability
	 *
	public void setDurability(double durability) {
		this.durability = durability;
	}
*/
	/**
	 * gets the product's name
	 * @return name A string representing the product's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the product's name
	 * @param name A string containing the product's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the product's description
	 * @return description A string representing the product's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the product's description
	 * @param description A string containing the product's description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * gets the product's price
	 * @return price A double representing the product's price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets the product's price
	 * @param price A double containing the product's price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * gets the quantity of the product
	 * @return quantity An integer that represents how many of 1 product is being sold
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * sets the quantity of the product
	 * @param quantity An integer that contains how many of 1 product is being sold
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}