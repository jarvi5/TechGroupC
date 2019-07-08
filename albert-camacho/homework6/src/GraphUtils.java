

import java.util.*;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

    public static int minDistance(Graph graph, String src, String dest) {
        int distance = -1;

        if (graph != null && src != null && dest != null && graph.containsElement(src) && graph.containsElement(dest)) {
            BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
            distance = breadthFirstSearch.distance(graph.getNode(src), dest);
        }

        return distance;
    }


    public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
        Set<String> nodes;

        if (graph != null && src != null && distance > 0 && graph.containsElement(src)) {
            nodes = new HashSet<>(nodesWithin(graph, src, distance));
            // removes the src in case is was added when working with an undirected graph or a cyclic path
            nodes.remove(src);
        } else {
            return null;
        }

        return nodes;
    }

    private static Set<String> nodesWithin(Graph graph, String src, int distance) {
        Set<String> nodes = new HashSet<>();
        Node node = graph.getNode(src);
        Set<Node> neighbors = graph.getNodeNeighbors(node);

        if (!neighbors.isEmpty()) {
            if (distance == 1) {
                for (Node neighbor : neighbors) {
                    nodes.add(neighbor.getElement());
                }
                return nodes;
            }

            for (Node neighbor : neighbors) {
                Set<String> subNodes = nodesWithinDistance(graph, neighbor.getElement(), distance - 1);
                if (!subNodes.isEmpty()) {
                    nodes.add(neighbor.getElement());
                    nodes.addAll(subNodes);
                }
            }
        }
        return nodes;
    }

    public static boolean isHamiltonianPath(Graph graph, List<String> values) {

        if (graph != null && values != null && !values.isEmpty()) {
            String last = values.get(values.size() - 1);
            if (values.get(0).equals(last)) {
                Set<Node> nodes = graph.adjacencySets.keySet();
                travelPath(graph, values, nodes);
                return nodes.isEmpty();
            }
        }
        return false;
    }

    private static void travelPath(Graph graph, List<String> values, Set<Node> nodes) {
        if (!values.isEmpty()) {
            Node node = graph.getNode(values.remove(0));
            Set<Node> neighbors = graph.getNodeNeighbors(node);

            nodes.remove(node);

            if (!values.isEmpty() && neighbors.contains(graph.getNode(values.get(0)))) {
                travelPath(graph, values, nodes);
            }
        }
    }

}
