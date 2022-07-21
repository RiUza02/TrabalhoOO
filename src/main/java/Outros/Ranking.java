package Outros;

import model.Jogador;
import java.util.ArrayList;
import java.util.List;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Ranking {

    List<Jogador> rank = new ArrayList<>();

    private void imprime() {
        System.out.println("Lista do rank: ");
        for (Jogador j : rank) {
            System.out.println(j.getNome() + " - " + j.getIdade() + " - ");
        }
    }

    public void add(Jogador jogador) {
        rank.add(jogador);
    }

    public List<Jogador> getRank() {
        return rank;
    }
}
