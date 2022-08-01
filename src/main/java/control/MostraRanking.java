package control;

import BatalhaNaval.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class MostraRanking implements ActionListener {

    private final Tela tela;

    public MostraRanking(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.configuraRanking();
        this.tela.repaint();
    }

}
