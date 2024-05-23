package ui;

import services.ContaService;

import java.util.Scanner;

public class ConsoleUI {
    private ContaService contaService;
    private Scanner scanner;

    public ConsoleUI() {
        this.contaService = new ContaService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    listarContas();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("==== Banco ====");
        System.out.println("1. Criar Conta");
        System.out.println("2. Listar Contas");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void criarConta() {
        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        contaService.criarConta(titular, saldoInicial);
        System.out.println("Conta criada com sucesso!");
    }

    private void listarContas() {
        contaService.listarContas();
    }

    private void depositar() {
        System.out.print("ID da conta: ");
        int id = scanner.nextInt();
        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        if (contaService.depositar(id, valor)) {
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private void sacar() {
        System.out.print("ID da conta: ");
        int id = scanner.nextInt();
        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        if (contaService.sacar(id, valor)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada ou saldo insuficiente!");
        }
    }
}
