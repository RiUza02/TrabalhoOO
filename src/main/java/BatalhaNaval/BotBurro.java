package BatalhaNaval;

//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class BotBurro extends Bot {

    private final Campo campo;

    public BotBurro(int quantidadeNavio) {
        campo = new Campo(quantidadeNavio);
    }

    @Override
    public void atirar() {
        int x = (int) Math.round((Math.random() * 9));
        int y = (int) Math.round((Math.random() * 9));
        if (campo.getMapaPosicaoJogador(x, y) == 0) {
            campo.atirar(x, y);
        } else {
            atirar();
        }
    }

    @Override
    public void imprime() {
        campo.imprimeMapaJogador();
    }

    @Override
    public boolean achoTudo() {
        return campo.achouTudo();
    }
}
