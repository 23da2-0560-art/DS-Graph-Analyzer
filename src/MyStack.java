import java.util.Arrays;

/**
 * Array-based Stack (LIFO - Last In, First Out).
 * Push, Pop and Peek are all O(1) (push is amortised O(1) because the array grows when full).
 */
public class MyStack {
    private int[] items;
    private int top;

    public MyStack() {
        items = new int[10];
        top = -1;
    }

    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }

    public void push(int value) {
        if (top == items.length - 1) {
            items = Arrays.copyOf(items, items.length * 2); // grow when full
        }
        items[++top] = value;
    }

    /** Removes and returns the top element. Throws if the stack is empty. */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty! Cannot pop.");
        }
        return items[top--];
    }

    /** Returns the top element without removing it. Throws if empty. */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty! Nothing to peek.");
        }
        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + items[i] + " |" + (i == top ? "  <- top" : ""));
        }
    }
}
