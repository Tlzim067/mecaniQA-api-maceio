public class Main {

    public static void main(String[] args) {

        App sistema = new App();

        // =========================
        // CADASTRO DE PECAS
        // =========================

        Peca pastilhaFreio = new Peca(
                1,
                "Pastilha de Freio",
                CategoriaPeca.FREIO,
                150.00,
                10
        );

        Peca oleoMotor = new Peca(
                2,
                "Oleo de Motor",
                CategoriaPeca.MOTOR,
                45.00,
                20
        );

        Peca bateria = new Peca(
                3,
                "Bateria Automotiva",
                CategoriaPeca.ELETRICA,
                450.00,
                5
        );

        sistema.cadastrarPeca(pastilhaFreio);
        sistema.cadastrarPeca(oleoMotor);
        sistema.cadastrarPeca(bateria);

        // =========================
        // CADASTRO DE SERVICOS
        // =========================

        Servico trocaOleo = new Servico(
                1,
                "Troca de Oleo",
                "Troca de oleo e filtro do motor",
                80.00
        );

        Servico revisaoFreios = new Servico(
                2,
                "Revisao de Freios",
                "Inspecao e manutencao do sistema de freios",
                200.00
        );

        sistema.cadastrarServico(trocaOleo);
        sistema.cadastrarServico(revisaoFreios);

        // =========================
        // LISTAGEM
        // =========================

        sistema.listarPecas();
        sistema.listarServicos();

        // =========================
        // TESTE DE BUSCA
        // =========================

        System.out.println("\n===== BUSCA DE PECA =====");

        Peca pecaEncontrada = sistema.buscarPeca(1);

        if (pecaEncontrada != null) {
            System.out.println("Peca encontrada:");
            System.out.println(pecaEncontrada);
        } else {
            System.out.println("Peca nao encontrada.");
        }

        // =========================
        // TESTE DE ESTOQUE
        // =========================

        System.out.println("\n===== TESTE DE ESTOQUE =====");

        System.out.println(
                "Estoque antes: "
                        + pastilhaFreio.getQuantidadeEstoque()
        );

        boolean removido = pastilhaFreio.removerEstoque(2);

        if (removido) {
            System.out.println("2 unidades removidas com sucesso.");
        } else {
            System.out.println("Nao foi possivel remover as unidades.");
        }

        System.out.println(
                "Estoque depois: "
                        + pastilhaFreio.getQuantidadeEstoque()
        );

        // =========================
        // TESTE DE REGRA DE NEGOCIO
        // =========================

        System.out.println("\n===== TESTE DE ESTOQUE INSUFICIENTE =====");

        boolean tentativaInvalida = pastilhaFreio.removerEstoque(100);

        if (!tentativaInvalida) {
            System.out.println(
                    "Teste aprovado: nao e permitido remover "
                    + "mais unidades do que existem no estoque."
            );
        }
    }
}