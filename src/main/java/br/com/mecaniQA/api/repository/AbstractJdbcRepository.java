package br.com.mecaniQA.api.repository;

import br.com.mecaniQA.api.config.DatabaseConnection;
import java.sql.*;

public abstract class AbstractJdbcRepository {

    @FunctionalInterface
    public interface ParametrosSetter {
        void setParameters(PreparedStatement stmt) throws SQLException;
    }

    @FunctionalInterface
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    protected <T> T executarConsultaUnica(String sql, ParametrosSetter setter, ResultSetMapper<T> mapper) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            setter.setParameters(stmt);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapper.map(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar consulta JDBC: " + e.getMessage(), e);
        }
    }

    protected int executarAtualizacao(String sql, ParametrosSetter setter) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            setter.setParameters(stmt);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar comando SQL: " + e.getMessage(), e);
        }
    }
}