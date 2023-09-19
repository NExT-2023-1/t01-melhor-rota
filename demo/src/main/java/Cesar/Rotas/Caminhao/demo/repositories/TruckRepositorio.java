package Cesar.Rotas.Caminhao.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Cesar.Rotas.Caminhao.demo.model.truck.Truck;

public interface TruckRepositorio extends JpaRepository<Truck,Long>{
    
}
