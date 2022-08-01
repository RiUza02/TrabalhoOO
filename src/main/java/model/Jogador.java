package model;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    202065091ab

public class Jogador {

    private final Campo campo;
    String nome;
    int pontos;

    public Jogador(int quantidadeNavio) {
        campo = new Campo(quantidadeNavio);
        campo.imprime();
        pontos = 0;
        nome = "nameless";
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return this.pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void pontosAdd() {
        this.pontos++;
    }

    public void atirar(int x, int y) {
        campo.atirar(x, y);
    }

    public Campo getCampo() {
        return campo;
    }

    public void imprime() {
        campo.imprimeMapaJogador();
    }

    public boolean achouTudo() {
        return campo.achouTudo();
    }
}
