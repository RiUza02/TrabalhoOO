package BatalhaNaval;

import IA.*;
import control.*;
import java.awt.*;
import static java.lang.System.exit;
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
    private static char dificuldade;
    private static JPanel menu;
    private static JPanel menuD;
    private static JPanel telaPlayer;
    private static JPanel telaBot;

    public Tela() {
        botoesBot = new Botao[10][10];
        menu = new JPanel();
        menuD = new JPanel();
    }

    public void TelaMenu() {
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

        JButton Sair = new JButton();
        Sair.setText("SAIR");
        Sair.addMouseListener(new FechaTela(this));
        Sair.setPreferredSize(new Dimension(300, 50));
        Sair.setBorder(BorderFactory.createLineBorder(Color.black));

        menu.add(iniciar);
        menu.add(rank);
        menu.add(Sair);
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
        this.dificuldade = A;
        jogador = new Jogador(nNavios);
        switch (A) {
            case 'F' ->
                bot = new BotBurro(nNavios);
            case 'M' ->
                bot = new BotInteligente(nNavios);
            case 'D' ->
                bot = new BotLadrao(nNavios);
        }

    }

    public void desenha() {
        this.remove(menuD);
        telaPlayer = new JPanel();
        telaPlayer.setLayout(new GridLayout(10, 10));
        telaPlayer.setBorder(BorderFactory.createTitledBorder("Player"));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Botao botao = new Botao(i, j);
                botao.addMouseListener(new CiqueMouse(jogador, dificuldade, this));
                botao.setPreferredSize(new Dimension(50, 50));
                botao.setBorder(BorderFactory.createLineBorder(Color.black));
                telaPlayer.add(botao);
            }
        }

        telaBot = new JPanel();
        telaBot.setLayout(new GridLayout(10, 10));
        telaBot.setBorder(BorderFactory.createTitledBorder("bot"));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Botao botao = new Botao(i, j);
                botao.setPreferredSize(new Dimension(10, 10));
                botao.setBorder(BorderFactory.createLineBorder(Color.black));
                botao.setVisible(true);
                telaBot.add(botao);
                botoesBot[i][j] = botao;
            }
        }

        this.add(telaPlayer, BorderLayout.WEST);
        this.add(telaBot, BorderLayout.EAST);
        this.setVisible(true);
        this.setLayout(new GridLayout(1, 2));
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public void mouseClickedBot() {
        bot.atirar();
        int x = bot.getX();
        int y = bot.getY();
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
        if (bot.achouTudo()) {
            GanhaJogo(2);
        }
    }

    public void GanhaJogo(int i) {
        if (i == 1) {
            GanhaJogoPlayer();
        } else {
            GanhaJogoBot();
        }
    }

    public void GanhaJogoPlayer() {
        JOptionPane.showMessageDialog(null, "Voce venceu!");
        String nome = JOptionPane.showInputDialog(null, "Digite o seu nome:", "Name", JOptionPane.QUESTION_MESSAGE);
        jogador.setNome(nome);
        exit(0);
    }

    public void GanhaJogoBot() {
        JOptionPane.showMessageDialog(null, "Voce perdeu...");
        String nome = JOptionPane.showInputDialog(null, "Digite o seu nome:", "Name", JOptionPane.QUESTION_MESSAGE);
        jogador.setNome(nome);
        exit(0);
    }
}
