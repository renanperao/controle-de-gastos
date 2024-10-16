package br.com.fiap;

import br.com.fiap.dao.*;
import br.com.fiap.model.*;
import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioAdminDAO usuarioAdminDAO = new UsuarioAdminDAO();
        UsuarioClienteDAO usuarioClienteDAO = new UsuarioClienteDAO();
        TransacaoFinanceiraDAO transacaoFinanceiraDAO = new TransacaoFinanceiraDAO();
        DespesaDAO despesaDAO = new DespesaDAO();
        ReceitaDAO receitaDAO = new ReceitaDAO();

        // Inserindo usuários
        for (int i = 1; i <= 5; i++) {
            Usuario usuario = new Usuario(i, "Usuario " + i, "usuario" + i + "@example.com", "1234567890", new Date(), new Date());
            usuarioDAO.insert(usuario);
        }

        // Verificando se os usuários foram inseridos
        System.out.println("Usuários cadastrados:");
        for (Usuario usuario : usuarioDAO.getAll()) {
            System.out.println(usuario);
        }

        // Inserindo usuários admin
        for (int i = 1; i <= 5; i++) {
            UsuarioAdmin admin = new UsuarioAdmin(i, "Nivel " + i);
            usuarioAdminDAO.insert(admin);
        }

        // Verificando se os usuários admin foram inseridos
        System.out.println("Usuários Admin cadastrados:");
        for (UsuarioAdmin admin : usuarioAdminDAO.getAll()) {
            System.out.println(admin);
        }

        // Inserindo usuários clientes
        for (int i = 1; i <= 5; i++) {
            UsuarioCliente cliente = new UsuarioCliente(i, 1000.0);
            usuarioClienteDAO.insert(cliente);
        }

        // Verificando se os usuários clientes foram inseridos
        System.out.println("Usuários Cliente cadastrados:");
        for (UsuarioCliente cliente : usuarioClienteDAO.getAll()) {
            System.out.println(cliente);
        }

        // Inserindo transações financeiras
        for (int i = 1; i <= 5; i++) {
            TransacaoFinanceira transacao = new TransacaoFinanceira(i, i, 100.0 * i, new Date(), "Transação " + i);
            transacaoFinanceiraDAO.insert(transacao);
        }

        // Verificando se as transações foram inseridas
        System.out.println("Transações Financeiras cadastradas:");
        for (TransacaoFinanceira transacao : transacaoFinanceiraDAO.getAll()) {
            System.out.println(transacao);
        }

        // Inserindo receitas
        for (int i = 1; i <= 5; i++) {
            Receita receita = new Receita(i, "Origem " + i);
            receitaDAO.insert(receita);
        }

        // Verificando se as receitas foram inseridas
        System.out.println("Receitas cadastradas:");
        for (Receita receita : receitaDAO.getAll()) {
            System.out.println(receita);
        }

        // Inserindo despesas
        for (int i = 1; i <= 5; i++) {
            Despesa despesa = new Despesa(i, "Categoria " + i, new Date());
            despesaDAO.insert(despesa);
        }

        // Verificando se as despesas foram inseridas
        System.out.println("Despesas cadastradas:");
        for (Despesa despesa : despesaDAO.getAll()) {
            System.out.println(despesa);
        }
    }
}
