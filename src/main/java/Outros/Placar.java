/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Outros;

import BatalhaNaval.Tela;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Jogador;

/**
 *
 * @author victo
 */
public class Placar {
    
   /* Tela tela;

    public Placar(Tela tela) {
        this.tela = tela;
    }
    
    public void windowOpened(WindowEvent e) {
        
        
        
        try {
            String lerArquivo = Arquivo.lerArquivo("dados");
            List<Jogador> jogadores = JSON.toJogadores(lerArquivo);
            
            DefaultListModel<Jogador> modelo = new DefaultListModel<>();
            
            for (Jogador jogador : jogadores) {
                modelo.addElement(jogador);
            }
            
            tela.getLista().setModel(modelo);
            tela.repaint();
            
        } catch (FileNotFoundException ex) {
        }
    }*/
    
}
