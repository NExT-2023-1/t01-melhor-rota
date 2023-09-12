package Cesar.Rotas.Caminhao.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cesar.Rotas.Caminhao.demo.dto.CaminhaoDto;
import Cesar.Rotas.Caminhao.demo.model.caminhao.Caminhao;
import Cesar.Rotas.Caminhao.demo.repositories.CaminhaoRepositorio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CaminhaoService {
    // listAllok,createok,updateok,deleteok,validationStatusTruck,validationLocationTruck
    private final CaminhaoRepositorio caminhaoRepositorio;

    public Caminhao create(CaminhaoDto caminhaoDTO) {
        Caminhao caminhao = caminhaoDTO.toEntity();
        return this.caminhaoRepositorio.save(caminhao);

    }

    public List<Caminhao> listAll() {
        List<Caminhao> caminhao = caminhaoRepositorio.findAll();
        return caminhao.stream()
                .collect(Collectors.toList());
    }

    public Caminhao update(long id, @Valid CaminhaoDto caminhaoDTO) {
        Caminhao caminhao = this.caminhaoRepositorio.findById(id).orElse(null);
        if (caminhao != null) {
            Caminhao updateCaminhao = caminhaoDTO.toEntity();
            return this.caminhaoRepositorio.save(updateCaminhao);
        }
        return null;
    }

    public boolean delete(long id) {
        Caminhao caminhao = this.caminhaoRepositorio.findById(id).orElse(null);
        if (caminhao != null) {
            this.caminhaoRepositorio.delete(caminhao);
            return true;
        }
        return false;

    }
    // função para checagem do status do caminhão.
    // recebe como parÂmetro o ID do caminhão
    public boolean checkStatusCaminhao(long id) {
        // busca no banco o caminhão pelo ID
        Caminhao caminhao = this.caminhaoRepositorio.findById(id).orElse(null);
        // valida se o caminhão existe
        if (caminhao != null) {
            // retorna o status da carga: true or false
            return caminhao.isStatus();
        }

        return false;
    }

    public String checkLocationCaminhao(long id){
        Caminhao caminhao = this.caminhaoRepositorio.findById(id).orElse(null);
        if (caminhao != null) {
            return caminhao.getLocation();
        } else {
            return "Caminhão não encontrado";
    }
}
    public String getRoute(long id, @Valid CaminhaoDto caminhaoDTO) {
        Caminhao caminhao = this.caminhaoRepositorio.findById(id).orElse(null);
        if (caminhao != null) {
            return Caminhao.getRoute;
        }
            return null;
}
}