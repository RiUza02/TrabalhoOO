package control;

import IA.*;
import java.awt.*;
import javax.swing.*;
import model.Jogador;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Tela extends JFrame {

    private JPanel Tela;
    private JPanel painel2;
    private Jogador jogador;
    private static Botao[][] botoesBot;
    private static Bot bot;
    private final int nNavios = 1;
    private static JPanel menu;

    public Tela() {
        this.Tela = new JPanel();
        botoesBot = new Botao[10][10];
        jogador = new Jogador(nNavios);
        bot = new BotBurro(nNavios);
        menu = new JPanel();
    }
    
    public void TelaMenu(){
        //menu.setLayout(new GridLayout(10, 10));
        menu.setBorder(BorderFactory.createTitledBorder("Menu"));
        
        JButton iniciar = new JButton();
        iniciar.setText("INICIAR");
        iniciar.addActionListener(new iniciarJogo(this) {});
        iniciar.setPreferredSize(new Dimension(300,50));
        iniciar.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JButton rank = new JButton();
        rank.setText("PLACAR");
        //iniciar.addMouseListener();
        rank.setPreferredSize(new Dimension(300,50));
        rank.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JButton outros = new JButton();
        outros.setText("BOTAO");
        //iniciar.addMouseListener();
        outros.setPreferredSize(new Dimension(300,50));
        outros.setBorder(BorderFactory.createLineBorder(Color.black));
        
        menu.add(iniciar);
        menu.add(rank);
        menu.add(outros);
        menu.setSize(400,300);
        
        this.add(menu);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
    }

    public void desenha() {
        this.remove(menu);
        JPanel player = new JPanel();
        player.setLayout(new GridLayout(10, 10));
        //player.setBorder(BorderFactory.createTitledBorder("Player"));
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                Botao botao = new Botao();
                botao.setX(i);
                botao.setY(j);
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
                Botao botao = new Botao();
                botao.setX(i);
                botao.setY(j);
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
