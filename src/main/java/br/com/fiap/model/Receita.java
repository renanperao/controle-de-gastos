package br.com.fiap.model;

public class Receita {
    private int idTransacao;
    private String origemReceita;

    // Construtor
    public Receita(int idTransacao, String origemReceita) {
        this.idTransacao = idTransacao;
        this.origemReceita = origemReceita;
    }

    // Getters
    public int getIdTransacao() {
        return idTransacao;
    }

    public String getOrigemReceita() {
        return origemReceita;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "idTransacao=" + idTransacao +
                ", origemReceita='" + origemReceita + '\'' +
                '}';
    }
}
