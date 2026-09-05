package br.com.mecaniQA.api.dto;

import java.util.List;

import br.com.mecaniQA.api.model.StatusPedidoPecas;

public class PedidoPecasResponseDTO {
    private Long id;
    private String observacao; 
    private StatusPedidoPecas status;
    private List<ItemPedidoRequestDTO> itens;

    public PedidoPecasResponseDTO() {}

    public PedidoPecasResponseDTO(Long id, String observacao, StatusPedidoPecas status) {
        this.id = id;
        this.observacao = observacao;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public StatusPedidoPecas getStatus() { return status; }
    public void setStatus(StatusPedidoPecas status) { this.status = status; }
}
