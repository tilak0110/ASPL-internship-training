package datastructure.graph;

public class AdjacencyMatrixExample {
    public static void main(String[] args) {
        int V = 4;
        int[][] graph = new int[V][V];

        // Adding edges (undirected)
        graph[0][1] = 1;
        graph[1][0] = 1;
        graph[0][2] = 1;
        graph[2][0] = 1;
        graph[1][3] = 1;
        graph[3][1] = 1;

        // Printing the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
