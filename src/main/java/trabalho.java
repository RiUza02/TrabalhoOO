
import java.util.*;

public class trabalho {

    public static void main(String[] args) {
        Campo jogo = new Campo();
        jogo.imprime();
        
        System.out.println("");
        System.out.println("_____________________________________________");
        System.out.println("");
        
        jogo.imprimeMapaJogador();
        
        while(true){
        System.out.println("");
        System.out.println("_____________________________________________");
        System.out.println("");
        
        jogo.atirar();
        
        jogo.imprimeMapaJogador();
        }
    }
}
