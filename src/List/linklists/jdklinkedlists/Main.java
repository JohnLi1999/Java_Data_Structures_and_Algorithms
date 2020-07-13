package List.linklists.jdklinkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        printList(list);

        list.add(mikeWilson); // add the new element to the end of the list
        list.addLast(billEnd);
        printList(list);

        list.removeFirst();
        printList(list);

        list.removeLast();
        printList(list);

        list.remove(); // remove the first element in the list
        printList(list);
    }

    public static void printList(List<Employee>list) {
        System.out.print("HEAD -> ");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " <=> ");
        }

//        for (Employee employee : list) {
//            System.out.print(employee + " <=> ");
//        }

        System.out.println("TAIL");
    }
}
