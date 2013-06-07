package at.edu.hti.shop.domain;

public interface ISpecification {
	
    boolean isSatisfiedBy(Product candidate);
    ISpecification and(ISpecification other);
    ISpecification or(ISpecification other);
    ISpecification not();

}
