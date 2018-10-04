package mvf.boundary;

import java.util.Scanner;

public class View {
	public void welcome() {
		System.out.println("+==================================================+");
		System.out.println("|                                                  |");
		System.out.println("|         Monash Vegetable & Fruit System          |");
		System.out.println("|                                                  |");
		System.out.println("+==================================================+");
	}

	public String[] loginView() {
		System.out.println("Please login first...");
		Scanner console = new Scanner(System.in);
		String[] userInfo = new String[2];
		System.out.println("Please enter you account:");
		userInfo[0] = console.nextLine();
		System.out.println("Please enter your password:");
		userInfo[1] = console.nextLine();
		return userInfo;
	}

	public void logoutView() {

	}

	public void menuForOwner() {

	}

	public void menuForCustomer() {

	}

	public void displayInformation(String information) {

	}
}
