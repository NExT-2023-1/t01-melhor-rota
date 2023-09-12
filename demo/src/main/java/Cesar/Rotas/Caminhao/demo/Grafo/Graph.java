package Cesar.Rotas.Caminhao.demo.MozanaTeste;

import java.util.ArrayList;

import Cesar.Rotas.Caminhao.demo.Grafo.Vertice;

public class Graph<edges>  {
 public List<Vertex> vertices;
    public List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        Vertice.add(vertex);
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edges.add(edge);
    }
}