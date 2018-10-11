package mvf.model;

public class ProductRepository {
	private Product product;
	private double amount;

	public ProductRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductRepository(Product product, double amount) {
		super();
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductRepository [product=" + product + ", amount=" + amount + "]";
	}

}
