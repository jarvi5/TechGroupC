

import java.util.*;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null || src==null || dest == null) return -1;
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		if (bfs.bfs(graph.getNode(src),dest)){
			return bfs.getPathDistance(graph.getNode(dest));
		}
		return -1 ;
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null || !graph.containsElement(src) || distance < 1) return null;
		Set<String> nodesWithinDistance = new HashSet<>();
		for (Node node : graph.getAllNodes()) {
			int calculatedDistance = minDistance(graph, src, node.getElement());
			if (calculatedDistance <= distance && calculatedDistance > 0 && !node.getElement().equals(src)) {
					nodesWithinDistance.add(node.getElement());
			}
		}
		return nodesWithinDistance;
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if (g == null || values == null || values.isEmpty() || !values.get(0).equals(values.get(values.size() - 1)) || values.size() < g.getNumNodes()) return false;
		Map<Node, Boolean> visited = new HashMap<>();
		for (int i = 0; i < values.size() - 1; i++) {
			Node currentNode = g.getNode(values.get(i));
			Node nextNode = g.getNode(values.get(i + 1));
			if (minDistance(g, currentNode.getElement(), nextNode.getElement()) == 1) {
				visited.put(currentNode, true);
			} else {
				return false;
			}
		}
		return true;
	}
}
