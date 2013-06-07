package at.edu.hti.shop;

import java.util.List;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.OrderManager;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.pricing.PriceStrategyFactory;
import at.edu.hti.shop.domain.spec.Category;
import at.edu.hti.shop.domain.spec.MaxWeight;
import at.edu.hti.shop.domain.spec.ProductCategory;

public class App {
	public static void main(String[] args) {

		Order shopOrder = new Order(
				PriceStrategyFactory.getStrategy("DefaultStrategy"));

		OrderLine line1 = new OrderLine(new Product(
				ProductCategory.LEBENSMITTEL, 1, "Äpfel", 1.2, 10, 7), 4);
		OrderLine line2 = new OrderLine(new Product(
				ProductCategory.LEBENSMITTEL, 2, "Birnen", 1.5, 2, 14), 2);

		// OrderLine line3 = new OrderLine(new Product(
		// ProductCategory.LEBENSMITTEL, 3, "Pfirsich", 2.2, 3, 21), 5);
		// OrderLine line4 = new OrderLine(new Product(
		// ProductCategory.LEBENSMITTEL, 4, "Kiwi", 3.5, 5, 30), 6);

		OrderLine line3 = new OrderLine(new Product(ProductCategory.WERKZEUG,
				3, "Schraubenzieher", 2.2, 3, 21), 5);
		OrderLine line4 = new OrderLine(new Product(
				ProductCategory.LEBENSMITTEL, 4, "Kiwi", 3.5, 5, 30), 6);

		shopOrder.addLine(line1);
		shopOrder.addLine(line2);
		shopOrder.addLine(line3);
		shopOrder.addLine(line4);

		// ****** split order
		List<Order> orders = OrderManager.splitOrder(shopOrder,
				new Category().and(new MaxWeight(10)));

		for (Order order : orders) {
			System.out.println("Order:");
			for (OrderLine line : order.getLines()) {
				System.out.println("OrderLine: " + line);
			}
			System.out.println("----------\n");
		}

		System.out.println(shopOrder.getLines().size());
		System.out.println(shopOrder);

		line1.setAmount(8);

		System.out.println(shopOrder.getLines().size());
		System.out.println(shopOrder);

		line2.setAmount(0);

		System.out.println(shopOrder.getLines().size());
		System.out.println(shopOrder);

		shopOrder.addLine(line3);
		shopOrder.addLine(line4);

	}
}
