/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author victo
 */
public class ModoMedio implements ActionListener{

    Tela tela;
    
    public ModoMedio(Tela tela){
        
        this.tela = tela;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.setDificuldade(10, 'M');
        this.tela.desenha();
        this.tela.repaint();
    }
    
}
