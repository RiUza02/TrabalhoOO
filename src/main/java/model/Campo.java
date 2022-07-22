package model;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab
public class Campo {

    private static final int t = 10; //tamanho do campo (caso queira ajustar depois)
    private static final int agua = 0; //simbulo que representara agua
    private static int quantidadeNavio; //quantidade de navios a ser colocada no mapa
    private final int[][] mapaJogador; //mapa que sera manipulado pelo jogador
    private final int[][] mapa; //mapa que sera manipulado pelo programa
    private static Navio[] navio;

    public Campo(int quantidadeNavio) {
        this.quantidadeNavio = quantidadeNavio;
        navio = new Navio[this.quantidadeNavio];
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

    public void imprime() {
        System.out.print("    ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i) + "  ");
        }
        System.out.println("");
        for (int i = 0; i < t; i++) {
            System.out.print((i) + "| ");
            for (int j = 0; j < t; j++) {
                System.out.print(mapa[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void imprimeMapaJogador() {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((i) + "  ");
        }
        System.out.println("");
        for (int i = 0; i < t; i++) {
            System.out.print((i) + "| ");
            for (int j = 0; j < t; j++) {
                if (mapaJogador[i][j] == -1) {
                    System.out.print(mapaJogador[i][j] + " ");
                } else {
                    System.out.print(mapaJogador[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void atirar(int x, int y) {
        if (mapa[y][x] == agua) {
            mapaJogador[y][x] = -1;
        } else {
            mapaJogador[y][x] = mapa[y][x];
        }
    }

    public boolean achouTudo() {
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (mapa[i][j] != 0){
                    if(mapa[i][j] != mapaJogador[i][j])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int getMapaPosicaoJogador(int x, int y) {
        return mapaJogador[y][x];
    }

    public int getMapaPosicao(int x, int y) {
        return mapa[y][x];
    }
    //------------------------------------------------------------------------------------------------

    private void addNavio() {
        int c = 0;
        while (c < quantidadeNavio) {
            navio[c] = new Navio();
            navio[c].setx(nAleatorio());
            navio[c].sety(nAleatorio());
            if (verificaNavioPosicao(navio[c], navio[c].GetDirecao())) {
                switch (navio[c].GetDirecao()) {
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
