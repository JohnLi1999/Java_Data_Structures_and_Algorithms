package Heap;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        // Min Heap (minimum element is at the top)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
        pq.forEach(e -> System.out.print(e + " "));

        System.out.println();

        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.poll());
        System.out.println(pq.remove(54));

        Object[] ints = pq.toArray();
        for (Object num : ints) {
            System.out.print(num + " ");
        }
        System.out.println();

        pq.add(-1);

        pq.forEach(e -> System.out.print(e + " "));
    }
}
