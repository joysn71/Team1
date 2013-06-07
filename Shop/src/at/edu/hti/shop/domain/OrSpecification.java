package at.edu.hti.shop.domain;

public class OrSpecification extends CompositeSpecification {
	
    private ISpecification one;
    private ISpecification other;

    public OrSpecification(ISpecification x, ISpecification y) 
    {
        one = x;
        other = y;
    }

	@Override
	public boolean isSatisfiedBy(Product candidate) {
		return one.isSatisfiedBy(candidate) || other.isSatisfiedBy(candidate);
	}

}
