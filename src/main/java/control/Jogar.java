/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Jogador;
import IA.Bot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author 55329
 */
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
