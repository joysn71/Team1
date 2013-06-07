package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shippment {
	
	List<ShippmentLine> lines = new ArrayList<ShippmentLine>();

	public void addLine(OrderLine ol) {
		lines.add(new ShippmentLine(ol, 0));
	}

	public ShippmentLine getLine() {
		
		if (lines.isEmpty()) {
			return null;
		}
		
		return lines.get(lines.size() - 1);
	}
	
	public List<ShippmentLine> getLines() {
		return Collections.unmodifiableList(lines);
	}
	
	@Override
	public String toString() {
		return "Shippment [lines=" + lines + "] \n";
	}

	public class ShippmentLine {
		private OrderLine line;
		private int amount = 0;
		
		public ShippmentLine(OrderLine ol, int amount) {
			setLine(ol);
			setAmount(amount);
		}
		
		public OrderLine getLine() {
			return line;
		}
		public void setLine(OrderLine line) {
			this.line = line;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "ShippmentLine [line=" + line + ", amount=" + amount + "]";
		}
		
		
	}
}
