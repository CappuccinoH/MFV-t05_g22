package mvf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import mvf.boundary.*;
import mvf.model.*;

public class Controller {
	private View view;
	private UserList userList;
	private OrderList orderList;
	private ProdList prodList;

	public Controller() {
		view = new View();
		userList = new UserList();
		orderList = new OrderList();
		prodList = new ProdList();
	}

	public Controller(View view, UserList userList, OrderList orderList, ProdList prodList) {
		super();
		this.view = view;
		this.userList = userList;
		this.orderList = orderList;
		this.prodList = prodList;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public UserList getUserList() {
		return userList;
	}

	public void setUserList(UserList userList) {
		this.userList = userList;
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	public ProdList getProdList() {
		return prodList;
	}

	public void setProdList(ProdList prodList) {
		this.prodList = prodList;
	}

	public static void main(String[] args) throws ParseException {
		Controller controller = new Controller();

		controller.getUserList().load();
		controller.getProdList().load();
		controller.getOrderList().load();

		// load user
		// controller.getUserList().load();
		// Product carrot = new Product("1x23", "carrot",
		// new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("09/10/2018 23:39:47"), 1,
		// 1.3, "package", "local");
		// Product potato = new Product("1x222", "potato",
		// new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("03/10/2018 23:39:47"), 1,
		// 4, "unit", "local");
		// ProductRepository c = new ProductRepository(carrot, 2);
		// ProductRepository d = new ProductRepository(potato, 23);
		// ArrayList<ProductRepository> arrayList = new ArrayList<ProductRepository>();
		// arrayList.add(c);
		// arrayList.add(d);
		// User user = new Customer("test", "test", "customer", new ShoppingCart(1,
		// arrayList, 500),
		// controller.getOrderList().getOrderList());
		// controller.getUserList().getUserList().add(user);
		// controller.getUserList().save();

		// load product
		// Product carrot = new Product("1x23", "carrot",
		// new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("09/10/2018 23:39:47"), 1,
		// 1.3, "package", "local");
		// Product potato = new Product("1x222", "potato",
		// new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("03/10/2018 23:39:47"), 1,
		// 4, "unit", "local");
		// controller.getProdList().getProdList().add(potato);
		// controller.getProdList().getProdList().add(carrot);
		// controller.getProdList().save();

		// controller.getProdList().load();

		// load order
		// ArrayList<ProductRepository> arrPR = new ArrayList<ProductRepository>();
		// arrPR.add(new ProductRepository(carrot, 5));
		// arrPR.add(new ProductRepository(potato, 2));
		// OrderDetail orderDetail = new OrderDetail(1, arrPR, 500);
		// PaymentDetail paymentDetail = new PaymentDetail(1,
		// new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("03/10/2018 23:39:47"),
		// 400);
		// controller.getOrderList().getOrderList().add(new Order(21, "admin",
		// paymentDetail, orderDetail));
		// controller.getOrderList().save();

		// controller.getOrderList().load();

		// view
		controller.getView().welcome();
		User user = controller.getUserList().login();
		while (user == null) {
			user = controller.getUserList().login();
		}
		controller.getView().loginView(user.getAccount());
		if (user.getUserStatus().equals("owner")) {
			controller.getView().menuForOwner();
			Scanner console = new Scanner(System.in);
			String option = console.nextLine();
			while (true) {
				switch (option) {
				case "1":
					controller.getProdList().addProdusct();
					break;
				case "2":
					controller.getProdList().viewAllProduct();
					break;
				case "3":
					break;
				case "4":
					controller.getProdList().removeProduct();
					break;
				case "5":

					break;
				case "6":

					break;
				case "x":
					controller.getView().logoutView(user.getAccount());
					controller.getProdList().save();
					System.exit(0);
					break;
				default:
					System.out.println("Please enter correct option");
				}
				System.out.println("press ENTER to continue...");
				controller.getView().menuForOwner();
				option = console.nextLine();
			}
		} else if (user.getUserStatus().equals("customer")) {
			controller.getView().menuForCustomer();
			Scanner console = new Scanner(System.in);
			String option = console.nextLine();
			while (true) {
				switch (option) {
				case "1":

					break;
				case "2":

					break;
				case "3":
					controller.getProdList().viewAllProduct();
					break;
				case "4":

					break;
				case "5":

					break;
				case "6":

					break;
				case "x":
					System.exit(0);
					break;
				default:
					System.out.println("Please enter correct option");
				}
				System.out.println("press ENTER to continue...");
				controller.getView().menuForCustomer();
				option = console.nextLine();
			}
		} else {
			System.out.println("Error");
		}

//		controller.getUserList().save();
	}
}
