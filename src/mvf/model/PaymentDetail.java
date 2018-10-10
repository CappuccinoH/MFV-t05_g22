package mvf.model;

import java.util.Date;

public class PaymentDetail {
	private int paymentId;
	private Date time;
	private double actualCost;

	public PaymentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDetail(int paymentId, Date time, double actualCost) {
		super();
		this.paymentId = paymentId;
		this.time = time;
		this.actualCost = actualCost;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getActualCost() {
		return actualCost;
	}

	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}

	@Override
	public String toString() {
		return "PaymentDetail [paymentId=" + paymentId + ", time=" + time + ", actualCost=" + actualCost + "]";
	}

}
