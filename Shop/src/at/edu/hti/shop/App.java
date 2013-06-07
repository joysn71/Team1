package at.edu.hti.shop;

import java.util.ArrayList;
import java.util.List;

import at.edu.hti.shop.domain.Category;
import at.edu.hti.shop.domain.ISpecification;
import at.edu.hti.shop.domain.MaxWeight;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.PriceStrategyFactory;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ProductCategory;
import at.edu.hti.shop.domain.Shippment;

public class App {
	public static void main(String[] args) {

		Order shopOrder = new Order(
				PriceStrategyFactory.getStrategy("DefaultStrategy"));

		OrderLine line1 = new OrderLine(new Product(
				ProductCategory.LEBENSMITTEL, 1, "Äpfel", 1.2, 1, 7), 4);
		OrderLine line2 = new OrderLine(new Product(
				ProductCategory.LEBENSMITTEL, 2, "Birnen", 1.5, 2, 14), 2);
		
//		OrderLine line3 = new OrderLine(new Product(
//				ProductCategory.LEBENSMITTEL, 3, "Pfirsich", 2.2, 3, 21), 5);
//		OrderLine line4 = new OrderLine(new Product(
//				ProductCategory.LEBENSMITTEL, 4, "Kiwi", 3.5, 5, 30), 6);

		OrderLine line3 = new OrderLine(new Product(
				ProductCategory.WERKZEUG, 3, "Schraubenzieher", 2.2, 3, 21), 5);
		OrderLine line4 = new OrderLine(new Product(
				ProductCategory.LEBENSMITTEL, 4, "Kiwi", 3.5, 5, 30), 6);

		shopOrder.addLine(line1);
		shopOrder.addLine(line2);
		shopOrder.addLine(line3);
		shopOrder.addLine(line4);

		ISpecification spec = new Category(
				ProductCategory.LEBENSMITTEL);

		List<Shippment> shippments = new ArrayList<Shippment>();
		Shippment shippment = new Shippment();

		shippments.add(shippment);

		for (OrderLine ol : shopOrder.getLines()) {
			Product product = ol.getProduct();
			for (int i = 0; i < ol.getAmount(); i++) {
				if (spec.isSatisfiedBy(product)) {
					if (shippment.getLine() == null || !shippment.getLine().getLine().equals(ol)) {
						shippment.addLine(ol);
					}
					shippment.getLine().setAmount(
							shippment.getLine().getAmount() + 1);
				} else {
					
					System.out.println("finished shippment: \n"+shippment);
					
					shippment = new Shippment();
					shippments.add(shippment);
					shippment.addLine(ol);
					shippment.getLine().setAmount(
							shippment.getLine().getAmount() + 1);
				}
			}
		}

		for (Shippment s : shippments) {
			System.out.println(s);
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
