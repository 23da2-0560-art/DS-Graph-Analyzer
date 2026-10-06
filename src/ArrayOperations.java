import java.util.Arrays;

/**
 * Fixed-capacity array with Insert, Delete, Search, Sort and Display operations.
 * Insert/Delete in the middle need shifting of elements, so they are O(n).
 */
public class ArrayOperations {
    private final int[] data;
    private int size;

    public ArrayOperations(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int size() { return size; }
    public int capacity() { return data.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }

    /** Insert at the end - O(1). Returns false if the array is full. */
    public boolean insertAtEnd(int value) {
        if (isFull()) {
            return false;
        }
        data[size++] = value;
        return true;
    }

    /** Insert at a given index - O(n) because elements are shifted right. */
    public boolean insertAtIndex(int index, int value) {
        if (isFull() || index < 0 || index > size) {
            return false;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Delete the element at an index - O(n) because elements are shifted left. */
    public boolean deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Delete the first occurrence of a value. */
    public boolean deleteByValue(int value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        return deleteAtIndex(index);
    }

    /** Linear search - returns the index or -1 if not found. */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /** Sorts the array using insertion sort (needed for binary search). */
    public void sort() {
        for (int i = 1; i < size; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    /** Returns a copy containing only the used part of the array. */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.println("Array (" + size + "/" + data.length + " used):");
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "]=" + data[i] + "  ");
        }
        System.out.println();
    }
}
