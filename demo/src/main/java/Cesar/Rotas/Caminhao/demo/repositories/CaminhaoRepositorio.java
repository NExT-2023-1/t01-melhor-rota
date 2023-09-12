package Cesar.Rotas.Caminhao.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Cesar.Rotas.Caminhao.demo.model.caminhao.Caminhao;

public interface CaminhaoRepositorio extends JpaRepository<Caminhao,Long>{
    
}
