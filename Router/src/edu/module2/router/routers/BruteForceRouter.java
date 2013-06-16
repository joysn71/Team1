package edu.module2.router.routers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.module2.router.Node;
import edu.module2.router.Path;
import edu.module2.router.Router;

public class BruteForceRouter implements Router {

	Node[][] field = null;
	Node end = null;

	long time = 0;

	List<Path> paths = new ArrayList<Path>();

	private List<Node> getNeighbors(Node node) {

		List<Node> neighbors = new ArrayList<Node>();

		// get possible neighbors from all 4 sides.

		if (inField(node.getX() - 1, node.getY())) {
			neighbors.add(field[node.getX() - 1][node.getY()]);
		}

		if (inField(node.getX() + 1, node.getY())) {
			neighbors.add(field[node.getX() + 1][node.getY()]);
		}

		if (inField(node.getX(), node.getY() - 1)) {
			neighbors.add(field[node.getX()][node.getY() - 1]);
		}

		if (inField(node.getX(), node.getY() + 1)) {
			neighbors.add(field[node.getX()][node.getY() + 1]);
		}

		return neighbors;
	}

	private boolean inField(int x, int y) {
		boolean inField = false;

		if (x >= 0 && x < field.length && y >= 0 && y < field[0].length) {
			inField = true;
		}

		return inField;
	}

	@Override
	public Path getBestPath(Node[][] field, Node start, Node end) {

		long startTime = System.currentTimeMillis();

		this.field = field;
		this.end = end;

		Path path = new Path();
		path.addNode(start);

		route(path);

		if (!paths.isEmpty()) {
			Collections.sort(paths);
			path = paths.get(0);
		}

		long endTime = System.currentTimeMillis();

		time = endTime - startTime;

		System.out.println(BruteForceRouter.class.getSimpleName() + " tried "
				+ paths.size() + " routes in " + time + "ms");

		return path;
	}

	private void route(Path path) {

		List<Node> pathNodes = path.getPath();

		List<Node> neighbors = getNeighbors(pathNodes.get(pathNodes.size() - 1));

		Collections.sort(neighbors);

		for (Node node : neighbors) {

			if (!pathNodes.contains(node)) {
				
				Path newPath = clonePath(path);
				newPath.addNode(node);

				if (!node.equals(end)) {
					route(newPath);
				} else {
//					System.out.println("New path found: " + path);
					paths.add(newPath);
				}
			}

		}

	}

	private Path clonePath(Path path) {
		Path clone = new Path();
		for (Node node : path.getPath()) {
			clone.addNode(node);
		}
		return clone;
	}

	public long getTime() {
		return this.time;
	}

}
