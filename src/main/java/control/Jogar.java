package control;

import model.Jogador;
import IA.Bot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Jogar implements MouseListener {

    Botao[][] botoes = new Botao[10][10];
    Jogador jogador1;
    Bot bot;

    @Override

    public void mouseClicked(MouseEvent e) {

    }

    public Jogar(Jogador jogador1, Bot jogador2) {
        this.jogador1 = jogador1;
        bot = jogador2;
    }

    //---------------------------------------------------------------------------------------
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
