package control;

import BatalhaNaval.Tela;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import model.*;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class CiqueMouse implements MouseListener {

    private final Campo campo;
    private final Jogador jogador;
    private final char dificuldade;
    private final Tela tela;

    public CiqueMouse(Jogador jogador, char dificuldade, Tela tela) {
        this.jogador = jogador;
        this.campo = jogador.getCampo();
        this.dificuldade = dificuldade;
        this.tela = tela;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Botao botao = (Botao) me.getSource();
        jogador.atirar(botao.getx(), botao.gety());
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) != 0) {
            ImageIcon agua = new ImageIcon("agu.png");
            botao.setIcon(agua);
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 1) {
            ImageIcon agua = new ImageIcon("Pow.png");
            botao.setIcon(agua);
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 2) {
            ImageIcon agua = new ImageIcon("Pow.png");
            botao.setIcon(agua);
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 3) {
            ImageIcon agua = new ImageIcon("Pow.png");
            botao.setIcon(agua);
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 4) {
            ImageIcon agua = new ImageIcon("Pow.png");
            botao.setIcon(agua);
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 5) {
            ImageIcon agua = new ImageIcon("Pow.png");
            botao.setIcon(agua);
            jogador.pontosAdd();
        }
        double sorte = Math.random();
        if ((sorte < 0.33) && (dificuldade == 'D')) {
            tela.mouseClickedBot();
        }
        tela.mouseClickedBot();
        if (jogador.achouTudo()) {
            tela.GanhaJogo(1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
