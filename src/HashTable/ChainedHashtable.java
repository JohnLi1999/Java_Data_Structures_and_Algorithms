package HashTable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10]; // create the array that contains linked lists
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>(); // initialize each position
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        while (iterator.hasNext()) {
            StoredEmployee se = iterator.next();
            if (se.key.equals(key)) {
                return se.employee;
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        int index = 0;
        while (iterator.hasNext()) {
            StoredEmployee se = iterator.next();
            if (se.key.equals(key)) {
                hashtable[hashedKey].remove(index);
                return se.employee;
            }
            index++;
        }

        return null;
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);

//        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().employee + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}
