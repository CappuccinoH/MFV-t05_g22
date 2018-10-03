package mvf.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import mvf.boundary.*;
import mvf.pojo.*;

public class Controller {
	private User user;
	private ProdList prodList;

	public void write(String str) {
		try {
			PrintWriter pw = new PrintWriter("data.txt");
			pw.print(str);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String read() {
		StringBuilder sb = new StringBuilder();
		try {
			FileReader fr = new FileReader("data.txt");
			Scanner console = new Scanner(fr);
			while (console.hasNextLine()) {
				sb.append(console.nextLine());
				if (console.hasNextLine()) {
					sb.append("\r\n");
				}
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new View().welcome();
	}
}
