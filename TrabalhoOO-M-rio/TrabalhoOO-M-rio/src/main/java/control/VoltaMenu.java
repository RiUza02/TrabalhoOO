package control;

import BatalhaNaval.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    202065091ab

public class VoltaMenu implements ActionListener {

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
