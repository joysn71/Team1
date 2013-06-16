package edu.module2.router;

public class Node implements Comparable<Node> {
	
	private int x, y, value;

	public Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int compareTo(Node o) {
		return this.value < o.getValue() ? -1 : (this.value == o.getValue() ? 0 : 1);
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	
	
}
