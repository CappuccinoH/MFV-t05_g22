package mvf.model;

public class Order {
	private int orderId;
	private String custAccount;
	private PaymentDetail paymentDetail;
	private OrderDetail orderDetail;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String custAccount, PaymentDetail paymentDetail, OrderDetail orderDetail) {
		super();
		this.orderId = orderId;
		this.custAccount = custAccount;
		this.paymentDetail = paymentDetail;
		this.orderDetail = orderDetail;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(String custAccount) {
		this.custAccount = custAccount;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custAccount=" + custAccount + ", paymentDetail=" + paymentDetail
				+ ", orderDetail=" + orderDetail + "]";
	}

}
