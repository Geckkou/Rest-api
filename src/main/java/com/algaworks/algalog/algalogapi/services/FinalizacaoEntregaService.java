package com.algaworks.algalog.algalogapi.services;

import com.algaworks.algalog.algalogapi.model.Entrega;
import com.algaworks.algalog.algalogapi.model.StatusEntrega;
import com.algaworks.algalog.algalogapi.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscarEntregaService buscarEntregaService;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscarEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
