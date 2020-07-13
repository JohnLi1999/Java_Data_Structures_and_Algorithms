package Queue;

import java.util.NoSuchElementException;

public class CircularQueue {

    // same implementation as ArrayQueue, but we also use the empty space in the queue

    private Employee[] queue;
    private int front;
    private int back; // the back field will always be pointing to the next available position in the queue

    public CircularQueue(int initialCapacity) {
        queue = new Employee[initialCapacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];

            // copy the wrapped and unwrapped parts of the queue array to the new array
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            front = 0;
            back = numItems;

            queue = newArray;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            // if the next element is going to wrap the queue array, set back to index 0
            back = 0;
        }
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
        } else if (front == queue.length) {
            front = 0;
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
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length; // back (the wrapped part) + queue.length - front (the unwrapped part)
        }
    }

    public int capacity() {
        return queue.length;
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            // print unwrapped part
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            // print wrapped part
            for (int j = 0; j < back; j++) {
                System.out.println(queue[j]);
            }
        }
    }
}
