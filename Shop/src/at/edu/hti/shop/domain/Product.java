package at.edu.hti.shop.domain;

public class Product {
	private String name;
	private long id;
	private double prize;
	private long weight; 

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

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", " + id + ", " + prize + "]";
	}

}
