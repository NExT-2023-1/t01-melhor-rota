package Cesar.Rotas.Caminhao.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import Cesar.Rotas.Caminhao.demo.dto.CaminhaoDto;
import Cesar.Rotas.Caminhao.demo.model.caminhao.Caminhao;
import Cesar.Rotas.Caminhao.demo.service.CaminhaoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/caminhao")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CaminhaoController {
    private final CaminhaoService caminhaoService;

    @GetMapping
    public ResponseEntity<List<Caminhao>> ListAll(){
        List<Caminhao> listCaminhao=this.caminhaoService.listAll();
        return new ResponseEntity<>(listCaminhao, HttpStatus.OK);
    }
    public ResponseEntity<Caminhao> create(@RequestBody @Valid CaminhaoDto caminhaoDTO) {
        Caminhao caminhao = caminhaoService.create(caminhaoDTO);
        return new ResponseEntity<>(caminhao, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Caminhao> Atualizar(@PathVariable long id, @RequestBody @Valid CaminhaoDto caminhaoDto){
        Caminhao listCaminhao=this.caminhaoService.update(id,caminhaoDto);
        if(listCaminhao!=null){
            return new ResponseEntity<>(listCaminhao,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>Deletar(@PathVariable long id){
        if(CaminhaoService.delete(id)){
         return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}