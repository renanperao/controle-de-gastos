package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM559119";
    private static final String PASSWORD = "230505";

    public void testConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados:");
            e.printStackTrace();
        }
    }

    public void insert(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (id_usuario, nome, email, cpf, data_nascimento, data_criacao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuario.getIdUsuario());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getCpf());
            statement.setDate(5, new java.sql.Date(usuario.getDataNascimento().getTime()));
            statement.setDate(6, new java.sql.Date(usuario.getDataCriacao().getTime()));
            statement.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário:");
            e.printStackTrace();
        }
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
                usuario.setDataCriacao(resultSet.getDate("data_criacao"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter usuários:");
            e.printStackTrace();
        }
        return usuarios;
    }
}
