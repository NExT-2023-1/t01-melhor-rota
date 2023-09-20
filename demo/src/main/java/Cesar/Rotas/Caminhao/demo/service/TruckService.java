package Cesar.Rotas.Caminhao.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cesar.Rotas.Caminhao.demo.dto.TruckDto;
import Cesar.Rotas.Caminhao.demo.model.grafo.Grafo;
import Cesar.Rotas.Caminhao.demo.model.grafo.ResultadoDijkstra;
import Cesar.Rotas.Caminhao.demo.model.truck.Truck;
import Cesar.Rotas.Caminhao.demo.repositories.TruckRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TruckService {
    private final TruckRepository truckRepositorio;

    public Truck create(TruckDto truckDTO) {
        Truck truck = truckDTO.toEntity();
        return this.truckRepositorio.save(truck);

    }
    public Truck getById(long id) {
        return this.truckRepositorio.findById(id).orElse(null);
    }
    public List<Truck> listAll() {
        List<Truck> truck = truckRepositorio.findAll();
        return truck.stream()
                .collect(Collectors.toList());
    }

    public Truck update(long id, @Valid TruckDto truckDTO) {
        Truck updatableTruck = this.truckRepositorio.findById(id).orElse(null);
        if (updatableTruck != null) {
            updatableTruck.setLocation(truckDTO.getLocation());
            updatableTruck.setStatus(truckDTO.getStatus());
            return this.truckRepositorio.save(updatableTruck);
        }
        return null;
    }

    public boolean delete(long id) {
        Truck truck = this.truckRepositorio.findById(id).orElse(null);
        if (truck != null) {
            this.truckRepositorio.delete(truck);
            return true;
        }
        return false;

    }
    // função para checagem do status do caminhão.
    // recebe como parÂmetro o ID do caminhão
    public boolean checkStatusTruck(long id) {
        // busca no banco o caminhão pelo ID
        Truck truck = this.truckRepositorio.findById(id).orElse(null);
        // valida se o caminhão existe
        if (truck != null) {
            // retorna o status da carga: true or false
            return truck.isStatus();
        }

        return false;
    }

    public String checkLocationTruck(long id){
        Truck truck = this.truckRepositorio.findById(id).orElse(null);
        if (truck != null) {
            return truck.getLocation();
        } else {
            return "Caminhão não encontrado";
    }
}
    /**
     * @param id
     * @return
     */
    public List<String> getRoute(long id) {
        try {
            Grafo dijskstra;
            dijskstra = new Grafo("demo\\src\\main\\resources\\mapeamento_mapa_mina.txt");
            Truck truck = this.truckRepositorio.findById(id).orElse(null);
        int menorValor = Integer.MAX_VALUE;
        String verticeOrigem=truck.getLocation();
        List<String> rota=null;
        if (truck.isStatus()){
            for (EnumDescarga verticeDestino : EnumDescarga.values()){
                ResultadoDijkstra resultado= dijskstra.encontrarCaminhoMaisCurto(verticeOrigem, verticeDestino.toString());
                if(resultado.getDistanciaMinima()<menorValor){
                    menorValor=resultado.getDistanciaMinima();
                    rota=resultado.getCaminho();
                }
            };
            String menorValorString = Integer.toString(menorValor);
            List<String>listaMenorValor=new ArrayList<>();
            listaMenorValor.add(menorValorString);
            listaMenorValor.addAll(rota);
            return listaMenorValor;
        }else{
            for (EnumCarregar verticeDestino : EnumCarregar.values()){
                ResultadoDijkstra resultado= dijskstra.encontrarCaminhoMaisCurto(verticeOrigem, verticeDestino.toString());
                if(resultado.getDistanciaMinima()<menorValor){
                    menorValor=resultado.getDistanciaMinima();
                    rota=resultado.getCaminho();
                }
            }
            String menorValorString = Integer.toString(menorValor);
            List<String>listaMenorValor=new ArrayList<>();
            listaMenorValor.add(menorValorString);
            listaMenorValor.addAll(rota);
            return listaMenorValor;

  
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}