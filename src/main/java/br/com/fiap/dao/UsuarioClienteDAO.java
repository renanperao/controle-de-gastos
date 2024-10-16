package br.com.fiap.dao;

import br.com.fiap.model.UsuarioCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioClienteDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void insert(UsuarioCliente cliente) {
        String sql = "INSERT INTO USUARIO_CLIENTE (id_usuario, limite_credito) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cliente.getIdUsuario());
            statement.setDouble(2, cliente.getLimiteCredito());
            statement.executeUpdate();
            System.out.println("Usuário Cliente inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário cliente:");
            e.printStackTrace();
        }
    }

    public List<UsuarioCliente> getAll() {
        List<UsuarioCliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO_CLIENTE";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                UsuarioCliente cliente = new UsuarioCliente();
                cliente.setIdUsuario(resultSet.getInt("id_usuario"));
                cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter usuários clientes:");
            e.printStackTrace();
        }
        return clientes;
    }
}
