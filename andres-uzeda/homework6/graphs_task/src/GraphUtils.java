

import java.util.*;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null || src == null || dest == null ||!graph.containsElement(src) || !graph.containsElement(dest)) {
			return -1;
		}else{
			BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
			return breadthFirstSearch.bfsDistance(graph.getNode(src), dest);
		}
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null || !graph.containsElement(src) || distance < 1) {
			return null;
		}
		if (graph.getNumNodes() == 1) {
			return new HashSet<String>();
		}
		return searchTraverseBFS(graph,src,distance);
	}

	private static Set<String> searchTraverseBFS(Graph graph, String src, int distance){
		Map<Node, Integer> distances = new HashMap<>();
		Queue<Node> toExplore = new LinkedList<>();
		Set<Node> marked = new HashSet<>();
		Set<String> result = new HashSet<String>();
		marked.add(graph.getNode(src));
		toExplore.add(graph.getNode(src));
		distances.put(graph.getNode(src), 0);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					distances.put(neighbor, distances.get(current) + 1);
					if (distances.get(neighbor) <= distance) {
						result.add(neighbor.getElement());
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return result;
	}

	public static boolean isHamiltonianPath(Graph g, List<String> values) {
        if(g == null || values == null || values.isEmpty() || !values.get(0).equals(values.get(values.size() - 1)) || values.size() < g.getNumNodes()){
            return false;
        }
        Map<Node, Boolean> visited = new HashMap<>();
        for(int i = 0; i < values.size() - 1; i++) {
            if(!(g.containsElement(values.get(i)) && g.containsElement(values.get(i + 1)))){
                return false;
            }
            Node currentNode = g.getNode(values.get(i));
            Node nextNode = g.getNode(values.get(i + 1));
            if(visited.containsKey(currentNode)){
                return false;
            }
            if(minDistance(g, currentNode.getElement(), nextNode.getElement()) == 1){
                visited.put(currentNode, true);
            }else{
                return false;
            }
        }
        return true;
    }
}
