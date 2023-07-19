import java.util.*;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {


    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     *
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     *
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     *
     * You may assume that there will only be one valid MST that can be formed.
     *
     * You should NOT allow self-loops or parallel edges in the MST.
     *
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        List<Vertex<T>> visited = new ArrayList<>();
        Set<Edge<T>> edgeSet = new HashSet<>();
        PriorityQueue<Edge<T>> PQ = new PriorityQueue<>();

        List<VertexDistance<T>> adjacents = graph.getAdjList().get(start);
        System.out.println("initial adjacents: " + adjacents.toString());
        for (VertexDistance<T> adj : adjacents) {
            PQ.add(new Edge(start, adj.getVertex(), adj.getDistance()));
        }

        visited.add(start);

        while (!PQ.isEmpty() && visited.size() <= graph.getAdjList().size()) {
            Edge<T> curr = PQ.remove();
            System.out.println("curr: " + curr);
            System.out.println("curr.getV(): " + curr.getV());

            if (!visited.contains(curr.getV())) {
                System.out.println("if visited does not contain: " + curr.getV());
                visited.add(curr.getV());
                edgeSet.add(curr);
                edgeSet.add(new Edge(curr.getV(), curr.getU(), curr.getWeight()));

                List<VertexDistance<T>> ws = graph.getAdjList().get(curr.getV());
                System.out.println("ws: " + ws.toString());
                for (VertexDistance<T> adj : ws) {

                    if (!visited.contains(adj.getVertex())) {
                        PQ.add(new Edge(curr.getV(), adj.getVertex(), adj.getDistance()));
                    }
                }
            }
        }
        return edgeSet;
    }



    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     *
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Vertex<T>> visited = new ArrayList<>();
        LinkedList<Vertex<T>> q = new LinkedList<>(); // adds to back by default.

        visited.add(start);

        q.add(start);

        while(!q.isEmpty()) {
            Vertex<T> v = q.removeFirst();
            List<VertexDistance<T>> adjacents = graph.getAdjList().get(v);
            for (VertexDistance<T> adj : adjacents) {
                if (!visited.contains(adj.getVertex())) {
                    visited.add(adj.getVertex());
                    q.add(adj.getVertex());
                }
            }
        }
        return visited;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     *
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     *
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     *
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     *
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     *
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Vertex<T>> traversal = new ArrayList<>();
        helpDfs(start, graph, traversal);
        return traversal;
    }

    private static <T> void helpDfs(Vertex<T> start, Graph<T> graph, List<Vertex<T>> list) {
        // mark start as visited
        list.add(start);

        // list of adjacent vertices
        List<VertexDistance<T>> adjacents = graph.getAdjList().get(start);

        for (VertexDistance<T> adj : adjacents) {
            if (!list.contains(adj.getVertex())) {
                helpDfs(adj.getVertex(), graph, list);
            }
        }
        return;
    }

}