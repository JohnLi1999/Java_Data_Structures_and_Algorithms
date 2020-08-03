package Disjoint_Set;

public class DisjointSet {

    private int[] roots;

    public DisjointSet(int size) {
        roots = new int[size];

        // initialize the root as the element itself
        for (int i = 0; i < size; i++) {
            roots[i] = i;
        }
    }

    /** Find the root of the specified element
     *
     * @param i     the specified element
     * @return      the root of the element
     */
    public int findRoot(int i) {
        int root = i;

        /*  Find the root of the specified element
            The root of an root element points to itself  */
        while (root != roots[root]) {
            root = roots[root];
        }

        /*  Optimization:
            1. To reduce the depth of a disjoint set, we want all the elements in the same set
            share the same root element. So the depth of the set is always one
            2. So we have another while loop staring from the specified element (i) to its root (root),
            for every element in between (include the starting element), we update their root element to
            the root we found before  */
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }

        return root;
    }

    /** Check if the two elements are in the same set
     *
     * @param p     the first element
     * @param q     the second element
     * @return      true if the two elements are not in the same set,
     *              false otherwise
     */
    public boolean connected(int p, int q) {
        // If the two elements are in the same set, their roots should be the same
        return findRoot(p) == findRoot(q);
    }

    /** Union the two elements into the same set
     *
     * @param p     the first element
     * @param q     the second element
     */
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        // To union two elements, we only need to point the root of one element to the root of the other element
        roots[pRoot] = qRoot;
    }
}
