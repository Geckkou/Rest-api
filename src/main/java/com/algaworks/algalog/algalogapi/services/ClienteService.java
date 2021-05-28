package com.algaworks.algalog.algalogapi.services;

import com.algaworks.algalog.algalogapi.exception.ClienteException;
import com.algaworks.algalog.algalogapi.model.Cliente;
import com.algaworks.algalog.algalogapi.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
       boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
               .stream()
               .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

       if(emailEmUso){
           throw new ClienteException("Email já cadastrado");
       }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
