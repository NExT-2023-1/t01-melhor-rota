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
import Cesar.Rotas.Caminhao.demo.dto.CaminhaoDTO;
import Cesar.Rotas.Caminhao.demo.model.Caminhao;
import Cesar.Rotas.Caminhao.demo.service.CaminhaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/caminhao")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CaminhaoController {
    private final CaminhaoService caminhaoService;

    @GetMapping
    public ResponseEntity<List<Caminhao>> listAll() {
        List<Caminhao> listCaminhao = this.caminhaoService.listAll();
        return new ResponseEntity<>(listCaminhao, HttpStatus.OK);
    }

    // mapping da rota de checagem de status "/caminhao/status/{id}"
    @GetMapping("/status/{id}")
    public ResponseEntity<?
    > checkStatusCaminhao(@PathVariable long id) {
        // chama a função de checar status que retorna um boolean
        if (caminhaoService.checkStatusCaminhao(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Caminhao> create(@RequestBody @Valid CaminhaoDTO caminhaoDTO) {
        Caminhao caminhao = caminhaoService.create(caminhaoDTO);
        return new ResponseEntity<>(caminhao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caminhao> update(@PathVariable long id, @RequestBody @Valid CaminhaoDTO caminhaoDTO) {
        Caminhao listCaminhao = this.caminhaoService.update(id, caminhaoDTO);
        if (listCaminhao != null) {
            return new ResponseEntity<>(listCaminhao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if (caminhaoService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}