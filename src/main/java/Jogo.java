
import java.util.*;

public class Jogo {

    private int jogadas;
    private Campo campo = new Campo();
    private final Scanner teclado = new Scanner(System.in);

    public Jogo() {
        setDificuldade();
    }

    private void setDificuldade() {
        int dificuldade, quantidade;
        System.out.println("Escolha a dificuldade: \n"
                + "0: facil \n"
                + "1: medio \n"
                + "2: dificil");
        dificuldade = teclado.nextInt();

        System.out.println("Escolha a quantidade de alvos (entre 1 e 15)");
        quantidade = teclado.nextInt();
        switch (dificuldade) {
            case 0 -> {
                if (quantidade <= 15 && quantidade >= 1) {
                    Campo.quantidadeNavio(quantidade);
                    jogadas = 15 * quantidade;
                } else {
                    System.out.println("valor invalido");
                }
            }

            case 1 -> {
                if (quantidade <= 15 && quantidade >= 1) {
                    Campo.quantidadeNavio(quantidade);
                    jogadas = 10 * quantidade;
                } else {
                    System.out.println("valor invalido");
                }
            }
            case 2 -> {
                if (quantidade <= 15 && quantidade >= 1) {
                    jogadas = 7 * quantidade;
                    Campo.quantidadeNavio(quantidade);
                } else {
                    System.out.println("valor invalido");
                }
            }
        }
    }

    public void atirar() {
        campo.atirar();
    }

    public void imprime() {
        campo.imprimeMapaJogador();
    }

    public int getJogadas() {
        return jogadas;
    }
}
