package mvf.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
	private ArrayList<User> userList;

	public UserList() {
		super();
		userList = new ArrayList<User>();
	}

	public UserList(ArrayList<User> userList) {
		super();
		this.userList = userList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "UserList [userList=" + userList + "]";
	}

	public ArrayList<User> searchByUserStatus(String status) {
		ArrayList<User> arrUser = new ArrayList<User>();
		for (User user : userList) {
			if (user.getUserStatus().equals(status)) {
				arrUser.add(user);
			}
		}
		return arrUser;
	}

	public User searchByUserAccount(String account) {
		for (User user : userList) {
			if (user.getAccount().equals(account)) {
				return user;
			}
		}
		return null;
	}

	public User login() {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter your account");
		String account = console.nextLine();
		System.out.println("Please enter your password");
		String password = console.nextLine();
		for (User user : userList) {
			if (user.getAccount().equals(account) && user.getPassword().equals(password)) {
				return user;
			}
		}
		System.out.println("login failed");
		return null;
	}

	public void registerCustomer() {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter account:");
		String account = console.nextLine();
		System.out.println("Please enter password:");
		String password = console.nextLine();
		userList.add(new Customer(account, password));
	}

	public void removeCustomerByOwner() {
		ArrayList<User> arrUser = searchByUserStatus("customer");
		for (User user : arrUser) {
			System.out.println(user);
		}
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter the Customer's Account:");
		String account = console.nextLine();
		while (searchByUserAccount(account) == null || searchByUserAccount(account).getUserStatus().equals("owner")) {
			System.out.println("Re-enter account:");
			account = console.nextLine();
		}
		userList.remove(searchByUserAccount(account));
	}

	public void removeCustomerByCustomer(User user) {
		userList.remove(user);
	}

	public void load() {
		FileIO fileIO = new FileIO("UserInfo.txt");
		if (new File(fileIO.getFilePath()).exists()) {
			String userInfo = fileIO.read();
			String[] userUnit = userInfo.split("\r\n");
			for (int index = 0; index < userUnit.length; index++) {
				String[] userArr = userUnit[index].split(",");
				if (userArr[2].equals("owner")) {
					userList.add(new Owner(userArr[0], userArr[1], userArr[2]));
				} else if (userArr[2].equals("customer")) {
					int cartId = Integer.parseInt(userArr[3]);
					String[] prodRepositoryArr = userArr[4].split("\\|");
					ArrayList<ProductRepository> arrRP = new ArrayList<ProductRepository>();
					for (String unit : prodRepositoryArr) {
						String prodId = unit.split(":")[0];
						ProdList prodList = new ProdList();
						prodList.load();
						Product product = prodList.searchById(prodId);
						double amount = Double.parseDouble(unit.split(":")[1]);
						arrRP.add(new ProductRepository(product, amount));
					}
					double price = Double.parseDouble(userArr[5]);
					ArrayList<Order> arrOrder = new ArrayList<Order>();
					String[] ordId = userArr[6].split("\\|");
					for (String Id : ordId) {
						OrderList orderList = new OrderList();
						orderList.load();
						arrOrder.add(orderList.searchByOrderId(Integer.parseInt(Id)));
					}
					userList.add(new Customer(userArr[0], userArr[1]));
				}
			}
		} else {
			System.out.println("User Information not exists, please contact with admin");
		}
	}

	public void save() {
		if (userList != null) {
			FileIO fileIO = new FileIO("UserInfo.txt");
			StringBuilder sb = new StringBuilder();
			for (User user : userList) {
				String account = user.getAccount();
				String password = user.getPassword();
				String userStatus = user.getUserStatus();
				sb.append(account + "," + password + "," + userStatus);
				if (userStatus.equals("customer")) {
					Customer customer = (Customer) user;
					int cartId = customer.getShoppingCart().getCartId();
					sb.append("," + String.valueOf(cartId) + ",");
					ArrayList<ProductRepository> prodRepositroy = customer.getShoppingCart().getProdRepositroy();
					for (ProductRepository pr : prodRepositroy) {
						String prodId = pr.getProduct().getProdId();
						double amount = pr.getAmount();
						sb.append(prodId + ":" + String.valueOf(amount));
						if (prodRepositroy.indexOf(pr) != prodRepositroy.size() - 1) {
							sb.append("|");
						}
					}
					double price = customer.getShoppingCart().getPrice();
					sb.append("," + String.valueOf(price) + ",");
					ArrayList<Order> orderList = customer.getOrderList();
					for (Order order : orderList) {
						int orderId = order.getOrderId();
						sb.append(String.valueOf(orderId));
						if (orderList.indexOf(order) != orderList.size() - 1) {
							sb.append("|");
						}
					}
				}
				if (userList.indexOf(user) != userList.size() - 1) {
					sb.append("\r\n");
				}
			}
			fileIO.write(sb.toString());
		} else {
			System.out.println("Error, there is no user to be saved");
		}
	}
}
