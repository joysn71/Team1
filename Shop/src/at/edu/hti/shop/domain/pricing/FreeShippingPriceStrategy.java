package at.edu.hti.shop.domain.pricing;

import java.util.List;

import at.edu.hti.shop.domain.OrderLine;

public class FreeShippingPriceStrategy implements IPriceStrategy {

	@Override
	public double calcPrice(List<OrderLine> lines) {
		double sum = 0;

		for (OrderLine line : lines) {
			sum += line.getProduct().getPrize() * line.getAmount();
		}

		return sum;
	}

}
