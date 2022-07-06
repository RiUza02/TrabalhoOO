//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class trabalho {

    public static void main(String[] args) {
        System.out.println("Bem Vindo ao Jogo Batalha Naval!!");
        Jogo jogo = new Jogo();
        jogo.imprime();
        while (!jogo.encerrou()) {
            jogo.atirar();
            jogo.imprime();
        }
        System.out.println("FIM DE JOGO");
    }
}
