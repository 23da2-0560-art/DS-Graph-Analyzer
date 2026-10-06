public class SearchDemo {
    public static void main(String[] args) {
        ArrayOperations arr = new ArrayOperations(10);
        int[] values = {45, 12, 78, 33, 90, 21, 56};
        for (int v : values) {
            arr.insertAtEnd(v);
        }

        System.out.println("=== Original array ===");
        arr.display();

        int[] data = arr.toArray();
        System.out.println("\nIs sorted? " + Searching.isSorted(data));

        System.out.println("\n=== Linear Search (unsorted) ===");
        System.out.println(Searching.linearSearch(data, 33));
        System.out.println(Searching.linearSearch(data, 500));

        System.out.println("\n=== Sorting ===");
        arr.sort();
        arr.display();
        data = arr.toArray();
        System.out.println("Is sorted? " + Searching.isSorted(data));

        System.out.println("\n=== Linear vs Binary (sorted) ===");
        int[] targets = {33, 90, 12, 500};
        for (int t : targets) {
            System.out.println("Target = " + t);
            System.out.println("  " + Searching.linearSearch(data, t));
            System.out.println("  " + Searching.binarySearch(data, t));
        }
    }
}