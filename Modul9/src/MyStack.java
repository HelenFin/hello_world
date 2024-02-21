import java.util.Stack;

public class MyStack {

    public static void main(String[] args){
        Stack<Integer> myStack = new Stack<>();

        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        myStack.push(6);
        myStack.add(4);
        myStack.add(5);


        System.out.println(myStack);

        System.out.println("Removing the element by index " + myStack.remove(1));
        System.out.println("Return the first element of stack " + myStack.peek());
        System.out.println("Return the first element of stack and remove it " + myStack.pop());
        System.out.println("The size of the stack is " + myStack.size());

        for(int stack : myStack){
            System.out.println(stack);
        }
    }
}
