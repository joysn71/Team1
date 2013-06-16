package edu.module2.router;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path implements Comparable<Path> {
	
	List<Node> path = new ArrayList<Node>();
	int cost = 0;
	
	public boolean addNode(Node node) {
		
		if (node == null) {
			throw new IllegalArgumentException("Parameter node required!");
		}
		
		if (!path.contains(node)) {
			path.add(node);
			cost = cost + node.getValue();
			return true;
		} else {
			return false;
		}
	}
	
	public List<Node> getPath() {
		return Collections.unmodifiableList(path);
	}
	
	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Path o) {
		return this.cost < o.getCost() ? -1 : (this.cost == o.getCost() ? 0 : 1);
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("Path [cost=" + cost + ", nodes=(");
		for (Node node : path) {
			b.append(node);
		}
		b.append(")]");
		return b.toString();
	}
	
}
