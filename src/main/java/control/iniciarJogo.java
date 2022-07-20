/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.*;

/**
 *
 * @author victo
 */
public class iniciarJogo implements ActionListener{
    
    Tela tela;
    
    public iniciarJogo(Tela tela){
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.desenha();
        this.tela.repaint();
    }
}
