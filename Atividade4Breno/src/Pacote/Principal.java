package Pacote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Principal {
    private List<ContaBancaria> contas;
    private Scanner scanner;

    public Principal() {
        contas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void inserirPessoa() {
        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();
        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine();

        contas.add(new ContaBancaria(nomePessoa, numeroConta, saldoInicial));
        System.out.println("Pessoa inserida no banco com sucesso.");
    }

    public void acessarConta() {
        if (contas.size() < 2) {
            System.out.println("É necessário ter pelo menos duas pessoas inseridas no banco.");
            return;
        }

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        ContaBancaria conta = encontrarConta(numeroConta);

        if (conta != null) {
            exibirMenuConta(conta);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private ContaBancaria encontrarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    private void exibirMenuConta(ContaBancaria conta) {
        int opcao;
        do {
            System.out.println("\n-- MENU --");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Verificar saldo");
            System.out.println("4. Transferir entre contas");
            System.out.println("0. Voltar");

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.verificarSaldo();
                    break;
                case 4:
                    System.out.print("Digite o número da conta de destino: ");
                    String numeroContaDestino = scanner.next();
                    scanner.nextLine();

                    ContaBancaria contaDestino = encontrarConta(numeroContaDestino);

                    if (contaDestino != null) {
                        System.out.print("Digite o valor a ser transferido: ");
                        double valorTransferencia = scanner.nextDouble();
                        conta.transferir(contaDestino, valorTransferencia);
                    } else {
                        System.out.println("Conta de destino não encontrada.");
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
            }
        } while (opcao != 0);
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n-- MENU PRINCIPAL --");
            System.out.println("1. Inserir pessoa no banco");
            System.out.println("2. Acessar conta individual");
            System.out.println("0. Sair");

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    inserirPessoa();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.exibirMenuPrincipal();
    }
}
