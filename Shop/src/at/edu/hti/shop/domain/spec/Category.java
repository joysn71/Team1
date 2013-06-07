package at.edu.hti.shop.domain.spec;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class Category extends CompositeSpecification {

	@Override
	public boolean isSatisfiedBy(Order order, Product candidate) {
		
		if (!order.getLines().isEmpty()) {
			return order.getLines().get(0).getProduct().getCategory().equals(candidate.getCategory());
		}
		
		return true;
	}
	
	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		return o1.getProduct().getCategory().compareTo(o2.getProduct().getCategory());
	}

}
