package br.com.mecaniQA.api.dto;

import br.com.mecaniQA.api.model.StatusOrdemServico;

public class OrdemServicoResponseDTO {
    private Long id;
    private String descricao;
    private String cliente;
    private String veiculo;
    private StatusOrdemServico status;

    public OrdemServicoResponseDTO() {}

    public OrdemServicoResponseDTO(Long id, String descricao, String cliente, String veiculo, StatusOrdemServico status) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getVeiculo() { return veiculo; }
    public void setVeiculo(String veiculo) { this.veiculo = veiculo; }

    public StatusOrdemServico getStatus() { return status; }
    public void setStatus(StatusOrdemServico status) { this.status = status; }
}