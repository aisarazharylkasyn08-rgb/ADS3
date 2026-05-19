import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<V> {
    private List<Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new ArrayList<>();
    }

    public Vertex<V> addVertex(V data) {
        Vertex<V> vertex = new Vertex<>(data);
        vertices.add(vertex);
        return vertex;
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);

        if (!directed) {
            destination.addAdjacentVertex(source, weight);
        }
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }
}
