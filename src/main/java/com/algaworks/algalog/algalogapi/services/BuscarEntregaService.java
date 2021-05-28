package com.algaworks.algalog.algalogapi.services;

import com.algaworks.algalog.algalogapi.exception.ClienteException;
import com.algaworks.algalog.algalogapi.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.algalogapi.model.Entrega;
import com.algaworks.algalog.algalogapi.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
