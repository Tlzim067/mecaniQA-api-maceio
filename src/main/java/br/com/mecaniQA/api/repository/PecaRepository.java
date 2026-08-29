package br.com.mecaniQA.api.repository;

import br.com.mecaniQA.api.model.Peca;

import java.util.ArrayList;
import java.util.List;

public class PecaRepository {

    private static PecaRepository instancia;

    private final List<Peca> pecas;

    private Long proximoId = 1L;

    private PecaRepository() {
        pecas = new ArrayList<>();
    }

    public static PecaRepository getInstance() {
        if (instancia == null) {
            instancia = new PecaRepository();
        }

        return instancia;
    }

    public Peca salvar(Peca peca) {

        peca.setId(proximoId++);

        pecas.add(peca);

        return peca;
    }

    public List<Peca> listar() {
        return new ArrayList<>(pecas);
    }

    public Peca buscarPorId(Long id) {

        for (Peca peca : pecas) {

            if (peca.getId().equals(id)) {
                return peca;
            }
        }

        return null;
    }

    public Peca atualizar(Long id, Peca dados) {

        Peca peca = buscarPorId(id);

        if (peca == null) {
            return null;
        }

        peca.setCodigoBarras(dados.getCodigoBarras());
        peca.setFornecedor(dados.getFornecedor());
        peca.setQuantidadeEstoque(dados.getQuantidadeEstoque());
        peca.setPrecoCusto(dados.getPrecoCusto());
        peca.setPrecoVenda(dados.getPrecoVenda());
        peca.setTamanho(dados.getTamanho());
        peca.setCor(dados.getCor());
        peca.setCategoria(dados.getCategoria());

        return peca;
    }

    public boolean excluir(Long id) {

        Peca peca = buscarPorId(id);

        if (peca == null) {
            return false;
        }

        pecas.remove(peca);

        return true;
    }
}