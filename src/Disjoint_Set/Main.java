package Disjoint_Set;

public class Main {
    public static void main(String[] args) {
        int size = 8;
        DisjointSet disjointSet = new DisjointSet(size);

        System.out.println(disjointSet.find(0)); // 0
        System.out.println(disjointSet.find(1)); // 1
        System.out.println(disjointSet.find(2)); // 2
        System.out.println(disjointSet.find(3)); // 3
        System.out.println(disjointSet.find(4)); // 4
        System.out.println(disjointSet.find(5)); // 5
        System.out.println(disjointSet.find(6)); // 6
        System.out.println(disjointSet.find(7)); // 7

        System.out.println();

        disjointSet.union(1, 2);
        System.out.println(disjointSet.find(1)); // 1
        System.out.println(disjointSet.find(2)); // 1

        System.out.println();

        disjointSet.union(2, 3);
        disjointSet.union(3, 5);
        System.out.println(disjointSet.connected(1, 5)); // true
        System.out.println(disjointSet.find(1)); // 1
        System.out.println(disjointSet.find(2)); // 1
        System.out.println(disjointSet.find(3)); // 1
        System.out.println(disjointSet.find(5)); // 1

        System.out.println();

        disjointSet.union(6, 7);
        disjointSet.union(0, 4);
        System.out.println(disjointSet.find(0)); // 0
        System.out.println(disjointSet.find(1)); // 1
        System.out.println(disjointSet.find(2)); // 1
        System.out.println(disjointSet.find(3)); // 1
        System.out.println(disjointSet.find(4)); // 0
        System.out.println(disjointSet.find(5)); // 1
        System.out.println(disjointSet.find(6)); // 6
        System.out.println(disjointSet.find(7)); // 6

        System.out.println();

        disjointSet.union(2, 7);
        System.out.println(disjointSet.find(0)); // 0
        System.out.println(disjointSet.find(1)); // 1
        System.out.println(disjointSet.find(2)); // 1
        System.out.println(disjointSet.find(3)); // 1
        System.out.println(disjointSet.find(4)); // 0
        System.out.println(disjointSet.find(5)); // 1
        System.out.println(disjointSet.find(6)); // 1
        System.out.println(disjointSet.find(7)); // 1
    }
}
