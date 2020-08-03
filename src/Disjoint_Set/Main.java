package Disjoint_Set;

public class Main {
    public static void main(String[] args) {
        int size = 8;
        DisjointSet disjointSet = new DisjointSet(size);

        System.out.println(disjointSet.findRoot(0)); // 0
        System.out.println(disjointSet.findRoot(1)); // 1
        System.out.println(disjointSet.findRoot(2)); // 2
        System.out.println(disjointSet.findRoot(3)); // 3
        System.out.println(disjointSet.findRoot(4)); // 4
        System.out.println(disjointSet.findRoot(5)); // 5
        System.out.println(disjointSet.findRoot(6)); // 6
        System.out.println(disjointSet.findRoot(7)); // 7

        System.out.println();

        disjointSet.union(1, 2);
        System.out.println(disjointSet.findRoot(1)); // 2
        System.out.println(disjointSet.findRoot(2)); // 2

        System.out.println();

        disjointSet.union(2, 3);
        disjointSet.union(3, 5);
        System.out.println(disjointSet.connected(1, 5)); // true
        System.out.println(disjointSet.findRoot(1)); // 5
        System.out.println(disjointSet.findRoot(2)); // 5
        System.out.println(disjointSet.findRoot(3)); // 5
        System.out.println(disjointSet.findRoot(5)); // 5

        System.out.println();

        disjointSet.union(6, 7);
        disjointSet.union(0, 4);
        System.out.println(disjointSet.findRoot(0)); // 4
        System.out.println(disjointSet.findRoot(1)); // 5
        System.out.println(disjointSet.findRoot(2)); // 5
        System.out.println(disjointSet.findRoot(3)); // 5
        System.out.println(disjointSet.findRoot(4)); // 4
        System.out.println(disjointSet.findRoot(5)); // 5
        System.out.println(disjointSet.findRoot(6)); // 7
        System.out.println(disjointSet.findRoot(7)); // 7
    }
}
