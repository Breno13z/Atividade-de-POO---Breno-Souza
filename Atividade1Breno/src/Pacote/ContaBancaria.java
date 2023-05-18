package Pacote;

public class ContaBancaria {

	    private String nomePessoa;
	    private String numeroConta;
	    private double saldo;

	    public ContaBancaria(String nomePessoa, String numeroConta, double saldo) {
	        this.nomePessoa = nomePessoa;
	        this.numeroConta = numeroConta;
	        this.saldo = saldo;
	    }

	    public void depositar(double valor) {
	        saldo += valor;
	        System.out.printf("Depósito de R$%.2f realizado com sucesso.%n", valor);
	    }

	    public void sacar(double valor) {
	        if (valor <= saldo) {
	            saldo -= valor;
	            System.out.printf("Saque de R$%.2f realizado com sucesso.%n", valor);
	        } else {
	            System.out.println("Saldo insuficiente para efetuar o saque.");
	        }
	    }

	    public void verificarSaldo() {
	        System.out.printf("Saldo atual: R$%.2f%n", saldo);
	    }
	}

