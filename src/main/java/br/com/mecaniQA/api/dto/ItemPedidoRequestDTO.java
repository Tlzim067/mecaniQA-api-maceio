package br.com.mecaniQA.api.dto;

public class ItemPedidoRequestDTO {
    private Long pecaId;
    private Integer quantidade;

    public ItemPedidoRequestDTO() {}

    public Long getPecaId() { return pecaId; }
    public void setPecaId(Long pecaId) { this.pecaId = pecaId; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}