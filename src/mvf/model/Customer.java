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

	public Customer(String account, String password, String userStatus, ShoppingCart shoppingCart,
			ArrayList<Order> orderList) {
		super();
		this.setAccount(account);
		this.setPassword(password);
		this.setUserStatus(userStatus);
		this.shoppingCart = shoppingCart;
		this.orderList = orderList;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Customer [shoppingCart=" + shoppingCart + ", orderList=" + orderList + "]";
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
