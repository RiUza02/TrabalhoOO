package BatalhaNaval;

//yuri Alexsander Sudre Almeida Souza   202065512b
import java.util.Scanner;

//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab
public class trabalho {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Jogo jogo;
        int flag;

        System.out.println("Bem Vindo ao Jogo Batalha Naval!!");
        System.out.println("Qual tipo de jogo quer jogar?: ");
        System.out.println("Bot vs Player: 1");
        System.out.println("Player: vs Player: 2");
        flag = teclado.nextInt();
        switch (flag) {
            case 1 -> {
                jogo = new JogoPlayerVsAI();
            }
            case 2 -> {
                jogo = new JogoPlayerVsPlayer();
            }
            default -> {
                jogo = new JogoPlayerVsAI();
            }
        }
        jogo.imprime();
        while (!jogo.encerrou()) {
            jogo.atirar();
            jogo.imprime();
        }
        System.out.println("FIM DE JOGO");
    }
}
