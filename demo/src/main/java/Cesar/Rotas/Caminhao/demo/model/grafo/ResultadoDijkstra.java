package Cesar.Rotas.Caminhao.demo.model.grafo;

import java.util.List;

public class ResultadoDijkstra {
    private int distanciaMinima;
    private List<Integer> caminho;
 
    public ResultadoDijkstra(int distanciaMinima, List<Integer> caminho) {
        this.distanciaMinima = distanciaMinima;
        this.caminho = caminho;
    }
 
    public int getDistanciaMinima() {
        return distanciaMinima;
    }
 
    public List<Integer> getCaminho() {
        return caminho;
    }
}