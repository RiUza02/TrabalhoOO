package BatalhaNaval;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Jogador;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class TratarLista implements ListSelectionListener {

    private final Tela tela;

    public TratarLista(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getLista().getSelectedIndex();

        if (firstIndex != -1) {
            Jogador elementAt = tela.getLista().getModel().getElementAt(firstIndex);
            tela.getTfNome().setText(elementAt.getNome());
            //tela.getTfTelefone().setText(elementAt.getPontos());
            tela.setLastIndex(firstIndex);
        }
    }

}
