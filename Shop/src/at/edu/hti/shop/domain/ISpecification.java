package at.edu.hti.shop.domain;

public interface ISpecification {
	
    boolean IsSatisfiedBy(Product<?> candidate);
    ISpecification And(ISpecification other);
    ISpecification Or(ISpecification other);
    ISpecification Not();

}
