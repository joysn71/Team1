package at.edu.hti.shop.domain;

import at.edu.hti.shop.domain.spec.ProductCategory;

public class Product {
	private String name;
	private long id;
	private double prize;
	private double weight; 
	private int deliveryTime;
	private ProductCategory category;

	public Product(ProductCategory category, long id, String name, double prize, double weight, int deliveryTime) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
		this.category = category;
		this.weight = weight;
		this.deliveryTime = deliveryTime;
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

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + ", prize=" + prize
				+ ", weight=" + weight + ", deliveryTime=" + deliveryTime
				+ ", category=" + category + "]";
	}



}
