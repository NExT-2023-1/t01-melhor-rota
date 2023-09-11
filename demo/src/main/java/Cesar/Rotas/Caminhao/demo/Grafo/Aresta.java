package Cesar.Rotas.Caminhao.demo.Grafo;

public class Aresta <TIPO>{
   
    private Double distancia;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;
   
    public Double getDistancia() {
        return distancia;
    }
    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    public Vertice<TIPO> getInicio() {
        return inicio;
    }
    public void setInício(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }
    public Vertice<TIPO> getFim() {
        return fim;
    }
    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }
    public Aresta(Double distancia, Vertice<TIPO> inicio, Vertice<TIPO> fim) {
        this.distancia = distancia;
        this.inicio = inicio;
        this.fim = fim;
    }
    public Aresta() {
    }
  

    
}