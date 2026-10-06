import java.util.*;

/**
 * Stores and compares performance results (steps + execution time)
 * of searching and graph traversal algorithms.
 */
public class PerformanceAnalyzer {

    private static class Record {
        final String operation;
        final String algorithm;
        final String details;
        final int steps;
        final long timeNs;

        Record(String operation, String algorithm, String details, int steps, long timeNs) {
            this.operation = operation;
            this.algorithm = algorithm;
            this.details = details;
            this.steps = steps;
            this.timeNs = timeNs;
        }
    }

    private final List<Record> records = new ArrayList<>();

    public void addRecord(String operation, String algorithm, String details, int steps, long timeNs) {
        records.add(new Record(operation, algorithm, details, steps, timeNs));
    }

    private void printHeader(String title) {
        System.out.println("=============================================");
        System.out.println(" " + title);
        System.out.println("=============================================");
        System.out.printf("%-16s %-16s %-10s %-12s %s%n", "Operation", "Algorithm", "Steps", "Time(ns)", "Details");
        System.out.println("-----------------------------------------------------------------------");
    }

    private void printRow(Record r) {
        System.out.printf("%-16s %-16s %-10d %-12d %s%n", r.operation, r.algorithm, r.steps, r.timeNs, r.details);
    }

    /**
     * Compares Linear and Binary search on a sorted array of n elements.
     * targetChoice: 1 = last element (worst case), 2 = middle element, 3 = value not in array.
     */
    public void compareSearching(int n, int targetChoice) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2; // sorted even numbers 0, 2, 4, ...
        }
        int target;
        String targetName;
        if (targetChoice == 1) {
            target = arr[n - 1];
            targetName = "last element";
        } else if (targetChoice == 2) {
            target = arr[n / 2];
            targetName = "middle element";
        } else {
            target = -1;
            targetName = "not in array";
        }
        String details = "n=" + n + ", target=" + target + " (" + targetName + ")";

        Searching.SearchResult linear = Searching.linearSearch(arr, target);
        Searching.SearchResult binary = Searching.binarySearch(arr, target);

        addRecord("Search", linear.algorithm, details, linear.steps, linear.timeNs);
        addRecord("Search", binary.algorithm, details, binary.steps, binary.timeNs);

        printHeader("PERFORMANCE COMPARISON - SEARCHING");
        printRow(records.get(records.size() - 2));
        printRow(records.get(records.size() - 1));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Linear Search is O(n): steps grow with the array size.");
        System.out.println("Binary Search is O(log n): the range is halved every step.");
        System.out.println("Note: time can vary between runs (JVM warm-up), but the step counts stay reliable.");
    }

    /** Runs BFS and DFS from the start vertex and compares them. */
    public void compareTraversal(Graph graph, int start) {
        Graph.TraversalResult bfs = graph.bfs(start);
        Graph.TraversalResult dfs = graph.dfs(start);
        String details = "V=" + graph.vertexCount() + ", E=" + graph.edgeCount() + ", start=" + start;

        addRecord("Graph Traversal", "BFS", details, bfs.steps, bfs.timeNs);
        addRecord("Graph Traversal", "DFS", details, dfs.steps, dfs.timeNs);

        printHeader("PERFORMANCE COMPARISON - GRAPH TRAVERSAL");
        printRow(records.get(records.size() - 2));
        printRow(records.get(records.size() - 1));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("BFS order: " + shorten(bfs.order));
        System.out.println("DFS order: " + shorten(dfs.order));
        System.out.println("Both are O(V + E): every vertex and edge is processed once.");
        System.out.println("BFS uses a Queue (level by level); DFS uses a Stack (deep first).");
    }

    /** Displays every result recorded so far (searches, traversals, comparisons). */
    public void displayAll() {
        if (records.isEmpty()) {
            System.out.println("No results recorded yet. Run searches, traversals or comparisons first.");
            return;
        }
        printHeader("ALL RECORDED RESULTS");
        for (Record r : records) {
            printRow(r);
        }
        System.out.println("Total results: " + records.size());
    }

    private String shorten(List<Integer> list) {
        if (list.size() <= 20) {
            return list.toString();
        }
        return list.subList(0, 20) + " ... (" + list.size() + " vertices)";
    }
}
