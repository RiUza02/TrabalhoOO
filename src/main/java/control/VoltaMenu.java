/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BatalhaNaval.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;

/**
 *
 * @author victo
 */
public class VoltaMenu implements ActionListener{
    
    
    Tela tela;

    public VoltaMenu(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.remove(this.tela.getRank());
        //this.tela.remove(this.tela.menu);
        this.tela.TelaMenu();
        this.tela.repaint();
    }
    
}
