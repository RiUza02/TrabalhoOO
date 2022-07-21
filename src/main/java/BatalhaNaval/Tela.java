package BatalhaNaval;

import IA.*;
import control.Botao;
import control.CiqueMouse;
import control.ModoDificil;
import control.ModoFacil;
import control.ModoMedio;
import control.IniciarJogo;
import java.awt.*;
import javax.swing.*;
import model.Jogador;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Tela extends JFrame {

    private Jogador jogador;
    private static Botao[][] botoesBot;
    private static Bot bot;
    private static int nNavios;
    private static JPanel menu;
    private static JPanel menuD;

    public Tela() {
        botoesBot = new Botao[10][10];
        menu = new JPanel();
        menuD = new JPanel();
    }

    public void TelaMenu() {
        //menu.setLayout(new GridLayout(10, 10));
        menu.setBorder(BorderFactory.createTitledBorder("Menu"));

        JButton iniciar = new JButton();
        iniciar.setText("INICIAR");
        iniciar.addActionListener(new IniciarJogo(this) {
        });
        iniciar.setPreferredSize(new Dimension(300, 50));
        iniciar.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton rank = new JButton();
        rank.setText("PLACAR");
        //rank.addMouseListener();
        rank.setPreferredSize(new Dimension(300, 50));
        rank.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton outros = new JButton();
        outros.setText("BOTAO");
        //outros.addMouseListener();
        outros.setPreferredSize(new Dimension(300, 50));
        outros.setBorder(BorderFactory.createLineBorder(Color.black));

        menu.add(iniciar);
        menu.add(rank);
        menu.add(outros);
        menu.setSize(400, 300);

        this.add(menu);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public void setDificuldadeMenu() {

        this.remove(menu);
        JButton facil = new JButton();
        facil.setText("FÁCIL");
        facil.setToolTipText("Quase imposível perde");
        facil.addActionListener(new ModoFacil(this) {
        });
        facil.setPreferredSize(new Dimension(300, 50));
        facil.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton medio = new JButton();
        medio.setText("MÉDIO");
        medio.setToolTipText("Ainda é facil");
        medio.addActionListener(new ModoMedio(this) {
        });
        medio.setPreferredSize(new Dimension(300, 50));
        medio.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton dificil = new JButton();
        dificil.setText("DIFICIL");
        dificil.setToolTipText("Ok, esse é um desafio");
        dificil.addActionListener(new ModoDificil(this) {
        });
        dificil.setPreferredSize(new Dimension(300, 50));
        dificil.setBorder(BorderFactory.createLineBorder(Color.black));

        menuD.add(facil);
        menuD.add(medio);
        menuD.add(dificil);

        this.add(menuD);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void setDificuldade(int N, char A) {

        this.nNavios = N;
        jogador = new Jogador(nNavios);
        switch (A) {
            case 'F' ->
                bot = new BotBurro(nNavios);
            case 'M' ->
                bot = new BotInteligente(nNavios);
            case 'D' ->
                bot = new Botladrao(nNavios);
        }

    }

    public void desenha() {
        this.remove(menuD);
        JPanel player = new JPanel();
        player.setLayout(new GridLayout(10, 10));
        player.setBorder(BorderFactory.createTitledBorder("Player"));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Botao botao = new Botao(i, j);
                botao.addMouseListener(new CiqueMouse(jogador));
                botao.setPreferredSize(new Dimension(50, 50));
                botao.setBorder(BorderFactory.createLineBorder(Color.black));
                player.add(botao);
            }
        }

        JPanel bot = new JPanel();
        bot.setLayout(new GridLayout(10, 10));
        bot.setBorder(BorderFactory.createTitledBorder("bot"));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Botao botao = new Botao(i, j);
                botao.setPreferredSize(new Dimension(10, 10));
                botao.setBorder(BorderFactory.createLineBorder(Color.black));
                botao.setVisible(true);
                bot.add(botao);
                botoesBot[i][j] = botao;
            }
        }

        this.add(player, BorderLayout.WEST);
        this.add(bot, BorderLayout.EAST);

        this.setVisible(true);
        this.setLayout(new GridLayout(1, 2));
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public static void mouseClickedBot() {
        bot.atirar();
        int x = bot.getX();
        int y = bot.getY();
        System.out.println(bot.achouTudo());
        bot.imprime();
        if (bot.getCampo().getMapaPosicaoJogador(x, y) != 0) {
            botoesBot[x][y].setText("-1");
        }
        if (bot.getCampo().getMapaPosicaoJogador(x, y) == 1) {
            botoesBot[x][y].setText("1");
        }
        if (bot.getCampo().getMapaPosicaoJogador(x, y) == 2) {
            botoesBot[x][y].setText("2");
        }
        if (bot.getCampo().getMapaPosicaoJogador(x, y) == 3) {
            botoesBot[x][y].setText("3");
        }
        if (bot.getCampo().getMapaPosicaoJogador(x, y) == 4) {
            botoesBot[x][y].setText("4");
        }
        if (bot.getCampo().getMapaPosicaoJogador(x, y) == 5) {
            botoesBot[x][y].setText("5");
        }
    }
}
