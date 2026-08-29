package br.com.mecaniQA.api.repository;

import br.com.mecaniQA.api.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {

    private static ServicoRepository instancia;

    private final List<Servico> servicos;

    private Long proximoId = 1L;

    private ServicoRepository() {
        servicos = new ArrayList<>();
    }

    public static ServicoRepository getInstance() {

        if (instancia == null) {
            instancia = new ServicoRepository();
        }

        return instancia;
    }

    public Servico salvar(Servico servico) {

        servico.setId(proximoId++);

        servicos.add(servico);

        return servico;
    }

    public List<Servico> listar() {
        return new ArrayList<>(servicos);
    }

    public Servico buscarPorId(Long id) {

        for (Servico servico : servicos) {

            if (servico.getId().equals(id)) {
                return servico;
            }
        }

        return null;
    }

    public Servico atualizar(Long id, Servico dados) {

        Servico servico = buscarPorId(id);

        if (servico == null) {
            return null;
        }

        servico.setNome(dados.getNome());
        servico.setTempoEstimadoMinutos(dados.getTempoEstimadoMinutos());
        servico.setCustoTabelado(dados.getCustoTabelado());

        return servico;
    }

    public boolean excluir(Long id) {

        Servico servico = buscarPorId(id);

        if (servico == null) {
            return false;
        }

        servicos.remove(servico);

        return true;
    }
}