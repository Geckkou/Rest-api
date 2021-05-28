package com.algaworks.algalog.algalogapi.services;

import com.algaworks.algalog.algalogapi.model.Cliente;
import com.algaworks.algalog.algalogapi.model.Entrega;
import com.algaworks.algalog.algalogapi.model.StatusEntrega;
import com.algaworks.algalog.algalogapi.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private ClienteService clienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}
