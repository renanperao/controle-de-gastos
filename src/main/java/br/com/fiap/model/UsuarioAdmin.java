package br.com.fiap.model;

public class UsuarioAdmin {
    private int idUsuario;
    private String nivelAcesso;

    // Construtor sem parâmetros (padrão)
    public UsuarioAdmin() {}

    // Construtor com parâmetros
    public UsuarioAdmin(int idUsuario, String nivelAcesso) {
        this.idUsuario = idUsuario;
        this.nivelAcesso = nivelAcesso;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "UsuarioAdmin{" +
                "idUsuario=" + idUsuario +
                ", nivelAcesso='" + nivelAcesso + '\'' +
                '}';
    }
}
