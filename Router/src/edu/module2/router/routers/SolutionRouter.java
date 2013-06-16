package edu.module2.router.routers;

import edu.module2.router.Node;
import edu.module2.router.Path;
import edu.module2.router.Router;

public class SolutionRouter implements Router {

	@Override
	public Path getBestPath(Node[][] field, Node start, Node end) {
		
		// just provide solutions path
		Path path = new Path();
		path.addNode(new Node(0, 0, 0));
		path.addNode(new Node(1, 0, 0));
		path.addNode(new Node(2, 0, 0));
		path.addNode(new Node(3, 0, 0));
		path.addNode(new Node(4, 0, 0));
		path.addNode(new Node(4, 1, 0));
		path.addNode(new Node(5, 1, 0));
		path.addNode(new Node(6, 1, 0));
		path.addNode(new Node(6, 2, 0));
		path.addNode(new Node(6, 3, 0));
		
		System.out.println("\nRouter just create path for known solution!");
		
		return path;
	}

	@Override
	public long getTime() {
		// as the solution is known, we don't use time for the calculation :)
		return 0;
	}

}
