package at.edu.hti.shop.domain;

public abstract class CompositeSpecification implements ISpecification {

	public abstract boolean isSatisfiedBy(Product candidate);

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

}
