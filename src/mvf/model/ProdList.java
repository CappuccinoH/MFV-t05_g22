package mvf.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProdList {
	private ArrayList<Product> prodList;

	public ProdList() {
		super();
		prodList = new ArrayList<Product>();
		// TODO Auto-generated constructor stub
	}

	public ProdList(ArrayList<Product> prodList) {
		super();
		this.prodList = prodList;
	}

	public ArrayList<Product> getProdList() {
		return prodList;
	}

	public void setProdList(ArrayList<Product> prodList) {
		this.prodList = prodList;
	}

	@Override
	public String toString() {
		return "ProdList [prodList=" + prodList + "]";
	}

	public void addProdusct() {
		Scanner console = new Scanner(System.in);
		System.out.println("Please enter Product ID:");
		// id
		String prodId = console.nextLine();
		while (!validateProdIdPK(prodId)) {
			System.out.println("Please enter Product ID:");
			prodId = console.nextLine();
		}
		// name
		System.out.println("Please enter Product Name:");
		String prodName = console.nextLine();
		while (!validateProdName(prodName)) {
			System.out.println("Please enter Product Name:");
			prodName = console.nextLine();
		}
		// shelf life
		System.out.println("Please enter Product Shelf Life: (format: xx (days))");
		String strDays = console.nextLine();
		while (!validateShelfLife(strDays)) {
			strDays = console.nextLine();
		}
		int days = Integer.parseInt(strDays);
		Date shelfLife = new Date(System.currentTimeMillis() + days * 1000 * 60 * 60 * 24);
		// qty
		System.out.println("Please enter Product Quantity:");
		String strQty = console.nextLine();
		while (!validateQTY(strQty)) {
			System.out.println("Please enter Product Price:");
			strQty = console.nextLine();
		}
		double prodQty = Double.parseDouble(strQty);
		// price
		System.out.println("Please enter Product Price:");
		String strPrice = console.nextLine();
		while (!validatePrice(strPrice)) {
			System.out.println("Please enter Product Price:");
			strPrice = console.nextLine();
		}
		double prodPrice = Double.parseDouble(strPrice);
		// packing type
		System.out.println("Please enter Product Packing Type:");
		String packingType = console.nextLine();
		while (!validatePackingType(packingType)) {
			System.out.println("Please enter Product Packing Type:");
			packingType = console.nextLine();
		}
		// source
		System.out.println("Please enter Product Source:(local or overseas)");
		String prodSource = console.nextLine();
		while (!validateSource(prodSource)) {
			System.out.println("Please enter Source:");
			prodSource = console.nextLine();
		}
		prodList.add(new Product(prodId, prodName, shelfLife, prodQty, prodPrice, packingType, prodSource));
	}

	public void removeProduct() {
		System.out.println("You want to remove product by No. or Product ID?");
		System.out.println("1. By NO.");
		System.out.println("2. By ID");
		Scanner console = new Scanner(System.in);
		String option = console.nextLine();
		while (!option.equals("1") && !option.equals("2")) {
			System.out.println("You can only choose 1 or 2");
			option = console.nextLine();
		}
		if (option.equals("1")) {
			System.out.println("Enter the No . of product which you want to remove:");
			String choice = console.nextLine();
			while (!choice.matches("[0-9]{1,}")
					|| !(Integer.parseInt(choice) <= prodList.size() && Integer.parseInt(choice) >= 1)) {
				// need to be updated
				System.out.println("Please enter the number of product");
				choice = console.nextLine();
			}
			prodList.remove(Integer.parseInt(choice) - 1);
		} else {
			System.out.println("Enter the Product Id which you want to remove:");
			Product product = searchById(console.nextLine());
			while (product == null) {
				System.out.println("Re-enter the Product ID");
				product = searchById(console.nextLine());
			}
			prodList.remove(product);
		}
	}

	public void editProduct() {
		System.out.println("You want to edit product by No. or Product ID?");
		System.out.println("1. By NO.");
		System.out.println("2. By ID");
		Scanner console = new Scanner(System.in);
		String option = console.nextLine();
		while (!option.equals("1") && !option.equals("2")) {
			System.out.println("You can only choose 1 or 2");
			option = console.nextLine();
		}
		Product product = new Product();
		if (option.equals("1")) {
			System.out.println("Enter the No . of product which you want to edit:");
			String choice = console.nextLine();
			while (!choice.matches("[0-9]{1,}")
					|| !(Integer.parseInt(choice) <= prodList.size() && Integer.parseInt(choice) >= 1)) {
				System.out.println("Please enter the number of product");
				choice = console.nextLine();
			}
			product = prodList.get(Integer.parseInt(choice) - 1);

		} else {
			System.out.println("Enter the Product Id which you want to edit:");
			product = searchById(console.nextLine());
			while (product == null) {
				System.out.println("Re-enter the Product ID");
				product = searchById(console.nextLine());
			}
		}
		// enter new data
		System.out.println("Product ID is :" + product.getProdId());
		System.out.println("Please enter new Product ID:");
		// id
		String prodId = console.nextLine();
		while (!validateProdIdPK(prodId)) {
			System.out.println("Please enter Product ID:");
			prodId = console.nextLine();
		}
		// name
		System.out.println("Product Name is :" + product.getProdName());
		System.out.println("Please enter Product Name:");
		String prodName = console.nextLine();
		while (!validateProdName(prodName)) {
			System.out.println("Please enter Product Name:");
			prodName = console.nextLine();
		}
		// shelf life
		System.out.println("Product Shelf life is :" + product.getShelfLife());
		System.out.println("Please enter Product Shelf Life: (format: xx (days))");
		String strDays = console.nextLine();
		while (!validateShelfLife(strDays)) {
			strDays = console.nextLine();
		}
		int days = Integer.parseInt(strDays);
		Date shelfLife = new Date(System.currentTimeMillis() + days * 1000 * 60 * 60 * 24);
		// qty
		System.out.println("Product Quantity is :" + product.getProdQty());
		System.out.println("Please enter Product Quantity:");
		String strQty = console.nextLine();
		while (!validateQTY(strQty)) {
			System.out.println("Please enter Product Price:");
			strQty = console.nextLine();
		}
		double prodQty = Double.parseDouble(strQty);
		// price
		System.out.println("Product Price is :" + product.getProdPrice());
		System.out.println("Please enter Product Price:");
		String strPrice = console.nextLine();
		while (!validatePrice(strPrice)) {
			System.out.println("Please enter Product Price:");
			strPrice = console.nextLine();
		}
		double prodPrice = Double.parseDouble(strPrice);
		// packing type
		System.out.println("Product Packing Type is :" + product.getPackingType());
		System.out.println("Please enter Product Packing Type:");
		String packingType = console.nextLine();
		while (!validatePackingType(packingType)) {
			System.out.println("Please enter Product Packing Type:");
			packingType = console.nextLine();
		}
		// source
		System.out.println("Product Source is :" + product.getProdSource());
		System.out.println("Please enter Product Source:(local or overseas)");
		String prodSource = console.nextLine();
		while (!validateSource(prodSource)) {
			System.out.println("Please enter Source:");
			prodSource = console.nextLine();
		}
		// update info
		product.setProdId(prodId);
		product.setProdName(prodName);
		product.setShelfLife(shelfLife);
		product.setProdQty(prodQty);
		product.setProdPrice(prodPrice);
		product.setPackingType(packingType);
		product.setProdSource(prodSource);
	}

	public Product searchById(String prodId) {
		for (Product product : prodList) {
			if (product.getProdId().equals(prodId)) {
				return product;
			}
		}
		System.out.println("Product not found");
		return null;
	}

	public void searchByProdName(String prodName) {

	}

	public void viewAllProduct() {
		for (Product product : prodList) {
			System.out.println("Product " + (prodList.indexOf(product) + 1) + " : ");
			System.out.println(product);
			System.out.println();
		}
	}

	public void load() {
		FileIO fileIO = new FileIO("ProdInfo.txt");
		if (new File(fileIO.getFilePath()).exists()) {
			String prodInfo = fileIO.read();
			String[] prodUnit = prodInfo.split("\r\n");
			for (int index = 0; index < prodUnit.length; index++) {
				try {
					String[] prodArr = prodUnit[index].split(",");
					String prodId = prodArr[0];
					String prodName = prodArr[1];
					Date shelfLife = new Date();
					shelfLife = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(prodArr[2]);
					double prodQty = Double.valueOf(prodArr[3]);
					double prodPrice = Double.valueOf(prodArr[4]);
					String packingType = prodArr[5];
					String prodSource = prodArr[6];
					prodList.add(new Product(prodId, prodName, shelfLife, prodQty, prodPrice, packingType, prodSource));
				} catch (ParseException e) {
					e.printStackTrace();
					System.out.println("Date format error, initial product failed");
				}
			}
		} else {
			System.out.println("Product Information not exists, please contact with admin");
		}
	}

	public void save() {
		if (prodList != null) {
			FileIO fileIO = new FileIO("ProdInfo.txt");
			StringBuilder sb = new StringBuilder();
			for (Product prod : prodList) {
				String prodId = prod.getProdId();
				String prodName = prod.getProdName();
				String shelfLife = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(prod.getShelfLife());
				String prodQty = String.valueOf(prod.getProdQty());
				String prodPrice = String.valueOf(prod.getProdPrice());
				String packingType = prod.getPackingType();
				String prodSource = prod.getProdSource();
				sb.append(prodId + "," + prodName + "," + shelfLife + "," + prodQty + "," + prodPrice + ","
						+ packingType + "," + prodSource);
				if (prodList.indexOf(prod) != prodList.size() - 1) {
					sb.append("\r\n");
				}
			}
			fileIO.write(sb.toString());
		} else {
			System.out.println("Error, there is no Product to be saved");
		}
	}

	public boolean validateProdIdPK(String prodId) {
		if (prodId.length() != 4) {
			System.out.println("Product ID should be 4 Characters");
			return false;
		}
		for (Product product : prodList) {
			if (product.getProdId().equals(prodId)) {
				System.out.println("Product ID has been used");
				return false;
			}
		}
		return true;
	}

	public boolean validateProdName(String prodName) {
		if (prodName.length() > 20 || prodName.length() < 1) {
			System.out.println("Product Name should be in 1-20 Characters");
			return false;
		}
		return true;
	}

	public boolean validateShelfLife(String strDays) {
		char[] charArray = strDays.toCharArray();
		for (char c : charArray) {
			if (!Character.isDigit(c)) {
				System.out.println("Please follow the format:xx(days)");
				return false;
			}
		}
		return true;
	}

	public boolean validateQTY(String strQty) {
		if (strQty.matches("[0-9]{1,}.{0,1}[0-9]{0,}")) {
			return true;
		}
		System.out.println("Product Quantity should be the double datatype");
		return false;
	}

	public boolean validatePrice(String strPrice) {
		if (strPrice.matches("[0-9]{1,}.{0,1}[0-9]{0,}")) {
			return true;
		}
		System.out.println("Product Price should be the double datatype");
		return false;
	}

	public boolean validatePackingType(String packingType) {
		if (packingType.length() < 1 || packingType.length() > 20) {
			System.out.println("Product Packing Type should be 1-20 characters");
			return false;
		}
		return true;
	}

	public boolean validateSource(String source) {
		if (source.equals("overseas") || source.equals("local")) {
			return true;
		}
		System.out.println("source can only be OVERSEAS or LOCAL");
		return false;
	}
}
