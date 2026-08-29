package br.com.mecaniQA.api.model;

import java.time.LocalDateTime;

public class Servico {

    private Long id;
    private String nome;
    private int tempoEstimadoMinutos;
    private double custoTabelado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Servico() {
    }

    public Servico(
            Long id,
            String nome,
            int tempoEstimadoMinutos,
            double custoTabelado,
            LocalDateTime dataCriacao,
            LocalDateTime dataAtualizacao) {

        this.id = id;
        this.nome = nome;
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
        this.custoTabelado = custoTabelado;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoEstimadoMinutos() {
        return tempoEstimadoMinutos;
    }

    public void setTempoEstimadoMinutos(int tempoEstimadoMinutos) {
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
    }

    public double getCustoTabelado() {
        return custoTabelado;
    }

    public void setCustoTabelado(double custoTabelado) {
        this.custoTabelado = custoTabelado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}