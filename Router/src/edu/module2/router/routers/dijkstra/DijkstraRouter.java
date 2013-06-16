package edu.module2.router.routers.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.module2.router.Node;
import edu.module2.router.Path;
import edu.module2.router.Router;

public class DijkstraRouter implements Router {

	long time = 0;

	Vertex startVertex = null;
	Vertex endVertex = null;

	@Override
	public Path getBestPath(Node[][] field, Node start, Node end) {

		long startTime = System.currentTimeMillis();

		Graph graph = buildGraphForDijkstra(field, start, end);

		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

		dijkstra.execute(startVertex);
		
		Path path = new Path();

		for (Vertex vertex : dijkstra.getPath(endVertex)) {
			path.addNode(vertex.getNode());

		}

		long endTime = System.currentTimeMillis();

		time = endTime - startTime;

		return path;
	}

	@Override
	public long getTime() {
		return time;
	}

	private Graph buildGraphForDijkstra(Node[][] field, Node start, Node end) {

		ArrayList<Vertex> nodes = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();

		// helper map for getting the previous vertex from X or Y coordinate
		Map<String, Vertex> v = new HashMap<String, Vertex>();

		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[0].length; y++) {
				String xyKey = x + "/" + y;
				Vertex node = new Vertex(xyKey, field[x][y]);
				nodes.add(node);
				v.put(xyKey, node);
				
				// connect to previous node in X direction
				if (x > 0 && x < field.length) {
					Edge edge = new Edge("Edge-" + (edges.size() + 1), v.get((x-1)+"/"+(y)), node,
							field[x][y].getValue());
					edges.add(edge);
				}
				
				// connect to previous node in Y direction
				if (y > 0 && y < field[0].length) {
					Edge edge = new Edge("Edge-" + (edges.size() + 1), v.get((x)+"/"+(y-1)), node,
							field[x][y].getValue());
					edges.add(edge);
				}

				if (field[x][y].equals(start)) {
					startVertex = node;
				}

				if (field[x][y].equals(end)) {
					endVertex = node;
				}

			}
		}

		Graph graph = new Graph(nodes, edges);

		return graph;
	}

}
