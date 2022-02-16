import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 3653536610486882596L;
	String productId;
	String name;
	String description;
	int quantityInHand;
	int unitPrice;

	public Product(String productId, String name, String description, int quantityInHand, int unitPrice) {		//Contructors
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantityInHand = quantityInHand;
		this.unitPrice = unitPrice;
	}


																					//Getter Setter for Product 
	public void setProductId(String productId) {
		this.productId = productId;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setQuantityInHand(int quantityInHand) {
		this.quantityInHand = quantityInHand;
	}



	public void setUnitPrice(int unitPrice) {
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

	@Override
	public String toString() {
		return "productId=" + productId + ", name=" + name + ", description=" + description
				+ ", quantityInHand=" + quantityInHand + ", unitPrice=" + unitPrice;
	}

}
