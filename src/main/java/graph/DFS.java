package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFS {

    public static void main(String... args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(0);
    }

    private static class Graph {
        private int vertices;
        private ArrayList<Integer>[] adjList;
        boolean visited[];

        public Graph(int vertices) {
            this.vertices = vertices;
            visited = new boolean[this.vertices];
            adjList = new ArrayList[vertices];
            for(int i = 0; i < vertices; i++) {
                adjList[i] = new ArrayList();
            }
        }

        public void addEdge(int v, int w) {
            adjList[v].add(w);
        }

        public void dfs(int s) {
            System.out.print(s + " ");
            visited[s] = true;
            for (int i : adjList[s]) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
        }
    }
}
