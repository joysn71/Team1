package at.edu.hti.shop.domain;

import java.util.List;

public interface IPriceStrategy {

	public double calcPrice(List<OrderLine> lines);
	
}
