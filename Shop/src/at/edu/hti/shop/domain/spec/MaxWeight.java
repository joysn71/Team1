package at.edu.hti.shop.domain.spec;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class MaxWeight extends CompositeSpecification {

	private int maxWeight;

	public MaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public boolean isSatisfiedBy(Order order, Product candidate) {
		
		double currentWeight = 0;
		for (OrderLine line : order.getLines()) {
			currentWeight += line.getProduct().getWeight() * line.getAmount();
		}

		if (currentWeight == 0) {
			currentWeight = candidate.getWeight();
			return true;
		}

		currentWeight = currentWeight + candidate.getWeight();

		if (currentWeight > maxWeight) {
			currentWeight = candidate.getWeight();
			return false;
		}

		return true;
	}

	@Override
	public int compare(OrderLine o1, OrderLine o2) {
		if (o1.getProduct().getWeight() < o2.getProduct().getWeight()) {
			return -1;
		}
		if (o2.getProduct().getWeight() < o1.getProduct().getWeight()) {
			return 1;
		}
		return 0;
	}

}
