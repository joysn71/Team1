package at.edu.hti.shop.domain;

public class ShipmentLine {
	public OrderLine line;
	public int amount;

	public ShipmentLine(OrderLine ol, int amount) {
		setLine(ol);
		setAmount(amount);
	}
	
	public OrderLine getLine() {
		return line;
	}
	public void setLine(OrderLine line) {
		this.line = line;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ShippmentLine [line=" + line + ", amount=" + amount + "]";
	}
}