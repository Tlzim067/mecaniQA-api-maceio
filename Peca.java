import java.time.LocalDateTime;

public class Peca {

    private Long codigo;
    private String nome;
    private String codigoBarras;
    private String fornecedorMarca;
    private CategoriaPeca categoria;
    private int quantidadeEstoque;
    private double precoCusto;
    private double precoVenda;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;

    // Atributos opcionais
    private String tamanho;
    private String cor;

    public Peca(Long codigo,
                String nome,
                String codigoBarras,
                String fornecedorMarca,
                CategoriaPeca categoria,
                int quantidadeEstoque,
                double precoCusto,
                double precoVenda) {

        this.codigo = codigo;
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.fornecedorMarca = fornecedorMarca;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataCadastro = LocalDateTime.now();
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getFornecedorMarca() {
        return fornecedorMarca;
    }

    public CategoriaPeca getCategoria() {
        return categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setNome(String nome) {
        this.nome = nome;
        atualizarData();
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
        atualizarData();
    }

    public void setFornecedorMarca(String fornecedorMarca) {
        this.fornecedorMarca = fornecedorMarca;
        atualizarData();
    }

    public void setCategoria(CategoriaPeca categoria) {
        this.categoria = categoria;
        atualizarData();
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        atualizarData();
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
        atualizarData();
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
        atualizarData();
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
        atualizarData();
    }

    public void setCor(String cor) {
        this.cor = cor;
        atualizarData();
    }

    private void atualizarData() {
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Peca{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                ", estoque=" + quantidadeEstoque +
                ", precoVenda=" + precoVenda +
                '}';
    }
}