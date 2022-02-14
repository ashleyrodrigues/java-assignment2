import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 5694297608962944593L;

	String productId;
	String name;
	String description;
	int quantityInHand;
	int unitPrice;

	public Product(String productId, String name, String description, int quantityInHand, int unitPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantityInHand = quantityInHand;
		this.unitPrice = unitPrice;
	}



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
