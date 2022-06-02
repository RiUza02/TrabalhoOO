
import java.util.*;

public class Jogo {

    private int jogadas;
    private Campo campo = new Campo();
    private final Scanner teclado = new Scanner(System.in);
    private static int rest;

    public Jogo() {
        setDificuldade();
    }

    private void setDificuldade() {
        int quantidade;
        char dificuldade;
        System.out.println("Escolha a dificuldade: \n"
                + "F: facil \n"
                + "M: medio \n"
                + "D: dificil");
        dificuldade = Character.toUpperCase(teclado.next().charAt(0));

        System.out.println("Escolha a quantidade de alvos (entre 1 e 15)");
        quantidade = teclado.nextInt();
        switch (dificuldade) {
            case 'F' -> {
                if (quantidade <= 15 & quantidade >= 1) {
                    Campo.quantidadeNavio(quantidade);
                    jogadas = 15 * quantidade;
                } else {
                    System.out.println("valor invalido");
                }
            }

            case 'M' -> {
                if (quantidade <= 15 & quantidade >= 1) {
                    Campo.quantidadeNavio(quantidade);
                    jogadas = 10 * quantidade;
                } else {
                    System.out.println("valor invalido");
                }
            }
            case 'D' -> {
                if (quantidade <= 15 & quantidade >= 1) {
                    jogadas = 7 * quantidade;
                    Campo.quantidadeNavio(quantidade);
                } else {
                    System.out.println("valor invalido");
                }
            }
        }
        rest = jogadas;
    }

    public void atirar() {
        campo.atirar();
    }

    public void imprime() {
        campo.imprime();

        System.out.println("Jogadas Restantes: " + rest);
        campo.imprimeMapaJogador();
        rest--;
    }

    public int getJogadas() {
        return jogadas;
    }

    public boolean Encerrou(int cont_jogadas) {

        return /*campo.AchouTudo() == true ||*/ cont_jogadas == jogadas;

    }

}
