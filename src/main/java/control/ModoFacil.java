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
public class ModoFacil implements ActionListener{
    
    Tela tela;
    
    public ModoFacil(Tela tela){
        
        this.tela = tela;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.setDificuldade(10, 'F');
        this.tela.desenha();
        this.tela.repaint();
    }
    
    
    
}
