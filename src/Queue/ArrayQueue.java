package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back; // the back field will always be pointing to the next available position in the queue

    public ArrayQueue(int initialCapacity) {
        queue = new Employee[initialCapacity];
    }

    public void add(Employee employee) {
        if (back == queue.length) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back++] = employee;
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        // reset the queue
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public int capacity() {
        return queue.length;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
