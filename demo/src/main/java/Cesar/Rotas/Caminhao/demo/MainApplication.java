package Cesar.Rotas.Caminhao.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Cesar.Rotas.Caminhao.demo.model.grafo.Grafo;
import Cesar.Rotas.Caminhao.demo.model.grafo.ResultadoDijkstra;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\madxu\\Desktop\\DESAFIO FINAL NEXT\\t01-melhor-rota\\demo\\src\\main\\resources\\mapeamento_mapa_mina.txt";
        Grafo dijkstra = new Grafo(filePath);

        int verticeOrigem = 0; // Substitua pelo vértice de origem desejado
        int verticeDestino = 4; // Substitua pelo vértice de destino desejado

        ResultadoDijkstra resultado = dijkstra.encontrarCaminhoMaisCurto(verticeOrigem, verticeDestino);
        int distanciaMinima = resultado.getDistanciaMinima();
        List<Integer> caminho = resultado.getCaminho();

        System.out.println("Distância mínima de " + verticeOrigem + " a " + verticeDestino + ":" + distanciaMinima);
        System.out.println("Caminho: " + caminho);

        // Iniciar o aplicativo Spring Boot
        SpringApplication.run(MainApplication.class, args);
    }
}