package datastructure.graph;

import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                ", weight=" + weight +
                '}';
    }
}

public class DijkstraAlgorithm {

    public static void dijkstra(List<List<Node>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 10));
        graph.get(0).add(new Node(2, 4));
        graph.get(2).add(new Node(3, 3));
        graph.get(1).add(new Node(3, 2));

        dijkstra(graph, 0);
    }
}
