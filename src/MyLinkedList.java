/**
 * Singly Linked List.
 * Insert at head: O(1)   Insert at tail / position, Delete, Search: O(n).
 */
public class MyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;
    private int lastSearchSteps;

    public boolean isEmpty() { return head == null; }
    public int size() { return size; }
    public int getLastSearchSteps() { return lastSearchSteps; }

    public void insertAtHead(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtTail(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    /** Insert at a 0-based position (0 to size). Returns false if the position is invalid. */
    public boolean insertAtPosition(int position, int value) {
        if (position < 0 || position > size) {
            return false;
        }
        if (position == 0) {
            insertAtHead(value);
            return true;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        size++;
        return true;
    }

    /** Deletes the first node holding the value. Returns false if not found / list empty. */
    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    /** Returns the 0-based position of the value or -1. Steps are stored for reporting. */
    public int search(int value) {
        lastSearchSteps = 0;
        Node current = head;
        int position = 0;
        while (current != null) {
            lastSearchSteps++;
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null   (size = " + size + ")");
    }
}
