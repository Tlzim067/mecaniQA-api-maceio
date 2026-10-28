package br.com.mecaniqa.estoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "pecas")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String codigoBarras;

    private String fornecedorMarca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaPeca categoria;

    @Column(nullable = false)
    private int quantidadeEstoque;

    @Column(nullable = false)
    private double precoCusto;

    @Column(nullable = false)
    private double precoVenda;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private LocalDateTime dataUltimaAtualizacao;

    private String tamanho;
    private String cor;

    protected Peca() {
    }

    public Peca(String nome,
                String codigoBarras,
                String fornecedorMarca,
                CategoriaPeca categoria,
                int quantidadeEstoque,
                double precoCusto,
                double precoVenda) {

        validarNome(nome);
        validarCodigoBarras(codigoBarras);
        validarCategoria(categoria);
        validarEstoque(quantidadeEstoque);
        validarPreco(precoCusto, "Preço de custo");
        validarPreco(precoVenda, "Preço de venda");

        this.nome = nome.trim();
        this.codigoBarras = codigoBarras.trim();
        this.fornecedorMarca = fornecedorMarca;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;

        LocalDateTime agora = LocalDateTime.now();
        this.dataCadastro = agora;
        this.dataUltimaAtualizacao = agora;
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
        this.fornecedorMarca = fornecedorMarca;
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

    public void setPrecoCusto(double precoCusto) {
        validarPreco(precoCusto, "Preço de custo");
        this.precoCusto = precoCusto;
        atualizarData();
    }

    public void setPrecoVenda(double precoVenda) {
        validarPreco(precoVenda, "Preço de venda");
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

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade de entrada deve ser maior que zero");
        }
        this.quantidadeEstoque += quantidade;
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

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    private void validarCodigoBarras(String codigoBarras) {
        if (codigoBarras == null || codigoBarras.isBlank()) {
            throw new IllegalArgumentException("Código de barras não pode ser vazio");
        }
    }

    private void validarCategoria(CategoriaPeca categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria é obrigatória");
        }
    }

    private void validarEstoque(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
    }

    private void validarPreco(double preco, String campo) {
        if (preco < 0) {
            throw new IllegalArgumentException(campo + " não pode ser negativo");
        }
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
