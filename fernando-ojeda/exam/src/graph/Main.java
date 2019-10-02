package graph;

public class Main {
    public static void main(String arg[]){
        int N = 30;
        int knightPos[] = {1, 1};
        int targetPos[] = {30, 30};
        GFG gfg = new GFG();
        gfg.getMatrixNodes(knightPos, targetPos, N);

        Node node12 = new Node("12");
        Node node1 = new Node("1");
        Node node3 = new Node("3");
        Node node9 = new Node("9");
        Node node5 = new Node("5");
        Node node15 = new Node("15");
        Node node19 = new Node("19");
        Node node21 = new Node("21");
        Node node23 = new Node("23");

        Graph graph = new Graph();
        graph.addNode(node12);
        graph.addNode(node1);
        graph.addNode(node3);
        graph.addNode(node9);
        graph.addNode(node5);
        graph.addNode(node15);
        graph.addNode(node19);
        graph.addNode(node21);
        graph.addNode(node23);

        graph.addEdge(node12, node1, 1);
        graph.addEdge(node12, node3, 1);
        graph.addEdge(node12, node9, 1);
        graph.addEdge(node12, node5, 1);
        graph.addEdge(node12, node15, 1);
        graph.addEdge(node12, node19, 1);
        graph.addEdge(node12, node21, 1);
        graph.addEdge(node12, node23, 1);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);
        boolean result = depthFirstSearch.dfs("15", node12);
        System.out.println(result);
    }
}
