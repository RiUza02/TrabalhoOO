
import java.util.*;

public class Campo {
// 0 = lugar desconhecido
// -1 = agua
// diferente = navio

    private static int[][] mapa;
    private static int[][] mapaJogador;
    private static int quantidadeNavio = 0;
    private static int jogadas;
    private Scanner teclado = new Scanner(System.in);

    public Campo() {
        mapa = new int[10][10];
        mapaJogador = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapa[i][j] = 0;
                mapaJogador[i][j] = 0;
            }
        }
        addNavio();
    }

    public void setDificuldade(int i) {
        //jogadas = (fazer dps)
    }

    public void imprime() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(mapa[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void atirar() {
        System.out.println("informe as coodenadas: ");
        int x = teclado.nextInt();
        int y = teclado.nextInt();
        if (verificaNavio(x, y) != 0) {
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
        Navio navio = new Navio();
        int gerador = (int) Math.round(Math.random());
        for (int j = 0; j < quantidadeNavio; j++) {
            if (gerador == 0) {
                if (verificaNavioPosicao(navio.getTamanho(), gerador)) {
                    if (gerador == 0) {
                        for (int i = 0; i < navio.getTamanho(); i++) {
                            mapa[navio.getx() + i][navio.gety()] = navio.getTamanho();
                        }
                    } else {
                        if (gerador == 1) {
                            for (int i = 0; i < navio.getTamanho(); i++) {
                                mapa[navio.getx()][navio.gety() + i] = navio.getTamanho();
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean verificaNavioPosicao(int tamanho, int direcao) {
        switch (tamanho) {
            case 2: {
                break;
            }

            case 3: {
                break;
            }

            case 4: {
                break;
            }

            case 5: {
                break;
            }
        }
    }

    private int nAleatorio() {
        return (int)  Math.round((Math.random() * 9)) ;
    }
}
