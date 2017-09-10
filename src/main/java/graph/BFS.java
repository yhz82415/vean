package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    public static void main(String... args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.bfs(2);
    }

    private static class Graph {
        private int vertices;
        private ArrayList<Integer>[] adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList[vertices];
            for(int i = 0; i < vertices; i++) {
                adjList[i] = new ArrayList();
            }
        }

        public void addEdge(int v, int w) {
            adjList[v].add(w);
        }

        public void bfs(int s) {
            boolean visited[] = new boolean[vertices];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s] = true;
            queue.add(s);

            while(!queue.isEmpty()) {
                Integer polled = queue.poll();
                System.out.print(polled + " ");
                ArrayList<Integer> adjVertices = adjList[polled];
                for (Integer i : adjVertices) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }
}
