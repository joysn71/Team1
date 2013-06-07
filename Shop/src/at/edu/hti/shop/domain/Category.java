package at.edu.hti.shop.domain;

public class Category extends CompositeSpecification {

	ProductCategory category;
	
	public Category(ProductCategory category){
		this.category = category;
	}
	
	@Override
	public boolean isSatisfiedBy(Product candidate) {
		
		if (category.equals(candidate.getCategory())){
			return true;
		}
		
		return false;
	}

}
