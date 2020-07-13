package Stack;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

//        ArrayStack stack = new ArrayStack(10);
//        stack.push(janeJones);
//        stack.push(johnDoe);
//        stack.push(marySmith);
//        stack.push(mikeWilson);
//        stack.push(new Employee("Bill", "End", 78));
//
////        stack.printStack();
//
//        System.out.println( "Peaked: " + stack.peek());
////        stack.printStack();
//
//        System.out.println("Popped: " + stack.pop());
//        stack.printStack();
//        System.out.println( "Peaked: " + stack.peek());


        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);

//        stack.printStack();

        System.out.println("Peeked: " + stack.peek());
        stack.printStack();

        System.out.println("Popped: " + stack.pop());
        stack.printStack();

    }
}
