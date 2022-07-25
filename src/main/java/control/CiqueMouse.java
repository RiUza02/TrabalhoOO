package control;

import BatalhaNaval.Tela;
import java.awt.event.*;
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
            botao.setText("Agua");
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 1) {
            botao.setText("1");
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 2) {
            botao.setText("2");
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 3) {
            botao.setText("3");
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 4) {
            botao.setText("4");
            jogador.pontosAdd();
        }
        if (campo.getMapaPosicaoJogador(botao.getx(), botao.gety()) == 5) {
            botao.setText("5");
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
