package com.algaworks.algalog.algalogapi.services;

import com.algaworks.algalog.algalogapi.exception.ClienteException;
import com.algaworks.algalog.algalogapi.model.Entrega;
import com.algaworks.algalog.algalogapi.model.Ocorrencia;
import com.algaworks.algalog.algalogapi.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    BuscarEntregaService buscarEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscarEntregaService.buscar(entregaId);

       return  entrega.adicionarOcorrencia(descricao);
    }
}
