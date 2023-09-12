package Cesar.Rotas.Caminhao.demo.model.grafo;



public class Vertex {
    
        public int id;
        public int distancia;
    
        public Vertex(int id) {
            this.id = id;
            this.distancia = Integer.MAX_VALUE;
        }
    }