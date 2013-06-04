package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	List<OrderLine> lines = new ArrayList<OrderLine>();
	IPriceStrategy strategy;

	public Order(IPriceStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean add(OrderLine e) {

		if (e == null)
			return false;

		return lines.add(e);
	}

	public double calcPrize() {
		return strategy.calcPrice(lines);
	}

	public int size() {
		return lines.size();
	}

	public void setAmount(int index, int amount) {
		OrderLine line = lines.get(index);
		if (line == null) {
			return;
		}

		if (amount == 0) {
			lines.remove(index);
		} else {
			line.setAmount(amount);
		}
	}

	@Override
	public String toString() {
		return lines.toString() + " \n =>" + calcPrize();
	}
}
