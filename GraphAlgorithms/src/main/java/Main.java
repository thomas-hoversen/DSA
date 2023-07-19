import java.util.*;

public class Main {

    public static void main(String[] args) {

        //System.out.println("Hello, World!");

        // create vertices
        Vertex<String> a = new Vertex<>("a");
        Vertex<String> b = new Vertex<>("b");
        Vertex<String> c = new Vertex<>("c");
        Vertex<String> d = new Vertex<>("d");
        Vertex<String> e = new Vertex<>("e");
        Vertex<String> f = new Vertex<>("f");
        Vertex<String> g = new Vertex<>("g");
        Vertex<String> h = new Vertex<>("h");
        Vertex<String> b2 = new Vertex<>("b");

        // add vertices to a set
        Set<Vertex> vertices = new HashSet<>();
        vertices.add(a);vertices.add(b);vertices.add(c);vertices.add(d);
        vertices.add(e);vertices.add(f);vertices.add(g);vertices.add(h);

        vertices.add(b2);

        // create edges Edge(from, to, weight)
        Edge ab = new Edge(a, b, 4);
        Edge ba = new Edge(b, a, 4);
        Edge be = new Edge(b, e, 4);
        Edge eb = new Edge(e, b, 4);
        Edge ef = new Edge(e, f, 4);
        Edge fe = new Edge(f, e, 4);
        Edge ac = new Edge(a, c, 3);
        Edge ca = new Edge(c, a, 3);
        Edge cd = new Edge(c, d, 8);
        Edge dc = new Edge(d, c, 8);
        Edge dg = new Edge(d, g, 7);
        Edge gd = new Edge(g, d, 7);
        Edge gh = new Edge(g, h, 1);
        Edge hg = new Edge(h, g, 1);

        Edge bd = new Edge(b, d, 2);
        Edge db = new Edge(d, b, 2);
        Edge fb2 = new Edge(f, b2, 12);
        Edge b2f = new Edge(b2, f, 12);
        Edge df = new Edge(d, f, 3);
        Edge fd = new Edge(f, d, 3);


        // add edges to a set
        Set<Edge> edges = new HashSet<>();
        edges.add(ab);edges.add(ba);edges.add(be);edges.add(eb);edges.add(ef);
        edges.add(fe);edges.add(ac);edges.add(ca);edges.add(cd);edges.add(dc);
        edges.add(dg);edges.add(gd);edges.add(gh);edges.add(hg);

        edges.add(bd);edges.add(db);edges.add(df);edges.add(fd);//edges.add(fb2);edges.add(b2f);

        // instantiate graph with the 2 sets
        Graph g1 = new Graph(vertices, edges);

        // log vertices, edges, and adjList before continuing
        System.out.println("Vertices: " + g1.getVertices());
        System.out.println("Edges: " + g1.getEdges());
        System.out.println("AdjList: " + g1.getAdjList());

        //List<Vertex> dfsList = dfs(a, g1);
        //List<Vertex> bfsList = bfs(a, g1);
        Set<Edge> primList = prims(a, g1);

        System.out.println("Prims results: " + primList.toString());
        //System.out.println("dfs results: " + dfsList.toString());
        //System.out.println("bfs results: " + bfsList.toString());

    }

    // @return The MST of the graph or null if there is no valid MST.
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

    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Vertex<T>> traversal = new ArrayList<>();
        helpDfs(start, graph, traversal);
        return traversal;
    }

    public static <T> void helpDfs(Vertex<T> start, Graph<T> graph, List<Vertex<T>> list) {
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
