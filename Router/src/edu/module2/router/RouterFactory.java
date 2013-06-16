package edu.module2.router;

import edu.module2.router.routers.BruteForceRouter;
import edu.module2.router.routers.SolutionRouter;
import edu.module2.router.routers.dijkstra.DijkstraRouter;

public class RouterFactory {

	public static Router getInstance(final String type) {
		Router router = null;
		
		switch (type) {
		case "solution":
			router = new SolutionRouter();
			break;

		case "withBruteForce":
			router = new BruteForceRouter();
			break;
			
		case "withDijkstra":
			router = new DijkstraRouter();
			break;

		default:
			break;
		}

		return router;

	}

}
