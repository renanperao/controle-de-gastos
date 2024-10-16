package br.com.fiap.model;

public class UsuarioCliente {
    private int idUsuario;
    private double limiteCredito;

    // Construtor sem parâmetros (padrão)
    public UsuarioCliente() {}

    // Construtor com parâmetros
    public UsuarioCliente(int idUsuario, double limiteCredito) {
        this.idUsuario = idUsuario;
        this.limiteCredito = limiteCredito;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        return "UsuarioCliente{" +
                "idUsuario=" + idUsuario +
                ", limiteCredito=" + limiteCredito +
                '}';
    }
}
