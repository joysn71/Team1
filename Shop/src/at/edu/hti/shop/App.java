package at.edu.hti.shop;

import at.edu.hti.shop.domain.DefaultPriceStrategy;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;

public class App {
	public static void main(String[] args) {

		Order shopOrder = new Order(new DefaultPriceStrategy());

		OrderLine line1 = new OrderLine(new Product(1, "Äpfel", 1.2), 4);
		OrderLine line2 = new OrderLine(new Product(2, "Birnen", 1.5), 2);

		OrderLine line3 = new OrderLine(new Product(3, "Pfirsich", 2.2), 5);
		OrderLine line4 = new OrderLine(new Product(4, "Kiwi", 3.5), 6);

		shopOrder.add(line1);
		shopOrder.add(line2);
		System.out.println(shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setAmount(0, 8);

		System.out.println(shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setAmount(1, 0);

		System.out.println(shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.add(line3);
		shopOrder.add(line4);

	}
}
