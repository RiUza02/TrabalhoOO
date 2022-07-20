package control;

import java.awt.event.*;
import model.*;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class CiqueMouse implements MouseListener {

    private Campo campo;
    private Jogador jogador;

    public CiqueMouse(Jogador jogador) {
        this.jogador = jogador;
        this.campo = jogador.getCampo();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Botao botao = (Botao) me.getSource();
        jogador.atirar(botao.getX(), botao.getY());
        System.out.println(jogador.achouTudo());
        jogador.imprime();
        if (campo.getMapaPosicaoJogador(botao.getX(), botao.getY()) != 0) {
            botao.setText("-1");
        }
        if (campo.getMapaPosicaoJogador(botao.getX(), botao.getY()) == 1) {
            botao.setText("1");
        }
        if (campo.getMapaPosicaoJogador(botao.getX(), botao.getY()) == 2) {
            botao.setText("2");
        }
        if (campo.getMapaPosicaoJogador(botao.getX(), botao.getY()) == 3) {
            botao.setText("3");
        }
        if (campo.getMapaPosicaoJogador(botao.getX(), botao.getY()) == 4) {
            botao.setText("4");
        }
        if (campo.getMapaPosicaoJogador(botao.getX(), botao.getY()) == 5) {
            botao.setText("5");
        }
        Tela.mouseClickedBot();
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
