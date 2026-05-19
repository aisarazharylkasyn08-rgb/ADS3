import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(Vertex<V> startVertex) {
        super(startVertex);
        bfs(startVertex);
    }

    private void bfs(Vertex<V> startVertex) {
        Queue<Vertex<V>> queue = new LinkedList<>();

        marked.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
