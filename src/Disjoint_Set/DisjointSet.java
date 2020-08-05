package Disjoint_Set;

public class DisjointSet {

    private final int[] parent;
    private final int[] rank;

    /** Initialize the disjoint set
     *
     *  Time Complexity: O(N)
     *      When N is the size of the disjoint set
     *
     * @param size  the size of the disjoint set
     */
    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];

        // initialize the root as the element itself
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /** Find the root of the specified element
     *  We also apply Path Compression:
     *      Path compression flattens the structure of the tree by
     *      making every node point to the root whenever Find is used on it
     *
     *  Time Complexity: O(M * α(N)) on average
     *      Where M is the number of operations applied, and α(N) is the amortized time and α(N) < 5
     *      So, "Find" take place in essentially constant time
     *
     * @param i     the specified element
     * @return      the root of the element
     */
    public int find(int i) {
        // Recursive Approach
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];

        // Iteration Approach
//        int root = i;
//        while (parent[root] != root) {
//            root = parent[root];
//        }
//        while (parent[i] != i) {
//            int temp = parent[i];
//            parent[i] = root;
//            i = temp;
//        }
//        return root;
    }

    /** Union the two elements into the same set
     *  We also apply union-by-rank
     *
     *  Time Complexity: O(M * α(N)) on average
     *      Where M is the number of operations applied, and α(N) is the amortized time and α(N) < 5
     *      So, "Union" take place in essentially constant time
     *
     * @param x     the first element
     * @param y     the second element
     */
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    /** Check if the two elements are in the same set
     *
     * @param x     the first element
     * @param y     the second element
     * @return      true if the two elements are not in the same set,
     *              false otherwise
     */
    public boolean connected(int x, int y) {
        // If the two elements are in the same set, their roots should be the same
        return find(x) == find(y);
    }
}
