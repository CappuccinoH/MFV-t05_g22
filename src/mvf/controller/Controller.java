package mvf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public static void main(String[] args) {
		Controller controller = new Controller();
		FileIO f = new FileIO("test");
		String str = "";
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(sdf.format(d));
		try {
			Date dd = sdf.parse(sdf.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.write(str);
		// load info
		controller.getUserList().load();
		controller.getOrderList().load();
		// view
		controller.getView().welcome();
		controller.getView().loginView();

//		controller.getUserList().save();
	}
}
