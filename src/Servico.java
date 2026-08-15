import java.time.LocalDateTime;

public class Servico {

    private Long codigo;
    private String nome;
    private int tempoEstimadoMinutos;
    private double custoTabelado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimaAtualizacao;

    public Servico(Long codigo,
                   String nome,
                   int tempoEstimadoMinutos,
                   double custoTabelado) {

        this.codigo = codigo;
        this.nome = nome;
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
        this.custoTabelado = custoTabelado;
        this.dataCriacao = LocalDateTime.now();
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoEstimadoMinutos() {
        return tempoEstimadoMinutos;
    }

    public double getCustoTabelado() {
        return custoTabelado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
        atualizarData();
    }

    public void setTempoEstimadoMinutos(int tempoEstimadoMinutos) {
        this.tempoEstimadoMinutos = tempoEstimadoMinutos;
        atualizarData();
    }

    public void setCustoTabelado(double custoTabelado) {
        this.custoTabelado = custoTabelado;
        atualizarData();
    }

    private void atualizarData() {
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", tempo=" + tempoEstimadoMinutos +
                " minutos}";
    }
}