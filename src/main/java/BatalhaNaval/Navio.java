package BatalhaNaval;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Navio {

    private final int tamanho;
    private final int direcao;
    private int xPosicao;
    private int yPosicao;

    public Navio() {
        tamanho = (int) Math.round((Math.random() * 3 + 2));
        direcao = (int) (Math.round(Math.random()));
    }

    int getTamanho() {
        return tamanho;
    }

    public void setx(int posicao) {
        xPosicao = posicao;
    }

    public void sety(int posicao) {
        yPosicao = posicao;
    }

    public int getx() {
        return xPosicao;
    }

    public int gety() {
        return yPosicao;
    }

    public int GetDirecao() {
        return direcao;
    }
}
