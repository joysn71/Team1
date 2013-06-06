package at.edu.hti.shop.domain;

public class Product {
	private String name;
	private long id;
	private double prize;
	private double weight; 
	private int deliveryTime;

	public Product( long id, String name, double prize) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public double getPrize() {
		return prize;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", " + id + ", " + prize + "]";
	}

}
