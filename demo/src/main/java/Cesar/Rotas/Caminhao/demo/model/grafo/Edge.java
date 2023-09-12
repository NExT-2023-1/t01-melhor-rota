package Cesar.Rotas.Caminhao.demo.model.grafo;

import java.util.ArrayList;
import java.util.List;

import Cesar.Rotas.Caminhao.demo.Grafo.Vertice;

public class Edge<edges>  {
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
//      OU
// class Aresta {
//     private Vertice origem;
//     private Vertice destino;
//     private int peso;

//     public Aresta(Vertice origem, Vertice destino, int peso) {
//         this.origem = origem;
//         this.destino = destino;
//         this.peso = peso;
//     }

//     public Vertice getOrigem() {
//         return origem;
//     }

//     public Vertice getDestino() {
//         return destino;
//     }

//     public int getPeso() {
//         return peso;
//     }
// }