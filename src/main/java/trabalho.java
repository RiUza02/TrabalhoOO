
import java.util.Scanner;

public class trabalho {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int comecar;
        System.out.println("Bem Vindo ao Jogo Batalha Naval!!");
        Jogo jogo = new Jogo();
        while ((jogo.getJogadas() != 0) && !(jogo.encerrou())) {
            for (int i = 0; i < 10; i++) {
                jogo.atirar();
                jogo.imprime();
                System.out.println("Você ainda tem" + jogo.getJogadas() + "jogadas");
            }
        }

    }
}
