package br.com.mecaniQA.api.model;

import java.util.ArrayList;
import java.util.List;

public class PedidoPecas {
    private Long id;
    private String observacao;
    private StatusPedidoPecas status;
    private List<ItemPedido> itens = new ArrayList<>();

    public PedidoPecas() {}

    public PedidoPecas(Long id, String observacao, StatusPedidoPecas status) {
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

    public List<ItemPedido> getItens() { return itens; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }
}