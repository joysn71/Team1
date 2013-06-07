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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderLine other = (OrderLine) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderLine [" + product + ", " + amount + "]";
	}
	
}
