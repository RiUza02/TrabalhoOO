package model;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab
public class Jogador {

    private final Campo campo;
    String nome;
    int pontos, idade;
    
    public Jogador(int quantidadeNavio) {
        campo = new Campo(quantidadeNavio);
        campo.imprime();
        pontos = 0;
    }

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

    public void pontosAdd () {
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
