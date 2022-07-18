package model;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509abs
import IA.Bot;
import IA.BotInteligente;
import IA.Botladrao;
import IA.BotBurro;
import java.util.*;

public class JogoPlayerVsAI extends Jogo {

    private char dificuldade;
    private int quantidadeNavio;
    private Jogador jogador;
    private Bot bot;
    private final Scanner teclado = new Scanner(System.in);

    public JogoPlayerVsAI() {
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
        jogador = new Jogador(quantidadeNavio);
    }

    public void setPlayer() {
        jogador = new Jogador(quantidadeNavio);
        System.out.println("o nome do jogador: ");
        jogador.setNome(teclado.nextLine());
        String nome = teclado.next();
        System.out.println("a idade do jogador: ");
        jogador.setIdade(teclado.nextInt());
    }

    @Override
    public void atirar() {
        jogador.atirar();
        bot.atirar();
    }

    @Override
    public void imprime() {
        System.out.println("Jogador: ");
        jogador.imprime();
        System.out.println("Bot: ");
        bot.imprime();
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
        if (jogador.achouTudo()) {
            System.out.println(jogador.getNome() + " Ganhou!");
            return true;
        } else {
            if (bot.achoTudo()) {
                System.out.println("O Bot venceu!");
                return true;
            } else {
                return false;
            }
        }
    }
}
