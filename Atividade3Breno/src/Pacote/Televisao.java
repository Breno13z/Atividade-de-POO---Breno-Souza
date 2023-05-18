package Pacote;

import java.util.List;
import java.util.ArrayList;

public class Televisao {
    private int volumeMaximo;
    private int volume;
    private List<String> canais;
    private int canalAtual;
    private boolean ligada;

    public Televisao() {
        volumeMaximo = 100;
        volume = 0;
        canais = new ArrayList<String>();
        canais.add("Canal 1");
        canais.add("Canal 2");
        canais.add("Canal 3");
        canais.add("Canal 4");
        canais.add("Canal 5");
        canalAtual = 0;
        ligada = false;
    }

    public void aumentarVolume() {
        if (ligada && volume < volumeMaximo) {
            volume++;
            System.out.println("Volume aumentado.");
        }
    }

    public void diminuirVolume() {
        if (ligada && volume > 0) {
            volume--;
            System.out.println("Volume diminuído.");
        }
    }

    public void subirCanal() {
        if (ligada) {
            if (canalAtual == canais.size() - 1) {
                canalAtual = 0;
            } else {
                canalAtual++;
            }
            System.out.println("Canal atual: " + canais.get(canalAtual));
        }
    }

    public void descerCanal() {
        if (ligada) {
            if (canalAtual == 0) {
                canalAtual = canais.size() - 1;
            } else {
                canalAtual--;
            }
            System.out.println("Canal atual: " + canais.get(canalAtual));
        }
    }

    public void ligar() {
        ligada = true;
        System.out.println("A televisão foi ligada.");
    }

    public void desligar() {
        ligada = false;
        System.out.println("A televisão foi desligada.");
    }

    public void mostrarInformacoes() {
        String estado = ligada ? "ligada" : "desligada";
        System.out.println("Estado: " + estado);
        System.out.println("Volume: " + volume);
        System.out.println("Canal atual: " + canais.get(canalAtual));
    }
}