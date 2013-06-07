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
	public boolean isSatisfiedBy(Product candidate) {
		//gewicht && category
		return one.isSatisfiedBy(candidate) && other.isSatisfiedBy(candidate);
	}

}
