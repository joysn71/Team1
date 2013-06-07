package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shipment {
	
	List<ShipmentLine> lines = new ArrayList<ShipmentLine>();

	public void addLine(OrderLine ol) {
		lines.add(new ShipmentLine(ol, 0));
	}

	public ShipmentLine getLine() {
		
		if (lines.isEmpty()) {
			return null;
		}
		
		return lines.get(lines.size() - 1);
	}
	
	public List<ShipmentLine> getLines() {
		return Collections.unmodifiableList(lines);
	}
	
	@Override
	public String toString() {
		return "Shippment [lines=" + lines + "] \n";
	}

}
