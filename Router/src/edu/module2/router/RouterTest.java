package edu.module2.router;


public class RouterTest {

	public static void main(String[] args) {

		int[][] fieldValues = { 
				{ 0, 2, 3, 6 }, 
				{ 0, 8, 5, 7 }, 
				{ 1, 2, 0, 8 },
				{ 8, 8, 8, 8 }, 
				{ 1, 2, 3, 4 }, 
				{ 9, 0, 9, 9 }, 
				{ 1, 2, 1, 1 } 
			};

		Node[][] field = convertField2NodeList(fieldValues);

		System.out.println("Field:");
		printField(field, null);
		System.out.println("\n\nSolutions:");
		
		runAlgorithm(field, "BruteForce");
		runAlgorithm(field, "Dijkstra");
		runAlgorithm(field, "Solution");

	}
	
	private static void runAlgorithm(Node[][] field, String algorithmName) {
		Router router = RouterFactory.getInstance(algorithmName);

		Path path = router.getBestPath(field, field[0][0],
				field[field.length - 1][field[0].length - 1]);

		System.out.println("\nCheapest path found with '"+algorithmName+"' after "+router.getTime()+"ms: cost="+path.getCost());
		printField(field, path);
	}

	private static void printField(Node[][] field, Path path) {
		for (int x = 0; x < field.length; x++) {
			StringBuilder fieldLine = new StringBuilder();
			fieldLine.append("|");
			for (int y = 0; y < field[x].length; y++) {

				if (path != null && path.getPath().contains(field[x][y])) {
					fieldLine.append("*" + field[x][y].getValue() + "*");
				} else {
					fieldLine.append(" " + field[x][y].getValue() + " ");
				}

				fieldLine.append("|");
			}
			System.out.println(fieldLine);
		}
	}

	private static Node[][] convertField2NodeList(int[][] fieldValues) {
		Node[][] field = new Node[fieldValues.length][fieldValues[0].length];

		for (int x = 0; x < fieldValues.length; x++) {
			for (int y = 0; y < fieldValues[x].length; y++) {
				field[x][y] = new Node(x, y, fieldValues[x][y]);
			}
		}
		return field;
	}

}
