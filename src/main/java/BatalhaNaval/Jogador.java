package BatalhaNaval;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

import java.util.*;

public class Jogador {

    private final Campo campo;
    private final Scanner teclado = new Scanner(System.in);
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    int idade;

    public Jogador(int quantidadeNavio) {
        campo = new Campo(quantidadeNavio);
    }

    public void atirar() {
        System.out.println("Imforme as coordenadas do disparo");
        System.out.print("x: ");
       int x = teclado.nextInt();
        System.out.println();
        System.out.print("y: ");
       int y = teclado.nextInt();
        campo.atirar(x, y);
    }

    void imprime() {
        campo.imprimeMapaJogador();
    }

    boolean achouTudo() {
        return campo.achouTudo();
    }
}
