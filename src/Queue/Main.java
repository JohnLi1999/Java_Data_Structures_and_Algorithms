package Queue;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

//        ArrayQueue queue = new ArrayQueue(10);
        CircularQueue queue = new CircularQueue(10);

        queue.add(janeJones);
        queue.add(johnDoe);
        for (int i = 0; i < 9; i++) {
            queue.remove();
            queue.add(marySmith);
            System.out.println(queue.capacity());
        }
        queue.add(johnDoe);
        queue.printQueue();

//        queue.add(janeJones);
//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        queue.add(new Employee("Bill", "End", 78));
//        queue.printQueue();
//
//        queue.remove();
//        queue.remove();
//        queue.printQueue();
//
//        System.out.println(queue.peek());
//        queue.printQueue();
//
//        queue.remove();
//        queue.remove();
//        queue.remove();
////        queue.remove();
//
//        queue.add(janeJones);
//        queue.printQueue();

    }
}
