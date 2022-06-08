//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab
import java.util.*;

public class Jogo {

    private int quantidadeJogadas;
    private char dificuldade;
    private int quantidadeNavio;
    private Campo campo;
    private final Scanner teclado = new Scanner(System.in);

    public Jogo() {
        setConfig();
        campo = new Campo(quantidadeNavio);
    }

    public void atirar() {
        if (campo.atirar()) {
    }
            quantidadeJogadas--;
        }

    public void imprime() {
        campo.imprimeMapaJogador();
    }

    public int getJogadas() {
        return quantidadeJogadas;
    }


    private void setConfig() {
        int flag1;
        char flag2;
        System.out.println("""
                           Escolha a dificuldade: 
                           F: facil 
                           M: medio 
                           D: dificil""");
        flag2 = Character.toUpperCase(teclado.next().charAt(0));
        if ((flag2 != 'F') || (flag2 != 'M') || (flag2 != 'D')) {
            dificuldade = flag2;
            System.out.println("Escolha a quantidade de alvos (entre 1 e 15)");
            flag1 = teclado.nextInt();
            if (flag1 >= 1 & flag1 <= 15) {
                quantidadeNavio = flag1;
                setJogadas(flag1);
            } else {
                System.out.println("Valor invalido!");
            }
        } else {
            System.out.println("Valor invalido!");
        }
    }

    private void setJogadas(int n) {
        switch (dificuldade) {
            case 'F': {
                quantidadeJogadas = n * 15;
                break;
            }

            case 'M': {
                quantidadeJogadas = n * 10;
                break;
            }

            case 'D': {
                quantidadeJogadas = n * 5;
                break;
            }
        }
    }
    
    public boolean encerrou() {
        return (this.quantidadeJogadas <= 0) || campo.achouTudo();
    }
    
}
