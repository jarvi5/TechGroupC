

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<>();
		graph = graphToSearch;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public int bfs(Node start, String elementToFind) {
		int result = -1;
		int count = 0;
		int countEdges = 0;
		Queue<Node> toExplore = new LinkedList<>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (countEdges == count) {
						countEdges++;
						count++;
					}
					if (neighbor.getElement().equals(elementToFind)) {
						result = countEdges;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
					count++;
				}
			}
			count = countEdges;
		}
		return result;
	}
}
