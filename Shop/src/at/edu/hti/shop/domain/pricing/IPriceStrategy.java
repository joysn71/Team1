package at.edu.hti.shop.domain.pricing;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;

public interface IPriceStrategy {

	public double calcPrice(List<OrderLine> lines);
	
}
