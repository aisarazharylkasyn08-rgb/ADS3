import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Search<V> {
    protected Vertex<V> startVertex;
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;

    public Search(Vertex<V> startVertex) {
        this.startVertex = startVertex;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> vertex) {
        return marked.contains(vertex);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }

        ArrayListStack<Vertex<V>> path = new ArrayListStack<>();

        for (Vertex<V> current = vertex; !current.equals(startVertex); current = edgeTo.get(current)) {
            path.push(current);
        }

        path.push(startVertex);
        return path;
    }
}
