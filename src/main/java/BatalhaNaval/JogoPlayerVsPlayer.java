package BatalhaNaval;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509abs
import java.util.*;

public class JogoPlayerVsPlayer extends Jogo {

    private char dificuldade;
    private int quantidadeNavio;
    Jogador jogador1, jogador2;
    Bot bot;
    private final Scanner teclado = new Scanner(System.in);

    public JogoPlayerVsPlayer() {
        setConfig();
        setPlayer();
        switch (dificuldade) {
            case 'F' -> {
                bot = new BotBurro(quantidadeNavio);
            }
            case 'M' -> {
                bot = new BotInteligente(quantidadeNavio);
            }
            case 'D' -> {
                bot = new Botladrao(quantidadeNavio);
            }
        }
        jogador1 = new Jogador(quantidadeNavio);
        jogador2 = new Jogador(quantidadeNavio);
    }

    public void setPlayer() {
        System.out.println("o Nome do jogador 1: ");
        jogador1.setNome(teclado.nextLine());
        System.out.println("A idade do jogador 1: ");
        jogador1.setIdade(teclado.nextInt());
        System.out.println("o Nome do jogador 2: ");
        jogador2.setNome(teclado.nextLine());
        System.out.println("A idade do jogador 2: ");
        jogador2.setIdade(teclado.nextInt());
    }

    @Override
    public void atirar() {
        jogador1.atirar();
        jogador2.atirar();
    }

    @Override
    public void imprime() {
        System.out.println("Jogador: ");
        jogador1.imprime();
        System.out.println("Bot: ");
        jogador2.imprime();
    }

    private void setConfig() {
        int flag1;
        char flag2;
        System.out.println("Escolha a dificuldade: ");
        System.out.println("F: facil");
        System.out.println("M: medio");
        System.out.println("D: dificil");
        flag2 = Character.toUpperCase(teclado.next().charAt(0));
        if ((flag2 == 'F') || (flag2 == 'M') || (flag2 == 'D')) {
            dificuldade = flag2;
            System.out.println("Escolha a quantidade de alvos (entre 1 e 15)");
            flag1 = teclado.nextInt();
            if (flag1 >= 1 & flag1 <= 15) {
                quantidadeNavio = flag1;
            } else {
                System.out.println("Valor invalido! Realize o procedimento novamente");
                setConfig();
            }
        } else {
            System.out.println("Valor invalido! Realize o procedimento novamente");
            setConfig();
        }
    }

    @Override
    public boolean encerrou() {
        if (jogador1.achouTudo()) {
            System.out.println(jogador1.getNome() + " Ganhou!");
            return true;
        } else {
            if (bot.achoTudo()) {
                System.out.println(jogador2.getNome() + " Ganhou!");
                return true;
            } else {
                return false;
            }
        }
    }
}
