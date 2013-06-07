package at.edu.hti.shop.domain.spec;

import java.util.Collections;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public abstract class CompositeSpecification implements ISpecification {

	public abstract boolean isSatisfiedBy(Order order, Product candidate);

	@Override
	public ISpecification and(ISpecification other) {
		return new AndSpecification(this, other);
	}

	@Override
	public ISpecification or(ISpecification other) {
		return new OrSpecification(this, other);
	}

	@Override
	public ISpecification not() {
		return new NotSpecification(this);
	}
	
	public abstract int compare(OrderLine o1, OrderLine o2);
	
	public void sort(Order order) {
		Collections.sort(order.getLines(), this);
	}

}
