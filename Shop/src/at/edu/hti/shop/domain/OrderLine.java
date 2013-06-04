package at.edu.hti.shop.domain;

public class OrderLine {
	private Product product;
	private int amount;
	private Order order;

	public OrderLine(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount == 0 && order != null) {
			order.removeLine(this);
		}
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public double calcPrize()
	{
		return amount*product.getPrize();
	}

	@Override
	public String toString() {
		return "OrderLine [" + product + ", " + amount + "]";
	}
	
}
