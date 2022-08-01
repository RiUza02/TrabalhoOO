package Outros;

import BatalhaNaval.Tela;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Jogador;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

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
