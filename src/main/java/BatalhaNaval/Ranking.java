package BatalhaNaval;

import java.util.ArrayList;
import java.util.List;

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
