package Cesar.Rotas.Caminhao.demo.Grafo;

public class App {
    public static void main(String[] args) {

        Grafo<String> grafo = new Grafo<String>();
        
        grafo.adicionarVertice("0 - Int1"); //adicao das arestas
        grafo.adicionarVertice("1 - Int2");
        grafo.adicionarVertice("2 - Int3");
        grafo.adicionarVertice("3 - Int4");
        grafo.adicionarVertice("4 - Int5");
        grafo.adicionarVertice("5 - Int6");
        grafo.adicionarVertice("6 - Int7");
        grafo.adicionarVertice("7 - Int8");
        grafo.adicionarVertice("8 - Int9");
        grafo.adicionarVertice("9 - Int10");
        grafo.adicionarVertice("10 - Int11");
        grafo.adicionarVertice("11 - Int12");

        grafo.adicionarVertice("12 - Desc1");
        grafo.adicionarVertice("13 - Desc2");
        grafo.adicionarVertice("14 - Desc3");
        
        grafo.adicionarVertice("15 - Esc1");
        grafo.adicionarVertice("16 - Esc2");
        grafo.adicionarVertice("17 - Esc3");

        grafo.adicionarArestas(200, "ESC1","INT4"); // distancias indo e voltando
        grafo.adicionarArestas(200, "INT4","ESC1");
        
        grafo.adicionarArestas(160, "ESC2","INT11");
        grafo.adicionarArestas(160, "INT11","ESC2");
        
        grafo.adicionarArestas(100, "ESC3","INT7");
        grafo.adicionarArestas(100, "INT7","ESC3");
        
        grafo.adicionarArestas(180, "DES1","INT1");
        grafo.adicionarArestas(180, "INT1","DES1");
        
        grafo.adicionarArestas(140, "DESC2","INT10");
        grafo.adicionarArestas(140, "INT10","DESC2");
        
        grafo.adicionarArestas(190, "DESC3","INT12");
        grafo.adicionarArestas(190, "INT12","DESC3");
        

        grafo.adicionarArestas(270, "INT1","INT2");
        grafo.adicionarArestas(270, "INT2","INT1");
        
        grafo.adicionarArestas(250, "INT2","INT3");
        grafo.adicionarArestas(250, "INT3","INT2");
        
        grafo.adicionarArestas(120, "INT3","INT4");
        grafo.adicionarArestas(120, "INT4","INT3");
        
        grafo.adicionarArestas(200, "INT4","INT5");
        grafo.adicionarArestas(200, "INT5","INT4");
        
        grafo.adicionarArestas(100, "INT5","INT6");
        grafo.adicionarArestas(100, "INT6","INT5");
        
        grafo.adicionarArestas(120, "INT6","INT7");
        grafo.adicionarArestas(120, "INT7","INT6");

        grafo.adicionarArestas(200, "INT1","INT3");
        grafo.adicionarArestas(200, "INT3","INT1");
        
        grafo.adicionarArestas(260, "INT2","INT8");
        grafo.adicionarArestas(260, "INT8","INT2");
     
        grafo.adicionarArestas(210, "INT7","INT8");
        grafo.adicionarArestas(210, "INT8","INT7");
        
        grafo.adicionarArestas(200, "INT7","INT13");
        grafo.adicionarArestas(200, "INT13","INT7");
        
        grafo.adicionarArestas(250, "INT8","INT9");
        grafo.adicionarArestas(250, "INT9","INT8");
        
        grafo.adicionarArestas(90, "INT9","INT13");
        grafo.adicionarArestas(90, "INT13","INT9");
        
        grafo.adicionarArestas(300, "INT12","INT13");
        grafo.adicionarArestas(300, "INT13","INT12");
        
        grafo.adicionarArestas(100, "INT9","INT10");
        grafo.adicionarArestas(100, "INT10","INT9");
        
        grafo.adicionarArestas(130, "INT9","INT11");
        grafo.adicionarArestas(130, "INT11","INT9");
        
        grafo.adicionarArestas(170, "INT12","INT11");
        grafo.adicionarArestas(170, "INT11","INT12");
        
        grafo.buscaEmLargura();

    }
}