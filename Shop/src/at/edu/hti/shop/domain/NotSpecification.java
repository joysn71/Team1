package at.edu.hti.shop.domain;

public class NotSpecification extends CompositeSpecification {
	
	private ISpecification wrapped;
	 
    public NotSpecification(ISpecification x) 
    {
        wrapped = x;
    }

	@Override
	public boolean IsSatisfiedBy(Product<?> candidate) {
		return !wrapped.IsSatisfiedBy(candidate);
	}

}
