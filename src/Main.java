public class Main {
    public static void main(String[] args) {
        ArrayOperations arr = new ArrayOperations(5);

        System.out.println("--- Insert at end ---");
        arr.insertAtEnd(30);
        arr.insertAtEnd(10);
        arr.insertAtEnd(20);
        arr.display();

        System.out.println("\n--- Insert 99 at index 1 ---");
        arr.insertAtIndex(1, 99);
        arr.display();

        System.out.println("\n--- Search ---");
        System.out.println("Index of 20: " + arr.indexOf(20));
        System.out.println("Index of 500: " + arr.indexOf(500));

        System.out.println("\n--- Delete value 10 ---");
        arr.deleteByValue(10);
        arr.display();

        System.out.println("\n--- Sort ---");
        arr.sort();
        arr.display();

        System.out.println("\n--- Full check ---");
        arr.insertAtEnd(5);
        arr.insertAtEnd(7);
        System.out.println("Is full: " + arr.isFull());
        System.out.println("Insert when full: " + arr.insertAtEnd(1));
    }
}