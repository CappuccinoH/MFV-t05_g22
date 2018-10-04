package mvf.model;

import java.util.ArrayList;

public class Charity {
	private int charityId;
	private String charityName;
	private ArrayList<Product> prodList;

	public Charity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Charity(int charityId, String charityName, ArrayList<Product> prodList) {
		super();
		this.charityId = charityId;
		this.charityName = charityName;
		this.prodList = prodList;
	}

	public int getCharityId() {
		return charityId;
	}

	public void setCharityId(int charityId) {
		this.charityId = charityId;
	}

	public String getCharityName() {
		return charityName;
	}

	public void setCharityName(String charityName) {
		this.charityName = charityName;
	}

	public ArrayList<Product> getProdList() {
		return prodList;
	}

	public void setProdList(ArrayList<Product> prodList) {
		this.prodList = prodList;
	}

	@Override
	public String toString() {
		return "Charity [charityId=" + charityId + ", charityName=" + charityName + ", prodList=" + prodList + "]";
	}

}
