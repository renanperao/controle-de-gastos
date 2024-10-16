package br.com.fiap.model;

import java.util.Date;

public class Despesa {
    private int idTransacao;
    private String categoriaDespesa;
    private Date dataPagamento;

    // Construtor
    public Despesa(int idTransacao, String categoriaDespesa, Date dataPagamento) {
        this.idTransacao = idTransacao;
        this.categoriaDespesa = categoriaDespesa;
        this.dataPagamento = dataPagamento;
    }

    // Getters
    public int getIdTransacao() {
        return idTransacao;
    }

    public String getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "idTransacao=" + idTransacao +
                ", categoriaDespesa='" + categoriaDespesa + '\'' +
                ", dataPagamento=" + dataPagamento +
                '}';
    }
}
