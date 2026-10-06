/**
 * Linked-node Queue (FIFO - First In, First Out).
 * Enqueue, Dequeue and Peek are all O(1).
 */
public class MyQueue {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node front;
    private Node rear;
    private int size;

    public boolean isEmpty() { return front == null; }
    public int size() { return size; }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    /** Removes and returns the front element. Throws if the queue is empty. */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty! Cannot dequeue.");
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    /** Returns the front element without removing it. Throws if empty. */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty! Nothing at the front.");
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " <- " : ""));
            current = current.next;
        }
        System.out.println();
    }
}
