package br.com.mecaniQA.api.dto;

public class OrdemServicoRequestDTO {
    private String descricao;
    private String cliente;
    private String veiculo;

    public OrdemServicoRequestDTO() {}

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getVeiculo() { return veiculo; }
    public void setVeiculo(String veiculo) { this.veiculo = veiculo; }
}