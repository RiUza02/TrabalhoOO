
public class trabalho {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        int cont = 0;
        
        while(jogo.Encerrou(cont) != true){
            jogo.imprime();
            jogo.atirar();
            cont++;
        }
        
        jogo.imprime();
        System.out.println("FIM DE JOGO");
    }
}
