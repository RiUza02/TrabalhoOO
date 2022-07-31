package BatalhaNaval;

import IA.*;
import Outros.Arquivo;
import Outros.Ranking;
import control.*;
import java.awt.*;
import java.io.FileNotFoundException;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.*;
import model.Jogador;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    202065091ab

public class Tela extends JFrame {

    private Jogador jogador;
    private static Botao[][] botoesBot;
    private static Bot bot;
    private static int nNavios;
    private static char dificuldade;
    private static JPanel menu;
    private static JPanel menuD;
    private static JPanel rank;
    private static JPanel menuR;
    private static JPanel telaPlayer;
    private static JPanel telaBot;
    private static Ranking rak;
    private static int lastIndex;
    private static JTextField tfNome;
    private static JTextField tfTelefone;

    private JList<Jogador> lista;

    public JList<Jogador> getLista() {
        return lista;
    }

    public void setLista(JList<Jogador> lista) {
        this.lista = lista;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfTelefone() {
        return tfTelefone;
    }

    public void setTfTelefone(JTextField tfTelefone) {
        this.tfTelefone = tfTelefone;
    }

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
        rank.addActionListener(new MostraRanking(this));
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

    public void configuraRanking() {
        /* JPanel jpContatos = new JPanel();
        jpContatos.setBorder(BorderFactory.createTitledBorder("Placar"));
        jpContatos.setLayout(new BorderLayout());
        jpContatos.setPreferredSize(new Dimension(200, 300));

        DefaultListModel<Jogador> model = new DefaultListModel<>();
        
        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new TratarLista(this));
        jpContatos.add(new JScrollPane(lista), BorderLayout.CENTER);

//        JPanel botaoPainel = new JPanel();
//
//        botaoPainel.setLayout(new GridLayout(1, 2));
//        jpContatos.add(botaoPainel, BorderLayout.SOUTH);

        menu.add(jpContatos);
        menu.repaint();*/

        this.remove(menu);

        rank = new JPanel();
        rank.setBorder(BorderFactory.createTitledBorder("Placar"));
        rank.setLayout(new BorderLayout());
        rank.setPreferredSize(new Dimension(200, 300));

        ArrayList<String> jogadoresss = new ArrayList<String>();
        ArrayList<String> conteudo;

        Arquivo arq = new Arquivo();
        try {

            conteudo = arq.lerArquivo("C:\\Users\\victo\\OneDrive\\Área de Trabalho\\AAAAA.txt");
            for (int j = 0; j < conteudo.size(); j++) {

                jogadoresss.add(conteudo.get(j));

            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }

        JList lista = new JList(jogadoresss.toArray());
        lista.setSize(200, 200);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(lista);
        rank.add(scroll);
        rank.setBorder(BorderFactory.createRaisedBevelBorder());

        this.add(rank);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void setDificuldadeMenu() {
        this.remove(menu);
        JButton facil = new JButton();
        facil.setText("FÁCIL");
        facil.setToolTipText("Quase imposível perder");
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
        Ranking rank = new Ranking(jogador);
        exit(0);
    }

    public void GanhaJogoBot() {
        JOptionPane.showMessageDialog(null, "Voce perdeu...");
        String nome = JOptionPane.showInputDialog(null, "Digite o seu nome:", "Name", JOptionPane.QUESTION_MESSAGE);
        Ranking rank = new Ranking(jogador);
        jogador.setNome(nome);
        exit(0);
    }
}
