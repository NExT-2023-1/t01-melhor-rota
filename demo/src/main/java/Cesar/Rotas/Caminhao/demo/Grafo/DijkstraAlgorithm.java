package Cesar.Rotas.Caminhao.demo.MozanaTeste;

import java.util.HashSet;
import java.util.PriorityQueue;

import org.hibernate.graph.Graph;

public class DijkstraAlgorithm {
    
    public static void dijkstra(Graph graph, Vertex source) {
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));

        source.distance = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (!visited.contains(current)) {
                visited.add(current);

                for (Edge edge : graph.edges) {
                    if (edge.source == current) {
                        Vertex neighbor = edge.destination;
                        int tentativeDistance = current.distance + edge.weight;

                        if (tentativeDistance < neighbor.distance) {
                            neighbor.distance = tentativeDistance;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
    }
}
