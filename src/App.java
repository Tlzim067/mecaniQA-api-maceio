import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Peca> pecas;
    private List<Servico> servicos;

    public App() {
        pecas = new ArrayList<>();
        servicos = new ArrayList<>();
    }

    public void cadastrarPeca(Peca peca) {
        pecas.add(peca);
    }

    public void cadastrarServico(Servico servico) {
        servicos.add(servico);
    }

    public Peca buscarPeca(int id) {

        for (Peca peca : pecas) {
            if (peca.getId() == id) {
                return peca;
            }
        }

        return null;
    }

    public Servico buscarServico(int id) {

        for (Servico servico : servicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }

        return null;
    }

    public void listarPecas() {

        System.out.println("\n===== PECAS CADASTRADAS =====");

        if (pecas.isEmpty()) {
            System.out.println("Nenhuma peca cadastrada.");
            return;
        }

        for (Peca peca : pecas) {
            System.out.println(peca);
        }
    }

    public void listarServicos() {

        System.out.println("\n===== SERVICOS CADASTRADOS =====");

        if (servicos.isEmpty()) {
            System.out.println("Nenhum servico cadastrado.");
            return;
        }

        for (Servico servico : servicos) {
            System.out.println(servico);
        }
    }
}