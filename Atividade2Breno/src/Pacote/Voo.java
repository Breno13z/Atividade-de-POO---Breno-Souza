package Pacote;

import java.util.Scanner;

public class Voo {
    private String data;
    private String horario;
    private int ocupacao;

    public Voo(String data, String horario) {
        this.data = data;
        this.horario = horario;
        this.ocupacao = 0;
    }

    public void adicionarPassageiro() {
        if (ocupacao < 100) {
            ocupacao++;
            System.out.println("Passageiro adicionado com sucesso.");
        } else {
            System.out.println("Não é possível adicionar mais passageiros. O voo está lotado.");
        }
    }

    public void removerPassageiro() {
        if (ocupacao > 0) {
            ocupacao--;
            System.out.println("Passageiro removido com sucesso.");
        } else {
            System.out.println("Não há passageiros para remover.");
        }
    }

    public int verificarOcupacao() {
        return ocupacao;
    }

    public void informacoesVoo() {
        System.out.println("Informações do voo:");
        System.out.println("Data: " + data);
        System.out.println("Horário: " + horario);
        System.out.println("Ocupação: " + ocupacao + " passageiros");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Voo voo = new Voo("2023-05-18", "10:00");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar passageiro");
            System.out.println("2. Remover passageiro");
            System.out.println("3. Verificar ocupação");
            System.out.println("4. Informações do voo");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    voo.adicionarPassageiro();
                    break;
                case 2:
                    voo.removerPassageiro();
                    break;
                case 3:
                    int ocupacao = voo.verificarOcupacao();
                    System.out.println("Ocupação atual: " + ocupacao + " passageiros");
                    break;
                case 4:
                    voo.informacoesVoo();
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
