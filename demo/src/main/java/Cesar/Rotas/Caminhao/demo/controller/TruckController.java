package Cesar.Rotas.Caminhao.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import Cesar.Rotas.Caminhao.demo.dto.TruckDto;
import Cesar.Rotas.Caminhao.demo.model.truck.Truck;
import Cesar.Rotas.Caminhao.demo.service.TruckService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/truck")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TruckController {
    private final TruckService truckService;

    @GetMapping
    public ResponseEntity<List<Truck>> ListAll(){
        List<Truck> listTruck=this.truckService.listAll();
        return new ResponseEntity<>(listTruck, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Truck> create(@RequestBody @Valid TruckDto truckDTO) {
        Truck truck = truckService.create(truckDTO);
        return new ResponseEntity<>(truck, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Truck> Atualizar(@PathVariable long id, @RequestBody @Valid TruckDto truckDto){
        Truck listTruck=this.truckService.update(id,truckDto);
        if(listTruck!=null){
            return new ResponseEntity<>(listTruck,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>Deletar(@PathVariable long id){
        if(truckService.delete(id)){
         return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

