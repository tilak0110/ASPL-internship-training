package datastructure.graph;

import java.util.*;



public class WeightedAdjacencyList {
    public static void main(String[] args) {
        int V = 3;
        List<List<Node>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges with weights
        graph.get(0).add(new Node(1, 1));
        graph.get(0).add(new Node(2, 4));
        graph.get(1).add(new Node(0, 1));
        graph.get(1).add(new Node(2, 3));
        graph.get(2).add(new Node(0, 4));
        graph.get(2).add(new Node(1, 3));

        // Print adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> " + graph.get(i));
            System.out.println();
        }
    }
}
