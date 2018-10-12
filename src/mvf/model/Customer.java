package mvf.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {

	private ShoppingCart shoppingCart;
	private ArrayList<Order> orderList;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String account, String password) {
		super(account, password, "customer");
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

	public void addToCart() {

	}

	public void removeFromCart() {

	}

	public void generateOrder() {
		Scanner console = new Scanner(System.in);
		int orderId = console.nextInt();
		String custAccount = console.nextLine();
		new Order(orderId, custAccount, paymentDetail, orderDetail);
	}

	public void pay() {
		double price = this.getShoppingCart().getPrice();
		this.generateOrder();
	}
}
