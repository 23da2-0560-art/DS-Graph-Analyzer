import java.util.List;

/**
 * DATA STRUCTURE & GRAPH PERFORMANCE ANALYZER
 * Main console application - integrates all components.
 */
public class Main {
    private static final ArrayOperations array = new ArrayOperations(100);
    private static final MyStack stack = new MyStack();
    private static final MyQueue queue = new MyQueue();
    private static final MyLinkedList linkedList = new MyLinkedList();
    private static final Graph graph = new Graph();
    private static final PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: analyzer.displayAll(); break;
                case 9:
                    running = false;
                    System.out.println("Thank you for using the analyzer. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 9.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ------------------------------------------------------------------ ARRAY
    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Index");
            System.out.println("3. Delete by Value");
            System.out.println("4. Delete at Index");
            System.out.println("5. Search (Linear)");
            System.out.println("6. Sort Array");
            System.out.println("7. Display Array");
            System.out.println("8. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    if (array.isFull()) {
                        System.out.println("Array is full! (capacity " + array.capacity() + ")");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value: ");
                    array.insertAtEnd(value);
                    System.out.println("Inserted " + value + ".");
                    break;
                }
                case 2: {
                    if (array.isFull()) {
                        System.out.println("Array is full! (capacity " + array.capacity() + ")");
                        break;
                    }
                    int index = InputHelper.readIntInRange("Enter index (0-" + array.size() + "): ", 0, array.size());
                    int value = InputHelper.readInt("Enter value: ");
                    array.insertAtIndex(index, value);
                    System.out.println("Inserted " + value + " at index " + index + ".");
                    break;
                }
                case 3: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty! Nothing to delete.");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value to delete: ");
                    System.out.println(array.deleteByValue(value) ? "Deleted " + value + "." : "Value not found.");
                    break;
                }
                case 4: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty! Nothing to delete.");
                        break;
                    }
                    int index = InputHelper.readIntInRange("Enter index (0-" + (array.size() - 1) + "): ", 0, array.size() - 1);
                    array.deleteAtIndex(index);
                    System.out.println("Deleted element at index " + index + ".");
                    break;
                }
                case 5: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty! Nothing to search.");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value to search: ");
                    int index = array.indexOf(value);
                    System.out.println(index == -1 ? "Value not found." : "Found at index " + index + ".");
                    break;
                }
                case 6:
                    array.sort();
                    System.out.println("Array sorted in ascending order.");
                    break;
                case 7: array.display(); break;
                case 8: back = true; break;
                default: System.out.println("Invalid choice! Please enter a number from 1 to 8.");
            }
        }
    }

    // ------------------------------------------------------------------ STACK
    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            try {
                switch (choice) {
                    case 1:
                        int value = InputHelper.readInt("Enter value to push: ");
                        stack.push(value);
                        System.out.println("Pushed " + value + ".");
                        break;
                    case 2: System.out.println("Popped: " + stack.pop()); break;
                    case 3: System.out.println("Top element: " + stack.peek()); break;
                    case 4: stack.display(); break;
                    case 5: back = true; break;
                    default: System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ------------------------------------------------------------------ QUEUE
    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            try {
                switch (choice) {
                    case 1:
                        int value = InputHelper.readInt("Enter value to enqueue: ");
                        queue.enqueue(value);
                        System.out.println("Enqueued " + value + ".");
                        break;
                    case 2: System.out.println("Dequeued: " + queue.dequeue()); break;
                    case 3: System.out.println("Front element: " + queue.peek()); break;
                    case 4: queue.display(); break;
                    case 5: back = true; break;
                    default: System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ------------------------------------------------------------ LINKED LIST
    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n---------- LINKED LIST OPERATIONS ----------");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at Tail");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value: ");
                    linkedList.insertAtHead(value);
                    System.out.println("Inserted " + value + " at head.");
                    break;
                }
                case 2: {
                    int value = InputHelper.readInt("Enter value: ");
                    linkedList.insertAtTail(value);
                    System.out.println("Inserted " + value + " at tail.");
                    break;
                }
                case 3: {
                    int position = InputHelper.readIntInRange("Enter position (0-" + linkedList.size() + "): ", 0, linkedList.size());
                    int value = InputHelper.readInt("Enter value: ");
                    linkedList.insertAtPosition(position, value);
                    System.out.println("Inserted " + value + " at position " + position + ".");
                    break;
                }
                case 4: {
                    if (linkedList.isEmpty()) {
                        System.out.println("Linked list is empty! Nothing to delete.");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value to delete: ");
                    System.out.println(linkedList.deleteByValue(value) ? "Deleted " + value + "." : "Value not found.");
                    break;
                }
                case 5: {
                    if (linkedList.isEmpty()) {
                        System.out.println("Linked list is empty! Nothing to search.");
                        break;
                    }
                    int value = InputHelper.readInt("Enter value to search: ");
                    int position = linkedList.search(value);
                    String result = position == -1 ? "Value not found." : "Found at position " + position + ".";
                    System.out.println(result + " (steps: " + linkedList.getLastSearchSteps() + ")");
                    break;
                }
                case 6: linkedList.display(); break;
                case 7: back = true; break;
                default: System.out.println("Invalid choice! Please enter a number from 1 to 7.");
            }
        }
    }

    // -------------------------------------------------------------- SEARCHING
    private static void searchingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n-------------- SEARCHING OPERATIONS ---------");
            System.out.println("(Searches the data stored in the Array component)");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            if (choice == 4) {
                back = true;
                continue;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice! Please enter a number from 1 to 4.");
                continue;
            }
            if (array.isEmpty()) {
                System.out.println("Array is empty! Add elements in Array Operations first.");
                continue;
            }
            int target = InputHelper.readInt("Enter value to search: ");
            if (choice == 1) {
                recordSearch(Searching.linearSearch(array.toArray(), target), target);
            } else {
                // Binary search needs a sorted array
                if (!Searching.isSorted(array.toArray())) {
                    System.out.println("Binary Search needs a sorted array, but the array is not sorted.");
                    if (!InputHelper.readYesNo("Sort the array now?")) {
                        continue;
                    }
                    array.sort();
                    System.out.println("Array sorted.");
                }
                int[] data = array.toArray();
                if (choice == 2) {
                    recordSearch(Searching.binarySearch(data, target), target);
                } else {
                    recordSearch(Searching.linearSearch(data, target), target);
                    recordSearch(Searching.binarySearch(data, target), target);
                }
            }
        }
    }

    private static void recordSearch(Searching.SearchResult result, int target) {
        System.out.println(result);
        analyzer.addRecord("Search", result.algorithm, "n=" + array.size() + ", target=" + target,
                result.steps, result.timeNs);
    }

    // ------------------------------------------------------------------ GRAPH
    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    int v = InputHelper.readInt("Enter vertex number: ");
                    System.out.println(graph.addVertex(v) ? "Vertex " + v + " added." : "Vertex " + v + " already exists.");
                    break;
                }
                case 2: {
                    if (graph.vertexCount() < 2) {
                        System.out.println("Add at least 2 vertices first.");
                        break;
                    }
                    int u = InputHelper.readInt("Enter first vertex: ");
                    int v = InputHelper.readInt("Enter second vertex: ");
                    String error = graph.addEdge(u, v);
                    System.out.println(error == null ? "Edge " + u + " - " + v + " added." : "Error: " + error);
                    break;
                }
                case 3: graph.display(); break;
                case 4:
                case 5: {
                    if (graph.vertexCount() == 0) {
                        System.out.println("Graph is empty! Add vertices first.");
                        break;
                    }
                    int start = InputHelper.readInt("Enter start vertex: ");
                    if (!graph.hasVertex(start)) {
                        System.out.println("Vertex " + start + " does not exist.");
                        break;
                    }
                    Graph.TraversalResult result = (choice == 4) ? graph.bfs(start) : graph.dfs(start);
                    printTraversal(result, start);
                    break;
                }
                case 6:
                    graph.loadSample();
                    System.out.println("Sample graph loaded (vertices 1-7).");
                    break;
                case 7: back = true; break;
                default: System.out.println("Invalid choice! Please enter a number from 1 to 7.");
            }
        }
    }

    private static void printTraversal(Graph.TraversalResult result, int start) {
        System.out.println(result.algorithm + " order: " + result.order);
        System.out.println("Steps: " + result.steps + " | Time: " + result.timeNs + " ns");
        analyzer.addRecord("Graph Traversal", result.algorithm,
                "V=" + graph.vertexCount() + ", E=" + graph.edgeCount() + ", start=" + start,
                result.steps, result.timeNs);
    }

    // ------------------------------------------------------------ PERFORMANCE
    private static void performanceMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n---------- PERFORMANCE COMPARISON -----------");
            System.out.println("1. Compare Linear vs Binary Search (generated data)");
            System.out.println("2. Compare BFS vs DFS (your graph)");
            System.out.println("3. Compare BFS vs DFS (large generated graph)");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    int n = InputHelper.readIntInRange("Enter array size (1 - 1000000): ", 1, 1000000);
                    System.out.println("Target: 1. Last element (worst case)  2. Middle element  3. Not in array");
                    int target = InputHelper.readIntInRange("Choose target (1-3): ", 1, 3);
                    analyzer.compareSearching(n, target);
                    break;
                }
                case 2: {
                    if (graph.vertexCount() == 0) {
                        System.out.println("Graph is empty! Add vertices/edges or load the sample graph first.");
                        break;
                    }
                    analyzer.compareTraversal(graph, graph.firstVertex());
                    break;
                }
                case 3: {
                    int n = InputHelper.readIntInRange("Enter number of vertices (2 - 5000): ", 2, 5000);
                    Graph big = Graph.createRandomConnected(n, n);
                    analyzer.compareTraversal(big, big.firstVertex());
                    break;
                }
                case 4: back = true; break;
                default: System.out.println("Invalid choice! Please enter a number from 1 to 4.");
            }
        }
    }
}
