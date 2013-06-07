package at.edu.hti.shop.domain.spec;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ShipmentLine;

public class NotSpecification extends CompositeSpecification {
	
	private ISpecification wrapped;
	 
    public NotSpecification(ISpecification x) 
    {
        wrapped = x;
    }

	@Override
	public boolean isSatisfiedBy(List<ShipmentLine> lines, Product candidate) {
		return !wrapped.isSatisfiedBy(lines, candidate);
	}
	
	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		return -1;
	}

}
