package br.com.mecaniQA.api.model;

public class ItemPedido {
    private Long id;
    private Peca peca;  
    private int quantidade;
    private double precoUnitario;

    public ItemPedido() {}

    public ItemPedido(Long id, Peca peca, int quantidade, double precoUnitario) {
        this.id = id;
        this.peca = peca;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }public Peca getPeca() {
        return peca;
    }
    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
