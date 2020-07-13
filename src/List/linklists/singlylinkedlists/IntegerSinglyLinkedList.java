package List.linklists.singlylinkedlists;

public class IntegerSinglyLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer integer) {
        IntegerNode node = new IntegerNode(integer);
        node.setNext(head);
        head = node;

        size++;
    }

    public void insertSort(Integer value) {

        // assumption: the list is sorted
        if (head == null || head.getValue() >= value) {
            addToFront(value);
            return;
        }

        // find the insertion point
        IntegerNode current = head.getNext();
        IntegerNode previous = head;
        while (current != null && current.getValue() < value) {
            previous = current;
            current = current.getNext();
        }

        IntegerNode newNode = new IntegerNode(value);
        newNode.setNext(current);
        previous.setNext(newNode);

        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        IntegerNode current = head;

        System.out.print("HEAD -> ");

        while (current != null) {
            System.out.print(current + " -> ");
            current = current.getNext();
        }

        System.out.println("null");
    }
}
