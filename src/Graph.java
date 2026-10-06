import java.util.*;

/**
 * Undirected graph using an Adjacency List.
 * BFS uses our own MyQueue, DFS uses our own MyStack.
 * Time complexity of BFS/DFS: O(V + E).
 */
public class Graph {
    private final Map<Integer, List<Integer>> adjacency = new TreeMap<>();

    /** Holds the result of one traversal. */
    public static class TraversalResult {
        public final String algorithm;
        public final List<Integer> order;
        public final int steps;
        public final long timeNs;

        public TraversalResult(String algorithm, List<Integer> order, int steps, long timeNs) {
            this.algorithm = algorithm;
            this.order = order;
            this.steps = steps;
            this.timeNs = timeNs;
        }
    }

    public boolean hasVertex(int v) { return adjacency.containsKey(v); }
    public int vertexCount() { return adjacency.size(); }

    public int edgeCount() {
        int total = 0;
        for (List<Integer> neighbours : adjacency.values()) {
            total += neighbours.size();
        }
        return total / 2; // each undirected edge is stored twice
    }

    /** Returns the smallest vertex id (graph must not be empty). */
    public int firstVertex() {
        return ((TreeMap<Integer, List<Integer>>) adjacency).firstKey();
    }

    /** Adds a vertex. Returns false if it already exists. */
    public boolean addVertex(int v) {
        if (adjacency.containsKey(v)) {
            return false;
        }
        adjacency.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns null on success, otherwise an error message. */
    public String addEdge(int u, int v) {
        if (!hasVertex(u) || !hasVertex(v)) {
            return "Both vertices must exist before adding an edge.";
        }
        if (u == v) {
            return "Self-loops are not allowed.";
        }
        if (adjacency.get(u).contains(v)) {
            return "Edge " + u + " - " + v + " already exists.";
        }
        adjacency.get(u).add(v);
        adjacency.get(v).add(u);
        Collections.sort(adjacency.get(u));
        Collections.sort(adjacency.get(v));
        return null;
    }

    public void display() {
        if (adjacency.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> entry : adjacency.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("Vertices: " + vertexCount() + ", Edges: " + edgeCount());
    }

    /**
     * Breadth First Search - visits the nearest vertices first (level by level) using a Queue.
     * Steps = vertices processed + edges examined.
     */
    public TraversalResult bfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        MyQueue queue = new MyQueue();
        int steps = 0;
        long begin = System.nanoTime();

        visited.add(start);
        queue.enqueue(start);
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            steps++;
            order.add(current);
            for (int neighbour : adjacency.get(current)) {
                steps++;
                if (visited.add(neighbour)) {
                    queue.enqueue(neighbour);
                }
            }
        }
        long time = System.nanoTime() - begin;
        return new TraversalResult("BFS", order, steps, time);
    }

    /**
     * Depth First Search - goes as deep as possible, then backtracks, using a Stack.
     * Steps = vertices popped + edges examined.
     */
    public TraversalResult dfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        MyStack stack = new MyStack();
        int steps = 0;
        long begin = System.nanoTime();

        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            steps++;
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            order.add(current);
            List<Integer> neighbours = adjacency.get(current);
            // push in reverse so the smallest neighbour is visited first
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                steps++;
                int neighbour = neighbours.get(i);
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
        long time = System.nanoTime() - begin;
        return new TraversalResult("DFS", order, steps, time);
    }

    /** Adds a small demo graph (vertices 1-7) so traversals can be tried quickly. */
    public void loadSample() {
        for (int i = 1; i <= 7; i++) {
            addVertex(i);
        }
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {5, 7}};
        for (int[] e : edges) {
            addEdge(e[0], e[1]);
        }
    }

    /** Creates a connected random graph with n vertices (1..n) plus some extra edges. */
    public static Graph createRandomConnected(int n, int extraEdges) {
        Graph g = new Graph();
        Random random = new Random(42); // fixed seed = repeatable results
        for (int i = 1; i <= n; i++) {
            g.addVertex(i);
        }
        for (int i = 2; i <= n; i++) {
            g.addEdge(i, 1 + random.nextInt(i - 1)); // connect to an earlier vertex
        }
        for (int k = 0; k < extraEdges; k++) {
            g.addEdge(1 + random.nextInt(n), 1 + random.nextInt(n)); // errors ignored
        }
        return g;
    }
}
