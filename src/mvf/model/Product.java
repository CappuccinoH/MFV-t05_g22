package mvf.model;

import java.util.Date;

public class Product {
	private String prodId;
	private String prodName;
	private Date shelfLife;
	private double prodQty;
	private double prodPrice;
	private String packingType;
	private String prodSource;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String prodId, String prodName, Date shelfLife, double prodQty, double prodPrice, String packingType,
			String prodSource) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.shelfLife = shelfLife;
		this.prodQty = prodQty;
		this.prodPrice = prodPrice;
		this.packingType = packingType;
		this.prodSource = prodSource;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Date getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Date shelfLife) {
		this.shelfLife = shelfLife;
	}

	public double getProdQty() {
		return prodQty;
	}

	public void setProdQty(double prodQty) {
		this.prodQty = prodQty;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getPackingType() {
		return packingType;
	}

	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}

	public String getProdSource() {
		return prodSource;
	}

	public void setProdSource(String prodSource) {
		this.prodSource = prodSource;
	}

	@Override
	public String toString() {
//		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", shelfLife=" + shelfLife + ", prodQty="
//				+ prodQty + ", prodPrice=" + prodPrice + ", packingType=" + packingType + ", prodSource=" + prodSource
//				+ "]";

		StringBuilder sb = new StringBuilder();
		sb.append("\tProduct ID: " + prodId + "\r\n");
		sb.append("\tProduct Name: " + prodName + "\r\n");
		sb.append("\tProduct Shelf Life: " + shelfLife + "\r\n");
		sb.append("\tProduct Quantity: " + prodQty + "\r\n");
		sb.append("\tProduct Price: " + prodPrice + "\r\n");
		sb.append("\tProduct Packing Type: " + packingType + "\r\n");
		sb.append("\tProduct Source: " + prodSource);
		return sb.toString();
	}

}
