import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo;

    public DijkstraSearch(Vertex<V> startVertex) {
        super(startVertex);
        this.distTo = new HashMap<>();
        dijkstra(startVertex);
    }

    private void dijkstra(Vertex<V> startVertex) {
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>();

        distTo.put(startVertex, 0.0);
        pq.add(new VertexDistance<>(startVertex, 0.0));

        while (!pq.isEmpty()) {
            VertexDistance<V> currentPair = pq.poll();
            Vertex<V> current = currentPair.vertex;

            if (marked.contains(current)) {
                continue;
            }

            marked.add(current);

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double oldDistance = distTo.getOrDefault(neighbor, Double.POSITIVE_INFINITY);
                double newDistance = distTo.get(current) + weight;

                if (newDistance < oldDistance) {
                    distTo.put(neighbor, newDistance);
                    edgeTo.put(neighbor, current);
                    pq.add(new VertexDistance<>(neighbor, newDistance));
                }
            }
        }
    }

    public double distanceTo(Vertex<V> vertex) {
        return distTo.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }

    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        Vertex<V> vertex;
        double distance;

        VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}
