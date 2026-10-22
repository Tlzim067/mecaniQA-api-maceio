package br.com.mecaniQA.api.mapper;

import br.com.mecaniQA.api.model.Peca;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PecaMapper {
    public static Peca mapRow(ResultSet rs) throws SQLException {
        Peca peca = new Peca();
        // Ajuste os getters/setters conforme os atributos reais da sua classe Peca
        peca.setId(rs.getLong("id"));
        peca.setNome(rs.getString("nome"));
        peca.setCodigoBarras(rs.getString("codigo_barras"));
        peca.setFornecedor(rs.getString("fornecedor"));
        peca.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
        peca.setPrecoCusto(rs.getDouble("preco_custo"));
        peca.setPrecoVenda(rs.getDouble("preco_venda"));
        return peca;
    }
}