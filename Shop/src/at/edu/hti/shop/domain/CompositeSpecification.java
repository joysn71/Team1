package at.edu.hti.shop.domain;

public abstract class CompositeSpecification implements ISpecification {

	public abstract boolean IsSatisfiedBy(Product<?> candidate);

	@Override
	public ISpecification And(ISpecification other) {
		return new AndSpecification(this, other);
	}

	@Override
	public ISpecification Or(ISpecification other) {
		return new OrSpecification(this, other);
	}

	@Override
	public ISpecification Not() {
		return new NotSpecification(this);
	}

}
