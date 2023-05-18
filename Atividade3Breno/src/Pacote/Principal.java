package Pacote;

public class Principal {
    public static void main(String[] args) {
        Televisao televisao = new Televisao();
        televisao.mostrarInformacoes();

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1 - Aumentar volume");
            System.out.println("2 - Diminuir volume");
            System.out.println("3 - Subir canal");
            System.out.println("4 - Descer canal");
            System.out.println("5 - Ligar a televisão");
            System.out.println("6 - Desligar a televisão");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    televisao.aumentarVolume();
                    break;
                case 2:
                    televisao.diminuirVolume();
                    break;
                case 3:
                    televisao.subirCanal();
                    break;
                case 4:
                    televisao.descerCanal();
                    break;
                case 5:
                    televisao.ligar();
                    break;
                case 6:
                    televisao.desligar();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            televisao.mostrarInformacoes();
        }
    }
}
