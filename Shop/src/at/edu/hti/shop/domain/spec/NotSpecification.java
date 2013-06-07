package at.edu.hti.shop.domain.spec;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class NotSpecification extends CompositeSpecification {
	
	private ISpecification wrapped;
	 
    public NotSpecification(ISpecification x) 
    {
        wrapped = x;
    }

	@Override
	public boolean isSatisfiedBy(Order order, Product candidate) {
		return !wrapped.isSatisfiedBy(order, candidate);
	}
	
	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		return -1;
	}

}
