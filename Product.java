import java.io.Serializable;

public class Product implements Serializable {

	String productId;
	String name;
	String description;
	int quantityInHand;
	int unitPrice;

	/*
	 * public Product() { super(); this.productId = "50IM"; this.name = "Imran";
	 * this.description = "Hey it Imran Khan"; this.quantityInHand = 5;
	 * this.unitPrice = 50; }
	 */

	public Product(String productId, String name, String description, int quantityInHand, int unitPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantityInHand = quantityInHand;
		this.unitPrice = unitPrice;
	}



	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantityInHand() {
		return quantityInHand;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

}
