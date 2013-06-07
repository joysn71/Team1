package at.edu.hti.shop.domain.spec;

import java.util.Comparator;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public interface ISpecification extends Comparator<OrderLine> {
	
    boolean isSatisfiedBy(Order order, Product candidate);
    ISpecification and(ISpecification other);
    ISpecification or(ISpecification other);
    ISpecification not();
    void sort(Order order);
}
