package at.edu.hti.shop.domain.spec;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class AndSpecification extends CompositeSpecification {
	
	private ISpecification one;
    private ISpecification other;

    public AndSpecification(ISpecification x, ISpecification y) 
    {
        one = x;
        other = y;
    }

	@Override
	public boolean isSatisfiedBy(Order order, Product candidate) {
		//gewicht && category
		return one.isSatisfiedBy(order, candidate) && other.isSatisfiedBy(order, candidate);
	}

	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		int comp = one.compare(o1, o2);
		if (comp == 0){
			return other.compare(o1, o2);
		}
		return comp;
	}
	
}
