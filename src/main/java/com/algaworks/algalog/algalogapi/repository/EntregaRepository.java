package com.algaworks.algalog.algalogapi.repository;

import com.algaworks.algalog.algalogapi.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
