package br.com.fiap.model;

import java.util.Date;

public class TransacaoFinanceira {
    private int idTransacao;
    private int idUsuario;
    private double valor;
    private Date dataTransacao;
    private String descricao;

    // Construtor sem parâmetros (padrão)
    public TransacaoFinanceira() {}

    // Construtor com parâmetros
    public TransacaoFinanceira(int idTransacao, int idUsuario, double valor, Date dataTransacao, String descricao) {
        this.idTransacao = idTransacao;
        this.idUsuario = idUsuario;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TransacaoFinanceira{" +
                "idTransacao=" + idTransacao +
                ", idUsuario=" + idUsuario +
                ", valor=" + valor +
                ", dataTransacao=" + dataTransacao +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
