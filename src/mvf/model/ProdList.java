package mvf.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
}
