package services;

import models.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaService {
    private List<Conta> contas;

    public ContaService() {
        this.contas = new ArrayList<>();
    }

    public Conta criarConta(String titular, double saldoInicial) {
        Conta conta = new Conta(titular, saldoInicial);
        contas.add(conta);
        return conta;
    }

    public Conta buscarContaPorId(int id) {
        return contas.stream().filter(conta -> conta.getId() == id).findFirst().orElse(null);
    }

    public void listarContas() {
        contas.forEach(System.out::println);
    }

    public boolean depositar(int id, double valor) {
        Conta conta = buscarContaPorId(id);
        if (conta != null) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public boolean sacar(int id, double valor) {
        Conta conta = buscarContaPorId(id);
        if (conta != null) {
            return conta.sacar(valor);
        }
        return false;
    }
}
