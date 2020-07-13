package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Challenge_2 {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        List<Employee> list = new LinkedList<>();
        list.add(janeJones);
        list.add(johnDoe);
        list.add(johnDoe);
        list.add(marySmith);
        list.add(mikeWilson);
        list.add(janeJones);
        list.forEach(employee -> System.out.println(employee));

        removeDuplicates(list);
        System.out.println();
        list.forEach(employee -> System.out.println(employee));
    }

    public static void removeDuplicates(List<Employee> employeeList) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> toBeRemoved = new LinkedList<>();

        for (Employee employee : employeeList) {
            if (employeeMap.containsKey(employee.getId())) {
                toBeRemoved.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }

        for (Employee employee : toBeRemoved) {
            employeeList.remove(employee);
        }
    }
}
