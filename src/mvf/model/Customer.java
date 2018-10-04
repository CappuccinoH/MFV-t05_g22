package mvf.model;

import java.util.ArrayList;

public class Customer extends User {

	private ShoppingCart shoppingCart;
	private ArrayList<Order> orderList;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String account, String password, String userStatus) {
		super(account, password, userStatus);
		// TODO Auto-generated constructor stub
	}

	public Customer(ShoppingCart shoppingCart, ArrayList<Order> orderList) {
		super();
		this.shoppingCart = shoppingCart;
		this.orderList = orderList;
	}

	public void unregister() {

	}

	public void addToCart() {

	}

	public void removeFromCart() {

	}

	public void viewProdList() {

	}

	public void generateOrder() {

	}

	public void pay() {

	}
}
