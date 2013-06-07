package at.edu.hti.shop;

import java.util.ArrayList;
import java.util.List;


import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.ShipmentLine;
import at.edu.hti.shop.domain.pricing.PriceStrategyFactory;
import at.edu.hti.shop.domain.spec.Category;
import at.edu.hti.shop.domain.spec.ISpecification;
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

		ISpecification spec = new Category().and(new MaxWeight(10));

		System.out.println(shopOrder);

		spec.sort(shopOrder);

		System.out.println(shopOrder);

		List<List<ShipmentLine>> allShipments = new ArrayList<List<ShipmentLine>>();
		List<ShipmentLine> shipmentLines = new ArrayList<ShipmentLine>();
		List<ShipmentLine> shipmentLinesTemp = new ArrayList<ShipmentLine>();

		ShipmentLine shipmentLine = null;

		for (OrderLine ol : shopOrder.getLines()) {

			int amount = ol.getAmount();

			Product product = ol.getProduct();

			while (amount > 0) {

				for (List<ShipmentLine> shipment : allShipments) {

					shipmentLines = shipment;

					while (amount > 0) {

						if (spec.isSatisfiedBy(shipmentLines, product)) {

							if (shipmentLine == null
									|| !shipmentLine.getLine().equals(ol)) {
								shipmentLine = new ShipmentLine(ol, 0);
								shipmentLinesTemp.add(shipmentLine);
							}

							shipmentLine
									.setAmount(shipmentLine.getAmount() + 1);
							amount--;
						} else {
							break;
						}
					}
				}
				if (amount > 0) {
					shipmentLine = new ShipmentLine(ol, 0);
					shipmentLinesTemp = new ArrayList<ShipmentLine>();
					shipmentLinesTemp.add(shipmentLine);
					allShipments.add(shipmentLinesTemp);
				}
			}
		}

		for (List<ShipmentLine> shipment : allShipments) {
			System.out.println("Shipment:");
			for (ShipmentLine l : shipment) {
				System.out.println("Shipment line: " + l);
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
