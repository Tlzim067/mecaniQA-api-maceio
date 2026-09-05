package br.com.mecaniQA.api.repository;

import org.springframework.stereotype.Repository;

import br.com.mecaniQA.api.model.OrdemServico; // <-- CORRIGIDO (import do pacote model)

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrdemServicoRepository {
    private static final List<OrdemServico> tabela = new ArrayList<>();
    private static final AtomicLong idSequence = new AtomicLong(1);

    public OrdemServico salvar(OrdemServico os) {
        if (os.getCodigo() == null) {
            os.setCodigo(idSequence.getAndIncrement());
            tabela.add(os);
        } else {
            for (int i = 0; i < tabela.size(); i++) {
                if (tabela.get(i).getCodigo().equals(os.getCodigo())) {
                    tabela.set(i, os);
                    break;
                }
            }
        }
        return os;
    }

    public Optional<OrdemServico> buscarPorId(Long id) {
        return tabela.stream().filter(os -> os.getCodigo().equals(id)).findFirst();
    }

    public List<OrdemServico> listarTodos() {
        return new ArrayList<>(tabela);
    }
}