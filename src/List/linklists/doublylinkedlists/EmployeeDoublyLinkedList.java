package List.linklists.doublylinkedlists;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (head == null) { // check whether the list is empty
            tail = node;    // if the list is empty, we also need to set the tail to the new node
        } else {
            node.setNext(head); // if the list is not empty, then we need to add the new node to the front of the head
            head.setPrev(node);
        }

        head = node; // switch head to the new element
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (tail == null) { // check whether the list is empty
            head = node;    // if the list is empty, we also need to set the head to the new node
        } else {
            node.setPrev(tail); // if the list is not empty, then we need to add the new node to the back of the tail
            tail.setNext(node);
        }

        tail = node; // switch tail to the new element
        size++;
    }

    /*  Challenge 1:
            Return true if you were able to successfully add the employee into the list before the existing employee.
            Return false if the existing employee does not exist in the list
     */
    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
        if (isEmpty()) {
            return false;
        }

        // find the existing employee
        EmployeeNode current = head;

        while (current != null && !current.getEmployee().equals(existingEmployee)) {
            current = current.getNext();
        }

        if (current == null) {
            return false; // return false since the existingEmployee does not exist
        }

        EmployeeNode newNode = new EmployeeNode(newEmployee);
        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.setPrev(newNode);

        if (head == current) { // handle the case if we are add the new employee at the beginning of the list
            head = newNode;
        } else {
            newNode.getPrev().setNext(newNode);
        }

        size++;
        return true;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        if (head.getNext() == null) { // test if we are removing the last element in the list
            tail = null;
        } else {
            head.getNext().setPrev(null);
        }

        head = head.getNext();
        size--;

        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNode removeFromEnd () {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if (tail.getPrev() == null) { // test if we are removing the last element in the list
            head = null;
        } else {
            tail.getPrev().setNext(null);
        }

        tail = tail.getPrev();
        size--;

        removedNode.setPrev(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        EmployeeNode current = head;

        System.out.print("HEAD -> ");

        while (current != null) {
            System.out.print(current + " <=> ");
            current = current.getNext();
        }

        System.out.println("TAIL");
    }
}
