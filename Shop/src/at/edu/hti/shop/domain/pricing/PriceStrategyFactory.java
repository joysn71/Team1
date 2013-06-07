package at.edu.hti.shop.domain.pricing;

public class PriceStrategyFactory {
	
	public static IPriceStrategy getStrategy(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException("Strategy id needed!");
		}
		
		switch (id) {
		case "DefaultStrategy":
			return new DefaultPriceStrategy();

		case "FreeShippingPriceStrategy":
			return new FreeShippingPriceStrategy();
		}
		
		throw new IllegalArgumentException("Strategy with id '"+id+"' not supported!");
	}

}
