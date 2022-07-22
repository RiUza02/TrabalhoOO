package IA;

import model.Campo;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class BotInteligente extends Bot {

    private final Campo campo;
    private int x;
    private int y;
    private int tamanhoNavio;
    private int comportamento;
    private int DislocamentoTiros;
    private int qTirosCertos;

    public BotInteligente(int quantidadeNavio) {
        campo = new Campo(quantidadeNavio);
        comportamento = 0;
        DislocamentoTiros = 0;
    }

    @Override
    public void atirar() {
        switch (comportamento) {
            case 0 -> {
                atirarAleatorio();
            }
            case 1 -> {
                atirarEsquerda(x - DislocamentoTiros, y);
            }
            case 2 -> {
                atirarDireita(x + DislocamentoTiros, y);
            }
            case 3 -> {
                atiraCima(x, y - DislocamentoTiros);
            }
            case 4 -> {
                atiraBaixo(x, y + DislocamentoTiros);
            }
        }
        if (qTirosCertos == tamanhoNavio) {
            comportamento = 0;
            DislocamentoTiros = 0;
            qTirosCertos = 0;
        }
    }

    @Override
    public void imprime() {
        campo.imprimeMapaJogador();
    }

    @Override
    public boolean achouTudo() {
        return campo.achouTudo();
    }

    @Override
    public Campo getCampo() {
        return campo;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    //-----------------------------------------------------------------------------
    private void atirarAleatorio() {
        x = (int) Math.round((Math.random() * 9));
        y = (int) Math.round((Math.random() * 9));
        if (campo.getMapaPosicaoJogador(x, y) == 0) {
            campo.atirar(x, y);
            if (campo.getMapaPosicaoJogador(x, y) != -1) {
                comportamento = 1;
                DislocamentoTiros++;
                qTirosCertos++;
                tamanhoNavio = campo.getMapaPosicaoJogador(x, y);
            }
        } else {
            atirarAleatorio();
        }
    }

    private void atirarEsquerda(int x, int y) {
        if ((x >= 0) && (campo.getMapaPosicaoJogador(x, y) != -1)) {
            campo.atirar(x, y);
            this.x = x;
            this.y = y;
            if (campo.getMapaPosicaoJogador(x, y) != -1) {
                DislocamentoTiros++;
                qTirosCertos++;
            } else {
                comportamento = 2;
                DislocamentoTiros = 1;
            }
        } else {
            comportamento = 2;
            DislocamentoTiros = 1;
        }
    }

    private void atirarDireita(int x, int y) {
        if ((x <= 9) && (campo.getMapaPosicaoJogador(x, y) != -1)) {
            campo.atirar(x, y);
            this.x = x;
            this.y = y;
            if (campo.getMapaPosicaoJogador(x, y) != -1) {
                DislocamentoTiros++;
                qTirosCertos++;
            } else {
                comportamento = 3;
                DislocamentoTiros = 1;
            }
        } else {
            comportamento = 3;
            DislocamentoTiros = 1;
        }
    }

    private void atiraCima(int x, int y) {
        if ((y >= 0) && (campo.getMapaPosicaoJogador(x, y) != -1)) {
            campo.atirar(x, y);
            this.x = x;
            this.y = y;
            if (campo.getMapaPosicaoJogador(x, y) != -1) {
                DislocamentoTiros++;
                qTirosCertos++;
            } else {
                comportamento = 4;
                DislocamentoTiros = 1;
            }
        } else {
            comportamento = 4;
            DislocamentoTiros = 1;
        }
    }

    private void atiraBaixo(int x, int y) {
        if ((y <= 9) && (campo.getMapaPosicaoJogador(x, y) != -1)) {
            campo.atirar(x, y);
            this.x = x;
            this.y = y;
            if (campo.getMapaPosicaoJogador(x, y) != -1) {
                DislocamentoTiros++;
                qTirosCertos++;
            }
        } else {
            comportamento = 0;
        }
    }
}