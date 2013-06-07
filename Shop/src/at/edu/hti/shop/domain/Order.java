package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

import at.edu.hti.shop.domain.pricing.IPriceStrategy;


public class Order {

	List<OrderLine> lines = new ArrayList<OrderLine>();
	IPriceStrategy priceStrategy;

	public Order(IPriceStrategy priceStrategy) {
		setPriceStrategy(priceStrategy);
	}

	public boolean addLine(OrderLine e) {

		if (e == null)
			return false;
		
		e.setOrder(this);

		return lines.add(e);
	}
	
	public boolean removeLine(OrderLine line) {
		if (line == null)
			return false;
		
		line.setOrder(null);

		return lines.remove(line);		
	}
	
	public List<OrderLine> getLines() {
		return lines;
	}

	public double calcPrize() {
		return priceStrategy.calcPrice(lines);
	}
	
	public void setPriceStrategy(IPriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}

	@Override
	public String toString() {
		return lines.toString() + " \n =>" + calcPrize();
	}
}
