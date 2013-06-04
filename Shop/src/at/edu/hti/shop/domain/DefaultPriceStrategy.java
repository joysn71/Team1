package at.edu.hti.shop.domain;

import java.util.List;

public class DefaultPriceStrategy implements IPriceStrategy {

	@Override
	public double calcPrice(List<OrderLine> lines) {
		double sum = 0;

		for (OrderLine line : lines) {
			sum += line.getProduct().getPrize() * line.getAmount();
		}

		if (sum > 10) {
			return sum;
		} else {
			sum = sum + 5;
		}

		return sum;
	}

}
