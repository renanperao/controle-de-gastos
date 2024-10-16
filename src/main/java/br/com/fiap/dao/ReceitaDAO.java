package br.com.fiap.dao;

import br.com.fiap.model.Receita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void insert(Receita receita) {
        String sql = "INSERT INTO RECEITA (id_transacao, origem_receita) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, receita.getIdTransacao());
            statement.setString(2, receita.getOrigemReceita());
            statement.executeUpdate();
            System.out.println("Receita inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir receita:");
            e.printStackTrace();
        }
    }

    public List<Receita> getAll() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT id_transacao, origem_receita FROM RECEITA";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int idTransacao = resultSet.getInt("id_transacao");
                String origemReceita = resultSet.getString("origem_receita");
                receitas.add(new Receita(idTransacao, origemReceita));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar receitas:");
            e.printStackTrace();
        }
        return receitas;
    }
}
