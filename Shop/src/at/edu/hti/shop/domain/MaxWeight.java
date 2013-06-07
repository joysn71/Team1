package at.edu.hti.shop.domain;

public class MaxWeight extends CompositeSpecification {

	private int maxWeight;
	private double currentWeight;

	public MaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
		this.currentWeight = 0;
	}

	@Override
	public boolean isSatisfiedBy(Product candidate) {

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

}
