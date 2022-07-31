package Outros;

import java.io.FileNotFoundException;
import model.Jogador;
import java.util.ArrayList;
import java.util.List;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Ranking {

    public static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    public static Jogador jogador;
    public static Arquivo arq = new Arquivo();

    public Ranking(Jogador jogador) {

        this.jogador = jogador;

        //ArrayList<String> jogadoresss = new ArrayList<String>();
        ArrayList<String> conteudo;

        try {

            conteudo = arq.lerArquivo("C:\\Users\\victo\\OneDrive\\Área de Trabalho\\AAAAA.txt");

            for (int i = 0; i < 11; i++) {

                String nomeNull = "NULL";
                int pontoNull = 0;

                Jogador nulo = new Jogador(0);
                nulo.setNome(nomeNull);
                nulo.setPontos(pontoNull);

                jogadores.add(nulo);

            }
            for (int j = 0; j < conteudo.size(); j++) {

                String S = conteudo.get(j); 
                String[] C = S.split("_____");
                String[] G = C[1].split("\n");
                jogadores.get(j).setNome(C[0]);
                jogadores.get(j).setPontos(Integer.parseInt(G[0]));

            }
            jogadores.add(jogador);
            ordenaJogadorePontos(jogadores, jogadores.size());
            salvaRank();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }

    }

    public static void ordenaJogadorePontos(ArrayList<Jogador> jog, int quantidade) {

        int menorIndice;
        for (int i = 0; i < jog.size(); i++) {

            menorIndice = i;
            for (int j = i + 1; j < jog.size(); j++) {
                if (jog.get(i).getPontos() < jog.get(j).getPontos()) {
                    menorIndice = j;
                }
            }

            trocaPessoas(jog, menorIndice, i);

        }
    }

    public static void trocaPessoas(ArrayList<Jogador> jog, int origem, int destino) {

        String stringAux = jog.get(origem).getNome();
        jog.get(origem).setNome(jog.get(destino).getNome());
        jog.get(destino).setNome(stringAux);

        int intAux = jog.get(origem).getPontos();
        jog.get(origem).setPontos(jog.get(destino).getPontos());
        jog.get(destino).setPontos(intAux);

    }

    public static void salvaRank() {

        Arquivo arq = new Arquivo();

        arq.escreverArquivo("C:\\Users\\victo\\OneDrive\\Área de Trabalho\\AAAAA.txt", jogadores);

    }

   /* public static void main(String[] args) {

        /*Jogador A = new Jogador(2);
        Jogador B = new Jogador(2);
        Jogador C = new Jogador(2);

        A.setNome("Marc");
        A.setPontos(500);

        B.setNome("Vann");
        B.setPontos(765);

        C.setNome("Bern");
        C.setPontos(212);

        jogadores.add(A);
        jogadores.add(C);
        jogadores.add(B);

        Ranking rank = new Ranking(A);
        rank.ordenaJogadorePontos(jogadores, jogadores.size());

        for (int i = 0; i < 3; i++) {
            System.out.println(jogadores.get(i).getNome() + " - " + jogadores.get(i).getPontos());
        }

        rank.salvaRank();*/
       /*

        try {

            conteudo = arq.lerArquivo("C:\\Users\\victo\\OneDrive\\Área de Trabalho\\AAAAA.txt");

            String S = conteudo.get(0);
            String[] C = S.split("_____");
            System.out.println(C[0]);
            System.out.println(C[1]);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }

    }

}*/
