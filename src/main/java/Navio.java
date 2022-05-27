
public class Navio {

    private final int tamanho;
    private int xPosicao;
    private int yPosicao;

    public Navio() {
        tamanho = (int) Math.round((Math.random() * 3 + 2));
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
}
