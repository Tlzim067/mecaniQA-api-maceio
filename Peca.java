package br.com.mecaniqa.estoque;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Peca {
    private Long codigo;
    private String nome;
    private String codigoBarras;
    private String fornecedorMarca;
    private CategoriaPeca categoria;
    private int quantidadeEstoque;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUltimaAtualizacao;
    private String tamanho;
    private String cor;

    public Peca(String nome,
                String codigoBarras,
                String fornecedorMarca,
                CategoriaPeca categoria,
                int quantidadeEstoque,
                BigDecimal precoCusto,
                BigDecimal precoVenda) {
        validarNome(nome);
        validarCodigoBarras(codigoBarras);
        validarCategoria(categoria);
        validarEstoque(quantidadeEstoque);
        validarPreco(precoCusto, "Preço de custo");
        validarPreco(precoVenda, "Preço de venda");

        this.nome = nome.trim();
        this.codigoBarras = codigoBarras.trim();
        this.fornecedorMarca = normalizar(fornecedorMarca);
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = arredondar(precoCusto);
        this.precoVenda = arredondar(precoVenda);

        LocalDateTime agora = LocalDateTime.now();
        this.dataCadastro = agora;
        this.dataUltimaAtualizacao = agora;
    }

    public static Peca reconstituir(Long codigo,
                                    String nome,
                                    String codigoBarras,
                                    String fornecedorMarca,
                                    CategoriaPeca categoria,
                                    int quantidadeEstoque,
                                    BigDecimal precoCusto,
                                    BigDecimal precoVenda,
                                    String tamanho,
                                    String cor,
                                    LocalDateTime dataCadastro,
                                    LocalDateTime dataUltimaAtualizacao) {
        Peca peca = new Peca(nome, codigoBarras, fornecedorMarca, categoria,
                quantidadeEstoque, precoCusto, precoVenda);
        peca.codigo = codigo;
        peca.tamanho = tamanho;
        peca.cor = cor;
        peca.dataCadastro = dataCadastro;
        peca.dataUltimaAtualizacao = dataUltimaAtualizacao;
        return peca;
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

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public BigDecimal getPrecoVenda() {
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

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome.trim();
        atualizarData();
    }

    public void setCodigoBarras(String codigoBarras) {
        validarCodigoBarras(codigoBarras);
        this.codigoBarras = codigoBarras.trim();
        atualizarData();
    }

    public void setFornecedorMarca(String fornecedorMarca) {
        this.fornecedorMarca = normalizar(fornecedorMarca);
        atualizarData();
    }

    public void setCategoria(CategoriaPeca categoria) {
        validarCategoria(categoria);
        this.categoria = categoria;
        atualizarData();
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        validarEstoque(quantidadeEstoque);
        this.quantidadeEstoque = quantidadeEstoque;
        atualizarData();
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        validarPreco(precoCusto, "Preço de custo");
        this.precoCusto = arredondar(precoCusto);
        atualizarData();
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        validarPreco(precoVenda, "Preço de venda");
        this.precoVenda = arredondar(precoVenda);
        atualizarData();
    }

    public void setTamanho(String tamanho) {
        this.tamanho = normalizar(tamanho);
        atualizarData();
    }

    public void setCor(String cor) {
        this.cor = normalizar(cor);
        atualizarData();
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de entrada deve ser maior que zero");
        }
        this.quantidadeEstoque = Math.addExact(this.quantidadeEstoque, quantidade);
        atualizarData();
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de saída deve ser maior que zero");
        }
        if (quantidade > this.quantidadeEstoque) {
            throw new IllegalStateException(
                    "Estoque insuficiente: disponível " + this.quantidadeEstoque
                            + ", solicitado " + quantidade);
        }
        this.quantidadeEstoque -= quantidade;
        atualizarData();
    }

    private static void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    private static void validarCodigoBarras(String codigoBarras) {
        if (codigoBarras == null || codigoBarras.isBlank()) {
            throw new IllegalArgumentException("Código de barras não pode ser vazio");
        }
    }

    private static void validarCategoria(CategoriaPeca categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria é obrigatória");
        }
    }

    private static void validarEstoque(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
    }

    private static void validarPreco(BigDecimal preco, String campo) {
        if (preco == null) {
            throw new IllegalArgumentException(campo + " é obrigatório");
        }
        if (preco.signum() < 0) {
            throw new IllegalArgumentException(campo + " não pode ser negativo");
        }
    }

    private static String normalizar(String valor) {
        if (valor == null) {
            return null;
        }
        String limpo = valor.trim();
        return limpo.isEmpty() ? null : limpo;
    }

    private static BigDecimal arredondar(BigDecimal valor) {
        return valor.setScale(2, RoundingMode.HALF_UP);
    }

    private void atualizarData() {
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Peca)) return false;
        Peca outra = (Peca) o;
        return codigo != null && codigo.equals(outra.codigo);
    }

    @Override
    public int hashCode() {
        return Peca.class.hashCode();
    }

    @Override
    public String toString() {
        return "Peca{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", categoria=" + categoria +
                ", estoque=" + quantidadeEstoque +
                ", precoVenda=" + precoVenda +
                '}';
    }
}
