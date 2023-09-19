package Cesar.Rotas.Caminhao.demo.service;

import java.io.IOException;
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

    public List<Truck> listAll() {
        List<Truck> truck = truckRepositorio.findAll();
        return truck.stream()
                .collect(Collectors.toList());
    }

    public Truck update(long id, @Valid TruckDto truckDTO) {
        Truck truck = this.truckRepositorio.findById(id).orElse(null);
        if (truck != null) {
            Truck updateTruck = truckDTO.toEntity();
            return this.truckRepositorio.save(updateTruck);
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
//mudar metodo 
    public List<String> getRoute(long id) {
        try {
            Grafo dijskstra;
            dijskstra = new Grafo("mapeamento_mapa_mina.txt");
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
            return rota;
        }else{
            for (EnumCarregar verticeDestino : EnumCarregar.values()){
                ResultadoDijkstra resultado= dijskstra.encontrarCaminhoMaisCurto(verticeOrigem, verticeDestino.toString());
                if(resultado.getDistanciaMinima()<menorValor){
                    menorValor=resultado.getDistanciaMinima();
                    rota=resultado.getCaminho();
                }
            }
            return rota;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}