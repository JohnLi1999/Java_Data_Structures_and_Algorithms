package List.linklists.doublylinkedlists;

import List.linklists.singlylinkedlists.IntegerSinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToEnd(marySmith);
        list.addBefore(mikeWilson, johnDoe); // at the beginning of the list

        System.out.println(list.getSize());
        list.printList();

        list.addBefore(new Employee("Someone", "Else", 1111), janeJones);
        System.out.println(list.getSize());
        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

        list.removeFromEnd();
        System.out.println(list.getSize());
        list.printList();


        System.out.println("\n");


        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerSinglyLinkedList intList = new IntegerSinglyLinkedList();
        intList.insertSort(four);
        intList.printList();
        intList.insertSort(two);
        intList.printList();
        intList.insertSort(one);
        intList.printList();
        intList.insertSort(three);
        intList.printList();
        intList.insertSort(four);
        intList.printList();
    }
}
