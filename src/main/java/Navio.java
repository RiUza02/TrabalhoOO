
public class Navio {

    private final int tamanho;
    private int xPosicao;
    private int yPosicao;
    private int direcao;

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
