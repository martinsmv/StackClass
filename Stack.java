/**
 * Stack class
 * @author martinsimov
 * @version 17.2.2024
 * @param <T>
 */
public class Stack<T> {
    private T[] stackArray;
    private int size = -1;
    /**
     * Constructor
     * @param size of stack
     */
    public Stack(int size) {
        this.stackArray = (T[]) new Object[size];
    }
    /**
     * Constructor
     */
    public Stack() {
        this(10);
    }
    /**
     * Push method
     * @param value to be pushed
     * @throws StackFullException when stack is full
     */
    public void push(T value) throws StackFullException {
        if (size < stackArray.length - 1) {
            stackArray[++size] = value;
        }
        else {
            throw new StackFullException("Stack is full!");
        }
    }
    /**
     * Pop method
     * @return latest object
     * @throws StackEmptyException when stack is empty
     */
    public T pop() throws StackEmptyException {
        if (size >= 0) {
            return (T) stackArray[size--];
        }
        else {
            throw new StackEmptyException("Stack is empty!");
        }
    }
    /**
     * Peek method
     * @return latest object
     * @throws StackEmptyException when stack is empty
     */
    public T peek() throws StackEmptyException {
        if (size >= 0) {
            return (T) stackArray[size];
        }
        else {
            throw new StackEmptyException("Stack is empty!");
        }
    }
    /**
     * List method
     * @return list of objects
     */
    public String list() {
        String list = "";
        for (int i = 0; i <= size; i++) {
            list += stackArray[i] + ";";
        }
        return list;
    }
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        // Test with a number stack
        Stack<Integer> numberStack = new Stack<>(5);
        try {
            numberStack.push(1);
            numberStack.push(2);
            numberStack.push(3);
            System.out.println(numberStack.list());
            System.out.println(numberStack.pop());
            System.out.println(numberStack.list());
        } catch (StackFullException e) {
            System.err.println("Number Stack is full!");
        } catch (StackEmptyException e) {
            System.err.println("Number Stack is empty!");
        }

        // Test with a text stack
        Stack<String> textStack = new Stack<>(5);
        try {
            textStack.push("A");
            textStack.push("B");
            textStack.push("C");
            System.out.println(textStack.list());
            System.out.println(textStack.pop());
            System.out.println(textStack.list());
        } catch (StackFullException e) {
            System.err.println("Text Stack is full!");
        } catch (StackEmptyException e) {
            System.err.println("Text Stack is empty!");
        }
    }
}
/**
 * StackFullException class
 */
class StackFullException extends Exception{
    public StackFullException(String message) {
        super(message);
    }
}
/**
 * StackEmptyException class
 */
class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}