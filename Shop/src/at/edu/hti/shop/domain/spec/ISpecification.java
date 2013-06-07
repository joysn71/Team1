package at.edu.hti.shop.domain.spec;

import java.util.Comparator;
import java.util.List;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ShipmentLine;

public interface ISpecification extends Comparator<OrderLine> {
	
    boolean isSatisfiedBy(List<ShipmentLine> lines, Product candidate);
    ISpecification and(ISpecification other);
    ISpecification or(ISpecification other);
    ISpecification not();
    void sort(Order order);
}
