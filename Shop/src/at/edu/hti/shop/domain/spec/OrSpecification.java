package at.edu.hti.shop.domain.spec;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class OrSpecification extends CompositeSpecification {
	
    private ISpecification one;
    private ISpecification other;

    public OrSpecification(ISpecification x, ISpecification y) 
    {
        one = x;
        other = y;
    }

	@Override
	public boolean isSatisfiedBy(List<OrderLine> lines, Product candidate) {
		return one.isSatisfiedBy(lines, candidate) || other.isSatisfiedBy(lines, candidate);
	}
	
	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		return 0;
	}

}
