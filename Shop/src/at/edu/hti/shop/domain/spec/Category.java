package at.edu.hti.shop.domain.spec;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ShipmentLine;

public class Category extends CompositeSpecification {

	@Override
	public boolean isSatisfiedBy(List<ShipmentLine> lines, Product candidate) {
		
		if (!lines.isEmpty()) {
			return lines.get(0).getLine().getProduct().getCategory().equals(candidate.getCategory());
		}
		
		return true;
	}
	
	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		return o1.getProduct().getCategory().compareTo(o2.getProduct().getCategory());
	}

}
