package com.algaworks.algalog.algalogapi.controller;


import com.algaworks.algalog.algalogapi.dto.out.EntregaModel;
import com.algaworks.algalog.algalogapi.dto.input.EntregaInput;
import com.algaworks.algalog.algalogapi.mapper.EntregaMapper;
import com.algaworks.algalog.algalogapi.model.Entrega;
import com.algaworks.algalog.algalogapi.repository.EntregaRepository;
import com.algaworks.algalog.algalogapi.services.EntregaService;
import com.algaworks.algalog.algalogapi.services.FinalizacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private EntregaService entregaService;
    private EntregaMapper entregaMapper;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaMapper.toEntity(entregaInput);

        Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
        return entregaMapper.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaModel> listar(){
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable  Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }
}


