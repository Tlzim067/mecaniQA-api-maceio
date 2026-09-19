package br.com.mecaniQA.api.model;

public class OrdemServico {
    private Long codigo;
    private String descricao;
    private String cliente;
    private String veiculo;
    private StatusOrdemServico status;

    public OrdemServico() {
    }

    public OrdemServico(Long codigo, String descricao, String cliente, String veiculo, StatusOrdemServico status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.status = status;
    }

    private OrdemServico(OrdemServicoBuilder builder) {
        this.codigo = builder.codigo;
        this.descricao = builder.descricao;
        this.cliente = builder.cliente;
        this.veiculo = builder.veiculo;
        this.status = builder.status;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    // Método estático para iniciar o Builder
    public static OrdemServicoBuilder builder() {
        return new OrdemServicoBuilder();
    }

    // Padrão Builder
    public static class OrdemServicoBuilder {
        private Long codigo;
        private String descricao;
        private String cliente;
        private String veiculo;
        private StatusOrdemServico status;

        public OrdemServicoBuilder codigo(Long codigo) {
            this.codigo = codigo;
            return this;
        }

        public OrdemServicoBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public OrdemServicoBuilder cliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public OrdemServicoBuilder veiculo(String veiculo) {
            this.veiculo = veiculo;
            return this;
        }

        public OrdemServicoBuilder status(StatusOrdemServico status) {
            this.status = status;
            return this;
        }

        public OrdemServico build() {
            return new OrdemServico(this);
        }
    }
}