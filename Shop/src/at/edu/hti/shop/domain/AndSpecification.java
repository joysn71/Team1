package at.edu.hti.shop.domain;

public class AndSpecification extends CompositeSpecification {
	
	private ISpecification one;
    private ISpecification other;

    public AndSpecification(ISpecification x, ISpecification y) 
    {
        one = x;
        other = y;
    }

	@Override
	public boolean IsSatisfiedBy(Product<?> candidate) {
		return one.IsSatisfiedBy(candidate) && other.IsSatisfiedBy(candidate);
	}

}
