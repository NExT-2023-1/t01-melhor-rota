package Cesar.Rotas.Caminhao.demo.Grafo;

import java.util.ArrayList;

public class Grafo <TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    
    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice (TIPO dado) {
       Vertice<TIPO> novoVertice = new Vertice<TIPO> (dado);
       this.vertices.add(novoVertice);
    }

    public void adicionarArestas(Double distancia, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio); //local do inicio da rota
        Vertice<TIPO> fim = this.getVertice(dadoFim); //local do fim da rota 
        Aresta<TIPO> aresta = new Aresta<TIPO>(distancia, inicio, fim); // criacao da aresta
        inicio.adicionarArestaSaida(aresta); //caminho da saida
        fim.adicionarArestaEntrada(aresta); // aresta de fim
        this.arestas.add(aresta);//guarda as arestas no grafo
    }
        public Vertice<TIPO> getVertice(TIPO dado){
            Vertice<TIPO> vertice = null; // se nao encontrar
            for (int i=0; i<this.vertices.size(); i++){
                if (this.vertices.get(i). getDado(). equals(dado)){
                    vertice = this.vertices.get(i);
                    break; //quando encontrar para
                }
            }   
        return vertice;     
    }

    public void buscaEmLargura(){
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>> (); //marca cada ponto que o caminhao passar
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();// os vertices disponiveis para serem passados 
        Vertice<TIPO> atual = this.vertices.get(0); //o local de saida
        marcados.add(atual); //entao marca o vertice 
        System.out.println(atual.getDado()); //imprime o local de saida
        fila.add(atual); // os locais onde o caminhao ira passar
        while(fila.size()>0) { //ATENCAO TEM QUE CALCULAR A DISTANCIA E IR PECORRENDO EM ORDEM DECRESCENTE
            Vertice<TIPO> verticesCaminho =fila.get(0);
            for(int i=0; i < verticesCaminho.getArestaSaida().size(); i++){ //logica que passa por todas as arestas que estao no vértice
                Vertice<TIPO> pontosMapa = verticesCaminho.getArestaSaida().get(i) .getFim(); // é o fim da aresta
                if(!marcados.contains(verticesCaminho)){ //se o vertice nao foi marcado (passado)
                    marcados.add(verticesCaminho); //marca os vertices (o caminho)
                    System.out.println(verticesCaminho.getDado()); // imprime que foi marcado
                    fila.add(verticesCaminho); // fila de vertices que foram passados 
                }
            }
            fila.remove(0); //remove o caminho que passou (conferir se vale a pena permanecer)
            
        }
    }

    public void adicionarArestas(int i, String dadoInicio, String dadoFim) {
    }
}