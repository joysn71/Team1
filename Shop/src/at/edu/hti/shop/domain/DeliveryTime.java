package at.edu.hti.shop.domain;

public class DeliveryTime extends CompositeSpecification {

	private int deliveryTime;
	
	public DeliveryTime(int deliveryTime){
		this.deliveryTime = deliveryTime;
	}
	
	@Override
	public boolean isSatisfiedBy(Product candidate) {
		if (deliveryTime == candidate.getDeliveryTime()) {
			return true;
		}
		
		return false;
	}

}
