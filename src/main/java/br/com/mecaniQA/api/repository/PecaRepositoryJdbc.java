package br.com.mecaniQA.api.repository;

import br.com.mecaniQA.api.mapper.PecaMapper;
import br.com.mecaniQA.api.model.Peca;

public class PecaRepositoryJdbc extends AbstractJdbcRepository {

    public Peca buscarPorId(Long id) {
        String sql = "SELECT * FROM peca WHERE id = ?";
        return executarConsultaUnica(
            sql,
            stmt -> stmt.setLong(1, id),
            rs -> PecaMapper.mapRow(rs)
        );
    }
}