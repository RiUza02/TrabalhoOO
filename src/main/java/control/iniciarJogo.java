package control;

import BatalhaNaval.Tela;
import java.awt.event.*;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    202065091ab

public class IniciarJogo implements ActionListener {

    Tela tela;

    public IniciarJogo(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.setMenuDificuldade();
        this.tela.repaint();
    }
}
