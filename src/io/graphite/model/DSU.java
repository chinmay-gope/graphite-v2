package io.graphite.model;

public class DSU {
    private final int[] parent;
    private final int[] rank;

    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    static void main() {
        DSU dsu = new DSU(6);

        System.out.println(dsu.connected(0, 1));

        dsu.union(0, 1);

        System.out.println(dsu.connected(0, 1));

        dsu.union(1, 2);

        System.out.println(dsu.connected(0, 2));

        dsu.union(3, 4);

        System.out.println(dsu.connected(2, 4));

        dsu.union(2, 4);

        System.out.println(dsu.connected(2, 4));
    }

    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }

    public boolean connected(int vertex1, int vertex2) {
        return find(vertex1) == find(vertex2);
    }

    public void union(int u, int v) {
        int rootX = find(u);
        int rootY = find(v);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
