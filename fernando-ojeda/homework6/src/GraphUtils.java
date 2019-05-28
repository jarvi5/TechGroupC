

import java.util.*;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

    public static int minDistance(Graph graph, String src, String dest) {
        int result = -1;
        Node src2 = new Node(src);
        Node dest2 = new Node(dest);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        if (graph != null && src != null && dest != null) {
            if (!graph.containsNode(src2) && !graph.containsNode(dest2)) {
                if (!src.equals(dest)) {
                    Map<Node, Set<Edge>> adjacency = graph.adjacencySets;
                    for (Map.Entry<Node, Set<Edge>> map : adjacency.entrySet()) {
                        Node node = map.getKey();
                        if (node.getElement().equals(src)) {
                            result = breadthFirstSearch.bfs(node, dest);
                        }
                    }
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }


    public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
        Set<String> result = new HashSet<>();
        Set<Node> marked = new HashSet<>();
        int countEdges = 0;
        int count = 0;
        Queue<Node> toExplorer = new LinkedList<>();
        Node srcNode = new Node(src);
        if (graph != null && src != null && distance > 0 && contains(srcNode, graph)) {
            if (graph.adjacencySets.size() == 1) {
                result = new HashSet<>();
            } else {
                getNodeDistance(graph, src, distance, result, marked, countEdges, count, toExplorer);
            }
        } else {
            result = null;
        }
        return result;
    }

    private static void getNodeDistance(Graph graph, String src, int distance, Set<String> result, Set<Node> marked,
                                        int countEdges, int count, Queue<Node> toExplorer) {
        Map<Node, Set<Edge>> graphs = graph.adjacencySets;
        for (Map.Entry<Node, Set<Edge>> map : graphs.entrySet()) {
            Node node = map.getKey();
            if (node.getElement().equals(src)) {
                marked.add(node);
                toExplorer.add(node);
                while (!toExplorer.isEmpty()) {
                    Node current = toExplorer.remove();
                    if (distance != countEdges) {
                        countEdges = getCountEdges(graph, result, marked, countEdges, count, toExplorer, current);
                        count = countEdges;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static int getCountEdges(Graph graph, Set<String> result, Set<Node> marked, int countEdges, int count,
                                     Queue<Node> toExplorer, Node current) {
        for (Node neighbor : graph.getNodeNeighbors(current)) {
            if (!marked.contains(neighbor)) {
                if (countEdges == count) {
                    countEdges++;
                    count++;
                }
                result.add(neighbor.getElement());
                marked.add(neighbor);
                toExplorer.add(neighbor);
                count++;
            }
        }
        return countEdges;
    }

    private static boolean contains(Node srcNode, Graph graph) {
        boolean result = false;
        Set<Node> nodes = graph.getAllNodes();
        for (Node node : nodes) {
            if (node.getElement().equals(srcNode.getElement())) {
                result = true;
            }
        }
        return result;
    }


    public static boolean isHamiltonianPath(Graph g, List<String> values) {
        boolean result = false;
        int countValues = 0;
        int count = 0;
        Queue<Node> toExplorer = new LinkedList<>();
        if (g != null && values != null && values.size() != 0) {
            Node node = getRootNode(g, values);
            toExplorer.add(node);
            while (countValues < values.size() - 1) {
                Node current = toExplorer.remove();
                if (countValues == 0 ||
                        Integer.parseInt(values.get(countValues)) == Integer.parseInt(values.get(countValues - 1)) + 1) {
                    if (current.getElement().equals(values.get(countValues))) {
                        count = getCount(g, values, countValues, count, toExplorer, current);
                        countValues++;
                    }
                } else {
                    result = false;
                    break;
                }
            }
            if (count == values.size() - 1) {
                result = true;
            }
        }
        return result;
    }

    private static Node getRootNode(Graph g, List<String> values) {
        Node result = null;
        Map<Node, Set<Edge>> nodeSetMap = g.adjacencySets;
        for (Map.Entry<Node, Set<Edge>> map : nodeSetMap.entrySet()) {
            Node node = map.getKey();
            if (node.getElement().equals(values.get(0))) {
                result = node;
            }
        }
        return result;
    }

    private static int getCount(Graph g, List<String> values, int count2, int count, Queue<Node> toExplorer,
                                Node current) {
        for (Node neighbor : g.getNodeNeighbors(current)) {
            if (neighbor.getElement().equals(values.get(count2 + 1))) {
                count++;
            }
            toExplorer.add(neighbor);
        }
        return count;
    }
}
