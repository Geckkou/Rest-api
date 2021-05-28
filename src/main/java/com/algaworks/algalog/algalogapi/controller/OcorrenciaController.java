package com.algaworks.algalog.algalogapi.controller;

import com.algaworks.algalog.algalogapi.dto.input.OcorrenciaInput;
import com.algaworks.algalog.algalogapi.dto.out.OcorrenciaModel;
import com.algaworks.algalog.algalogapi.mapper.OcorrenciaMapper;
import com.algaworks.algalog.algalogapi.model.Entrega;
import com.algaworks.algalog.algalogapi.model.Ocorrencia;
import com.algaworks.algalog.algalogapi.services.BuscarEntregaService;
import com.algaworks.algalog.algalogapi.services.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private OcorrenciaService ocorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;
    private BuscarEntregaService buscarEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput){

       Ocorrencia ocorrenciaRegistrada = ocorrenciaService
               .registrar(entregaId,ocorrenciaInput.getDescricao());

       return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscarEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
    }
}
