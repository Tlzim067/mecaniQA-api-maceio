package br.com.mecaniQA.api.model;

public class OrdemServico {
    private Long id;
    private String descricao;
    private String cliente;
    private String veiculo;
    private StatusOrdemServico status;

    private OrdemServico(OrdemServicoBuilder builder) {
        this.id = builder.id;
        this.descricao = builder.descricao;
        this.cliente = builder.cliente;
        this.veiculo = builder.veiculo;
        this.status = builder.status;
    }

    public OrdemServico(Object object, String descricao2, String cliente2, String veiculo2, StatusOrdemServico aberta) {
        //TODO Auto-generated constructor stub
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

    // Implementação do Padrão Builder
    public static class OrdemServicoBuilder {
        private Long id;
        private String descricao;
        private String cliente;
        private String veiculo;
        private StatusOrdemServico status;

        public OrdemServicoBuilder id(Long id) {
            this.id = id;
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

    public Object getCodigo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCodigo'");
    }

    public void setCodigo(long andIncrement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCodigo'");
    }
}