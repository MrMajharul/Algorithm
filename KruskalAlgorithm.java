import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Sorting edges by weight
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class DisjointSet {
    int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class KruskalAlgorithm {
    public static void kruskalMST(int vertices, List<Edge> edges) {
        Collections.sort(edges); // Sort edges by weight
        DisjointSet ds = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                ds.union(edge.src, edge.dest);
                mst.add(edge);
            }
            if (mst.size() == vertices - 1) break;
        }

        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<Edge> edges = new ArrayList<>(Arrays.asList(
            new Edge(0, 1, 4), new Edge(0, 2, 4), new Edge(1, 2, 2), 
            new Edge(1, 3, 6), new Edge(2, 3, 8), new Edge(2, 4, 5),
            new Edge(3, 4, 9), new Edge(3, 5, 10), new Edge(4, 5, 1)
        ));
        

        kruskalMST(vertices, edges);
    }
}
