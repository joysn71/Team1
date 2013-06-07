package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.edu.hti.shop.domain.spec.ISpecification;

public class OrderManager {

	public static List<Order> splitOrder(Order order,
			ISpecification specification) {

		List<Order> allSplittedOrders = new ArrayList<Order>();

		OrderLine splitLine = null;

		for (OrderLine orderLine : order.getLines()) {

			int amount = orderLine.getAmount();

			Product product = orderLine.getProduct();

			while (amount > 0) {

				// iterate over all split portions and try to fit order line
				// into portion

				for (Order splittedOrder : allSplittedOrders) {

					while (amount > 0) {

						if (specification.isSatisfiedBy(splittedOrder, product)) {

							// order line fits into already splitted portion,
							// check if order line changed and if new one needs
							// to be created with adapted amount

							if (splitLine == null
									|| !splitLine.equals(orderLine)) {
								splitLine = new OrderLine(
										orderLine.getProduct(), 0);
								splittedOrder.addLine(splitLine);
							}

							splitLine.setAmount(splitLine.getAmount() + 1);
							amount--;
						} else {
							break;
						}
					}
				}

				// still products left from order line, create new split order

				if (amount > 0) {
					splitLine = new OrderLine(orderLine.getProduct(), 0);

					Order splittedOrder = new Order(order.getPriceStrategy());
					splittedOrder.addLine(splitLine);

					allSplittedOrders.add(splittedOrder);
				}
			}
		}

		return allSplittedOrders;
	}

	public static Order mergeOrder(List<Order> orders) {

		if (orders.isEmpty()) {
			return null;
		}

		Map<OrderLine, Integer> uniqueLines = new HashMap<OrderLine, Integer>();

		for (Order order : orders) {

			for (OrderLine orderLine : order.getLines()) {
				if (uniqueLines.containsKey(orderLine)) {
					uniqueLines.put(orderLine, uniqueLines.get(orderLine)
							+ orderLine.getAmount());
				} else {
					uniqueLines.put(orderLine, orderLine.getAmount());
				}
			}

		}

		Order mergedOrder = new Order();
		
		for (OrderLine line : uniqueLines.keySet()) {
			line.setAmount(uniqueLines.get(line));
			mergedOrder.addLine(line);
		}

		return mergedOrder;
	}

}
