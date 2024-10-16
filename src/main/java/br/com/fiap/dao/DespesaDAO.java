package br.com.fiap.dao;

import br.com.fiap.model.Despesa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void insert(Despesa despesa) {
        String sql = "INSERT INTO DESPESA (id_transacao, categoria_despesa, data_pagamento) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, despesa.getIdTransacao());
            statement.setString(2, despesa.getCategoriaDespesa());
            statement.setDate(3, new java.sql.Date(despesa.getDataPagamento().getTime()));
            statement.executeUpdate();
            System.out.println("Despesa inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir despesa:");
            e.printStackTrace();
        }
    }

    public List<Despesa> getAll() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT id_transacao, categoria_despesa, data_pagamento FROM DESPESA";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idTransacao = resultSet.getInt("id_transacao");
                String categoriaDespesa = resultSet.getString("categoria_despesa");
                Date dataPagamento = resultSet.getDate("data_pagamento");
                despesas.add(new Despesa(idTransacao, categoriaDespesa, dataPagamento));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar despesas:");
            e.printStackTrace();
        }
        return despesas;
    }
}
