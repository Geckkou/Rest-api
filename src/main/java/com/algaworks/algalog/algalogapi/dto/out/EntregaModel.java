package com.algaworks.algalog.algalogapi.dto.out;

import com.algaworks.algalog.algalogapi.dto.out.ClienteResumoModel;
import com.algaworks.algalog.algalogapi.dto.out.DestinatarioModel;
import com.algaworks.algalog.algalogapi.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaModel {

    private Long id;
    private ClienteResumoModel cliente;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
