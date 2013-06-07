package at.edu.hti.shop.domain.spec;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class DeliveryTime extends CompositeSpecification {

	@Override
	public boolean isSatisfiedBy(List<OrderLine> lines, Product candidate) {
		
		if (!lines.isEmpty()) {
			if (lines.get(0).getProduct().getDeliveryTime() == candidate.getDeliveryTime()) {
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
