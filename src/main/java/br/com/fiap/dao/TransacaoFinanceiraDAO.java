package br.com.fiap.dao;

import br.com.fiap.model.TransacaoFinanceira;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoFinanceiraDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void insert(TransacaoFinanceira transacao) {
        String sql = "INSERT INTO TRANSACAO_FINANCEIRA (id_transacao, id_usuario, valor, data_transacao, descricao) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transacao.getIdTransacao());
            statement.setInt(2, transacao.getIdUsuario());
            statement.setDouble(3, transacao.getValor());
            statement.setDate(4, new java.sql.Date(transacao.getDataTransacao().getTime()));
            statement.setString(5, transacao.getDescricao());
            statement.executeUpdate();
            System.out.println("Transação inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir transação:");
            e.printStackTrace();
        }
    }

    public List<TransacaoFinanceira> getAll() {
        List<TransacaoFinanceira> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM TRANSACAO_FINANCEIRA";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                TransacaoFinanceira transacao = new TransacaoFinanceira();
                transacao.setIdTransacao(resultSet.getInt("id_transacao"));
                transacao.setIdUsuario(resultSet.getInt("id_usuario"));
                transacao.setValor(resultSet.getDouble("valor"));
                transacao.setDataTransacao(resultSet.getDate("data_transacao"));
                transacao.setDescricao(resultSet.getString("descricao"));
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter transações financeiras:");
            e.printStackTrace();
        }
        return transacoes;
    }
}
