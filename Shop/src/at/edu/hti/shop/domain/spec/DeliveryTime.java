package at.edu.hti.shop.domain.spec;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class DeliveryTime extends CompositeSpecification {

	@Override
	public boolean isSatisfiedBy(Order order, Product candidate) {
		
		if (!order.getLines().isEmpty()) {
			if (order.getLines().get(0).getProduct().getDeliveryTime() == candidate.getDeliveryTime()) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		if (o1.getProduct().getDeliveryTime() < o2.getProduct().getDeliveryTime()) {
			return -1;
		}
		if (o2.getProduct().getDeliveryTime() < o1.getProduct().getDeliveryTime()) {
			return 1;
		}
		return 0;
	}

}
