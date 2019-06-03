

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import movieRating.UserMovieRating;


/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {

		/* IMPLEMENT THIS METHOD! */
		try { 
			if(graph != null) {
				if(src != null || !src.isEmpty()) {
					
					if(dest != null || !dest.isEmpty()) {
						return findingDistance(graph, src, dest);
					}
				}
			}
			
		}catch (Exception e){
			System.out.println("Graph or,source or destination is invalid"); 
	     }
		
		return -1; // this line is here only so this code will compile if you don't modify it
	}
	
	private static int findingDistance(Graph graph, String src, String dest) {
		try { 
			if(src.equals(dest)) {
				return 0;
			}else {			
				if(graph.containsElement(src) ) {
					if(graph.containsElement(dest)) {
						if(graph.getNodeNeighbors(graph.getNode(src)).contains(graph.getNode(dest))) {
							return 1;
						}else {
							return bfsearch( graph,graph.getNode(src), dest);			
						}
					}
				}
			}
			
		}catch (Exception e){
			System.out.println("source or destination are not in graph"); 
	     }
		return -1;
	}
		
	private static int bfsearch(Graph graph,Node start, String elementToFind) {
		Set<Node> marked = new HashSet<Node>();		
		int distance = 0;
		
		if (!graph.containsNode(start)) {
				return -1;
		}
		if (start.getElement().equals(elementToFind)) {
			return 0;
		}
		
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return distance;
					}
					
					marked.add(neighbor);
					toExplore.add(neighbor);
					distance++;
				}
			}
		}
		return distance;
	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		try {
			if(graph != null) {
				if(src != null || !src.isEmpty()) {
					
					if(distance > 0) {
						
						return findingNodes(graph, src, distance);
					}
				}
			}
			
		}catch (Exception e){
			System.out.println("Graph is invalid"); 
	     }
				
		return null; // this line is here only so this code will compile if you don't modify it
	}

	private static Set<String> findingNodes(Graph graph,String src,int distance) {
		Set<Node> marked = new HashSet<Node>();	
		
		if(!graph.containsElement(src)) {
			return null;
		}
		
		if(distance<graph.getNumEdges()) {
		
			if (graph.getStartingNode().getElement().equals(src)) {
				marked.add(graph.getStartingNode());
				return convertSetString(marked);
			}
			Queue<Node> toExplore = new LinkedList<Node>();
			marked.add(graph.getStartingNode());
			toExplore.add(graph.getStartingNode());
			
			while (!toExplore.isEmpty()) {
				Node current = toExplore.remove();
				for (Node neighbor : graph.getNodeNeighbors(current)) {
					if (!marked.contains(neighbor)) {
						if (neighbor.getElement().equals(graph.getNode(src))) {
							return convertSetString(marked);
						}
						
						marked.add(neighbor);
						toExplore.add(neighbor);
					}
				}
			}			
		}
		
		return convertSetString(marked);
	}
	
	private static Set<String> convertSetString(Set<Node> nodes){
		Set<String> marked = new HashSet<String>();	
		Iterator<Node> it = nodes.iterator();
		try {
			while(it.hasNext()){
				Node node = it.next();
				
				marked.add(node.getElement());
				}
			
		}catch  (Exception e){
			System.out.println("Null node"); 
	    }
		
		return marked;
	}
	
	
	
	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
				
		try {
			if(g != null) {
				if(!values.isEmpty()) {
					if(isHamiltonian( g, values)) {
						return true;
					}					
				}
			}
		}catch (Exception e){
			System.out.println("Graph is invalid"); 
	     }
		
		return false; // this line is here only so this code will compile if you don't modify it	
	}
	
	private static boolean isHamiltonian(Graph g, List<String> values) {
		BreadthFirstSearch graph = new BreadthFirstSearch(g);
		Iterator<String> it = values.listIterator();	
		boolean bool = false;
		while(it.hasNext()){
			String value = it.next();
			
			for(Node nodeStart: g.getNodeNeighbors(g.getStartingNode())) {			
				if(graph.bfs(nodeStart, value)) {
					bool = true;
				}else {
					return false;
				}
			}				
		}
		
		return bool;
	}
	
	
}

	
	