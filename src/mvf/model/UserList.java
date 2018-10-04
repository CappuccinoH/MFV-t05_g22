package mvf.model;

import java.io.File;
import java.util.ArrayList;

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

	public void searchByUserStatus() {

	}

	public void searchByUserAccount() {

	}

	public void registerCustomer() {

	}

	public void login(String[] userInfo) {

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
					userList.add(new Customer(userArr[0], userArr[1], userArr[2]));
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
