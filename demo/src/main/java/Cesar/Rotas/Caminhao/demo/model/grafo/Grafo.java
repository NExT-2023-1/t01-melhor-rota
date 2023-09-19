package Cesar.Rotas.Caminhao.demo.model.grafo;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Grafo {
    private final int V; // Número de vértices no grafo
    private final int[][] grafo;
    private static final List<String>vertices=new ArrayList<String>(Arrays.asList("Int1","Int2","Int3","Int4","Int5","Int6","Int7","Int8","Int9","Int10","Int11","Int12","Int13","Desc1","Desc2","Desc3","Esc1","Esc2","Esc3"));
    
    public Grafo(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        String[] linhas = content.split("\r\n");
        this.V = linhas.length-1;
        this.grafo = new int[V][V];

 //inserir para ler linhas inicialmente

        for (int i = 1; i < V+1; i++) {
            String[] valores = linhas[i].split(";");
            for (int j = 0; j < V; j++) 
            {
                grafo[i-1][j] = Integer.parseInt(valores[j]);
            }
        }
    }
 
    private int encontrarMinimaDistancia(int[] distancias, boolean[] visitados) {
        int minimo = Integer.MAX_VALUE;
        int indiceMinimo = -1;
 
        for (int v = 0; v < V; v++) {
            if (!visitados[v] && distancias[v] <= minimo) {
                minimo = distancias[v];
                indiceMinimo = v;
            }
        }
 
        return indiceMinimo;
    }
 
    public ResultadoDijkstra encontrarCaminhoMaisCurto(String verticeOrigem,String verticeDestino) {
        int[] distancias = new int[V];
        boolean[] visitados = new boolean[V];
        int[] predecessores = new int[V];
        int indexVerticeOrigem=vertices.indexOf(verticeOrigem);
        int indexVerticeDestino=vertices.indexOf(verticeDestino);
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[indexVerticeOrigem] = 0;
 
        while (!visitados[indexVerticeDestino]) {
            int u = encontrarMinimaDistancia(distancias, visitados);
            visitados[u] = true;
 
            for (int v = 0; v < V; v++) {
                if (!visitados[v] && grafo[u][v] != Integer.MAX_VALUE &&
                    distancias[u] != Integer.MAX_VALUE &&
                    distancias[u] + grafo[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + grafo[u][v];
                    predecessores[v] = u;
                }
            }
        }
 
        List<Integer> caminho = new ArrayList<>();
        int atual = indexVerticeDestino;
        while (atual != indexVerticeOrigem) {
            caminho.add(atual);
            atual = predecessores[atual];
        }
        caminho.add(indexVerticeOrigem);
        List<String> caminhoReverso = new ArrayList<>();
        for (int i = caminho.size() - 1; i >= 0; i--) {
            caminhoReverso.add(vertices.get(caminho.get(i)));
        }
 
        return new ResultadoDijkstra(distancias[indexVerticeDestino], caminhoReverso);
    }
}

 