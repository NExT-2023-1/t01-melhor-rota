package Cesar.Rotas.Caminhao.demo.model.grafo;

import java.util.List;

public class ResultadoDijkstra {
    private int distanciaMinima;
    private List<String> caminho;
 
    public ResultadoDijkstra(int distanciaMinima, List<String> caminho) {
        this.distanciaMinima = distanciaMinima;
        this.caminho = caminho;
    }
 
    public int getDistanciaMinima() {
        return distanciaMinima;
    }
 
    public List<String> getCaminho() {
        return caminho;
    }
}