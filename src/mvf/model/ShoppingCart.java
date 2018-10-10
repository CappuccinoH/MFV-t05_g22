package mvf.model;

import java.util.ArrayList;

public class ShoppingCart {
	private int cartId;
	private ArrayList<ProductRepository> prodRepositroy;
	private double price;

	public ShoppingCart() {
		super();
		prodRepositroy = new ArrayList<ProductRepository>();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCart(int cartId, ArrayList<ProductRepository> prodRepositroy, double price) {
		super();
		this.cartId = cartId;
		this.prodRepositroy = prodRepositroy;
		this.price = price;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public ArrayList<ProductRepository> getProdRepositroy() {
		return prodRepositroy;
	}

	public void setProdRepositroy(ArrayList<ProductRepository> prodRepositroy) {
		this.prodRepositroy = prodRepositroy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", prodRepositroy=" + prodRepositroy + ", price=" + price + "]";
	}

	public void addToCart(Product product) {

	}
}
