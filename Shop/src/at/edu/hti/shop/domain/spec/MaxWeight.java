package at.edu.hti.shop.domain.spec;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ShipmentLine;

public class MaxWeight extends CompositeSpecification {

	private int maxWeight;

	public MaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public boolean isSatisfiedBy(List<ShipmentLine> lines, Product candidate) {
		
		double currentWeight = 0;
		for (ShipmentLine shippmentLine : lines) {
			currentWeight += shippmentLine.getLine().getProduct().getWeight() * shippmentLine.getAmount();
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
