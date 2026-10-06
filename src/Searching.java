/**
 * Searching algorithms with a step counter and execution timer.
 * Linear Search: O(n)      Binary Search: O(log n) - needs a SORTED array.
 */
public class Searching {

    /** Holds the result of one search. */
    public static class SearchResult {
        public final String algorithm;
        public final int index;     // -1 if not found
        public final int steps;     // number of comparisons
        public final long timeNs;   // execution time in nanoseconds

        public SearchResult(String algorithm, int index, int steps, long timeNs) {
            this.algorithm = algorithm;
            this.index = index;
            this.steps = steps;
            this.timeNs = timeNs;
        }

        @Override
        public String toString() {
            String found = (index == -1) ? "NOT FOUND" : "found at index " + index;
            return algorithm + ": " + found + " | steps = " + steps + " | time = " + timeNs + " ns";
        }
    }

    /** Checks whether the array is sorted in ascending order. */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    /** Checks every element from left to right. */
    public static SearchResult linearSearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                found = i;
                break;
            }
        }
        long time = System.nanoTime() - start;
        return new SearchResult("Linear Search", found, steps, time);
    }

    /** Repeatedly halves the search range. The array MUST be sorted. */
    public static SearchResult binarySearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int found = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                found = mid;
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long time = System.nanoTime() - start;
        return new SearchResult("Binary Search", found, steps, time);
    }
}
