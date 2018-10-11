package mvf.model;

import java.util.ArrayList;

public class OrderDetail {
	private int orderDetailId;
	private ArrayList<ProductRepository> prodRepository;
	private double totalCost;

	public OrderDetail() {
		super();

		prodRepository = new ArrayList<ProductRepository>();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int orderDetailId, ArrayList<ProductRepository> prodRepository, double totalCost) {
		super();
		this.orderDetailId = orderDetailId;
		this.prodRepository = prodRepository;
		this.totalCost = totalCost;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public ArrayList<ProductRepository> getProdRepository() {
		return prodRepository;
	}

	public void setProdRepository(ArrayList<ProductRepository> prodRepository) {
		this.prodRepository = prodRepository;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", prodRepository=" + prodRepository + ", totalCost="
				+ totalCost + "]";
	}

}
