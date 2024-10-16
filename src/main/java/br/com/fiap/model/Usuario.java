package br.com.fiap.model;

import java.util.Date;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;
    private Date dataCriacao;

    // Construtor sem parâmetros (padrão)
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(int idUsuario, String nome, String email, String cpf, Date dataNascimento, Date dataCriacao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
