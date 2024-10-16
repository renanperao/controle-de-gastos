package br.com.fiap.dao;

import br.com.fiap.model.Investimento;
import java.sql.*;

public class InvestimentoDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void insert(Investimento investimento) {
        String sql = "INSERT INTO INVESTIMENTO (id_transacao, tipo_investimento, valor_atual) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, investimento.getIdTransacao());
            statement.setString(2, investimento.getTipoInvestimento());
            statement.setDouble(3, investimento.getValorAtual());
            statement.executeUpdate();
            System.out.println("Investimento inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir investimento:");
            e.printStackTrace();
        }
    }
}
