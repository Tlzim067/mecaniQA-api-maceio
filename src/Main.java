public class Main {

    public static void main(String[] args) {

        Peca peca = new Peca(
                1L,
                "Filtro de Óleo",
                "7891234567890",
                "Bosch",
                CategoriaPeca.MOTOR,
                10,
                25.50,
                49.90
        );

        System.out.println(peca);

        if (peca.getCategoria() != null) {
            System.out.println("Categoria válida: " + peca.getCategoria());
        }

        Servico servico = new Servico(
                101L,
                "Troca de Óleo",
                30,
                120.00
        );

        System.out.println(servico);
    }
}