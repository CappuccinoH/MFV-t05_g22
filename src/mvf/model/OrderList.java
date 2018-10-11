package mvf.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderList {
	private ArrayList<Order> orderList;

	public OrderList() {
		super();
		orderList = new ArrayList<Order>();
	}

	public OrderList(ArrayList<Order> orderList) {
		super();
		this.orderList = orderList;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "OrderList [orderList=" + orderList + "]";
	}

	public Order searchByOrderId(int orderId) {
		for (Order order : orderList) {
			if (order.getOrderId() == orderId) {
				return order;
			}
		}
		System.out.println("order not found");
		return null;
	}

	public void searchByAccount(String account) {

	}

	public void load() {
		FileIO fileIO = new FileIO("OrderInfo.txt");
		if (new File(fileIO.getFilePath()).exists()) {
			String orderInfo = fileIO.read();
			String[] orderUnit = orderInfo.split("\r\n");
			for (int index = 0; index < orderUnit.length; index++) {
				String[] orderArr = orderUnit[index].split(",");
				try {
					int orderId = Integer.parseInt(orderArr[0]);
					String custAccount = orderArr[1];
					int paymentId = Integer.parseInt(orderArr[2]);
					Date time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(orderArr[3]);
					double actualCost = Double.parseDouble(orderArr[4]);
					int orderDetailId = Integer.parseInt(orderArr[5]);
					String[] prodRepository = orderArr[6].split("\\|");
					ArrayList<ProductRepository> arrPR = new ArrayList<ProductRepository>();
					for (int i = 0; i < prodRepository.length; i++) {
						ProdList prodList = new ProdList();
						prodList.load();
						Product product = prodList.searchById(prodRepository[i].split(":")[0]);
						double amount = Double.parseDouble(prodRepository[i].split(":")[1]);
						arrPR.add(new ProductRepository(product, amount));
					}
					double totalCost = Double.parseDouble(orderArr[7]);
					orderList.add(new Order(orderId, custAccount, new PaymentDetail(paymentId, time, actualCost),
							new OrderDetail(orderDetailId, arrPR, totalCost)));
				} catch (Exception e) {
					System.out.println("Date format error");
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Order Information not exists, please contact with admin");
		}
	}

	public void save() {
		if (orderList != null) {
			FileIO fileIO = new FileIO("OrderInfo.txt");
			StringBuilder sb = new StringBuilder();
			for (Order order : orderList) {
				int orderId = order.getOrderId();
				String custAccount = order.getCustAccount();
				int paymentId = order.getPaymentDetail().getPaymentId();
				Date time = order.getPaymentDetail().getTime();
				double actualCost = order.getPaymentDetail().getActualCost();
				int orderDetailId = order.getOrderDetail().getOrderDetailId();
				// save
				sb.append(String.valueOf(orderId) + "," + custAccount + "," + String.valueOf(paymentId) + ","
						+ new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(time) + "," + String.valueOf(actualCost)
						+ "," + String.valueOf(orderDetailId) + ",");
				ArrayList<ProductRepository> prodRepository = order.getOrderDetail().getProdRepository();
				for (ProductRepository pr : prodRepository) {
					sb.append(pr.getProduct().getProdId() + ":" + pr.getAmount());
					if (prodRepository.indexOf(pr) != prodRepository.size() - 1) {
						sb.append("|");
					}
				}
				double totalCost = order.getOrderDetail().getTotalCost();
				sb.append("," + String.valueOf(totalCost));
				if (orderList.indexOf(order) != orderList.size() - 1) {
					sb.append("\r\n");
				}
			}
			fileIO.write(sb.toString());
		} else {
			System.out.println("Error, there is no Order to be saved");
		}
	}
}
