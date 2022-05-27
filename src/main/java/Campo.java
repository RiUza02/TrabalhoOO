
import java.util.*;

public class Campo {

    private static final int t = 10; //tamanho do campo (caso queira ajustar depois)
    private static final int agua = 0; //simbulo que representara agua
    private static int quantidadeNavio = 3; //quantidade de navios a ser colocada no mapa
    private int[][] mapa; //mapa que sera manipulado pelo programa
    private int[][] mapaJogador; //mapa que sera manipulado pelo jogador
    private int jogadas; //jogadas permitidas
    private Scanner teclado = new Scanner(System.in);

    public Campo() {
        mapa = new int[t][t];
        mapaJogador = new int[t][t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                mapa[i][j] = agua;
                mapaJogador[i][j] = agua;
            }
        }
        addNavio();
    }

    public void setDificuldade(int i) {
        //(fazer dps)
    }

    public void imprime() {
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                System.out.print(mapa[i][j] + "  "); //ajustar qual mapa sera imprimido depois
            }
            System.out.println();
        }
    }

    public void atirar() {
        System.out.println("informe as coodenadas");
        System.out.print("x: ");
        int x = teclado.nextInt();
        System.out.println();
        System.out.print("y: ");
        int y = teclado.nextInt();
        if (verificaNavio(x, y) != agua) {
            mapaJogador[x][y] = verificaNavio(x, y);
        } else {
            mapaJogador[x][y] = -1;
        }
    }
//------------------------------------------------------------------------------------------------

    private int verificaNavio(int x, int y) {
        return mapa[x][y];
    }

    private void addNavio() {
        Navio[] navio = new Navio[quantidadeNavio];
        int direcao;
        int c = 0;
        while (c < quantidadeNavio) {
            navio[c] = new Navio();
            navio[c].setx(nAleatorio());
            navio[c].sety(nAleatorio());
            direcao = (int) (Math.round(Math.random()));
            if (verificaNavioPosicao(navio[c], direcao)) {
                switch (direcao) {
                    case 0 -> {
                        for (int i = 0; i < navio[c].getTamanho(); i++) {
                            mapa[navio[c].getx() + i][navio[c].gety()] = navio[c].getTamanho();
                        }
                        c++;
                    }

                    case 1 -> {
                        for (int i = 0; i < navio[c].getTamanho(); i++) {
                            mapa[navio[c].getx()][navio[c].gety() + i] = navio[c].getTamanho();
                        }
                        c++;
                    }
                }
            }
        }
    }

//0 = na horizontal
//1 = vertical
    private boolean verificaNavioPosicao(Navio navio, int direcao) {
        switch (navio.getTamanho()) {
            case 2 -> {

            }

            case 3 -> {

            }

            case 4 -> {

            }

            case 5 -> {
                switch (direcao) {
                    case 0 -> {
                        if (navio.getx() + 4 < t) {
                            for (int i = 0; i < 5; i++) {
                                if (mapa[navio.getx() + i][navio.gety()] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                    case 1 -> {
                        if (navio.gety() + 4 < t) {
                            for (int i = 0; i < 5; i++) {
                                if (mapa[navio.getx()][navio.gety() + i] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }

                }
                return false;
            }

        }
        return false;
    }

    private int nAleatorio() {
        return (int) Math.round((Math.random() * (t - 1)));
    }
}
