package br.com.fiap.dao;

import br.com.fiap.model.UsuarioAdmin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAdminDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void insert(UsuarioAdmin admin) {
        String sql = "INSERT INTO USUARIO_ADMIN (id_usuario, nivel_acesso) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, admin.getIdUsuario());
            statement.setString(2, admin.getNivelAcesso());
            statement.executeUpdate();
            System.out.println("Usuário Admin inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário admin:");
            e.printStackTrace();
        }
    }

    public List<UsuarioAdmin> getAll() {
        List<UsuarioAdmin> admins = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO_ADMIN";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                UsuarioAdmin admin = new UsuarioAdmin();
                admin.setIdUsuario(resultSet.getInt("id_usuario"));
                admin.setNivelAcesso(resultSet.getString("nivel_acesso"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter usuários admin:");
            e.printStackTrace();
        }
        return admins;
    }
}
