
import java.util.Scanner;

public class trabalho {

    public static void main(String[] args) {
        System.out.println("Bem Vindo ao Jogo Batalha Naval!!");
        Jogo jogo = new Jogo();
        jogo.imprime();
        while (!jogo.encerrou()) {
                jogo.atirar();
                jogo.imprime();
                System.out.println("Jogadas Restantes: " + jogo.getJogadas());
        }
        
        System.out.println("FIM DE JOGO");

    }
}
    