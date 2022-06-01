
import java.util.*;

public class Campo {

    private static final int t = 10; //tamanho do campo (caso queira ajustar depois)
    private static final int agua = 0; //simbulo que representara agua
    private final Scanner teclado = new Scanner(System.in);
    private static int quantidadeNavio = 10; //quantidade de navios a ser colocada no mapa
    private int[][] mapa; //mapa que sera manipulado pelo programa
    private int[][] mapaJogador; //mapa que sera manipulado pelo jogador
    private Navio[] navio = new Navio[quantidadeNavio];

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

    public static void quantidadeNavio(int n) {
        quantidadeNavio = n;
    }

    /* public void imprime() {
        System.out.print("   ");
        for (int i = 1; i < 11; i++) {
            System.out.print(i + "  ");
        }
        System.out.println("");
        for (int i = 0; i < t; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < t; j++) {
                System.out.print(mapa[i][j] + "  ");
            }
            System.out.println();
        }
    }*/
    public void imprimeMapaJogador() {
        System.out.print("    ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + "  ");
        }
        System.out.println("");
        for (int i = 0; i < t; i++) {
            if (i + 1 == 10) {
                System.out.print((i + 1) + "| ");
            } else {
                System.out.print((i + 1) + "|  ");
            }
            for (int j = 0; j < t; j++) {
                if (mapaJogador[i][j] == -1) {
                    System.out.print(mapaJogador[i][j] + " ");
                } else {
                    System.out.print(mapaJogador[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public void atirar() {
        System.out.println("informe as coodenadas:");
        System.out.print("x: ");
        int x = teclado.nextInt();
        System.out.println();
        System.out.print("y: ");
        int y = teclado.nextInt();
        if (verificaNavio(y, x) != agua) {
            mapaJogador[y][x] = verificaNavio(x, y);
        } else {
            mapaJogador[y][x] = -1;
        }
    }

//------------------------------------------------------------------------------------------------
    private int verificaNavio(int x, int y) {
        return mapa[x][y];
    }

    private void addNavio() {
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
                switch (direcao) {
                    case 0 -> {
                        if (navio.getx() + 1 < t) {
                            for (int i = 0; i < 2; i++) {
                                if (mapa[navio.getx() + i][navio.gety()] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                    case 1 -> {
                        if (navio.gety() + 1 < t) {
                            for (int i = 0; i < 2; i++) {
                                if (mapa[navio.getx()][navio.gety() + i] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }

                    }
                }
            }
            case 3 -> {
                switch (direcao) {
                    case 0 -> {
                        if (navio.getx() + 2 < t) {
                            for (int i = 0; i < 3; i++) {
                                if (mapa[navio.getx() + i][navio.gety()] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                    case 1 -> {
                        if (navio.gety() + 2 < t) {
                            for (int i = 0; i < 3; i++) {
                                if (mapa[navio.getx()][navio.gety() + i] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }

                    }

                }
            }

            case 4 -> {
                switch (direcao) {
                    case 0 -> {
                        if (navio.getx() + 3 < t) {
                            for (int i = 0; i < 4; i++) {
                                if (mapa[navio.getx() + i][navio.gety()] != agua) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                    case 1 -> {
                        if (navio.gety() + 3 < t) {
                            for (int i = 0; i < 4; i++) {
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
