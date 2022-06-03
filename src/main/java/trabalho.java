
public class trabalho {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        int comecar;
        int cont = 0;
        System.out.println("Bem Vindo ao Jogo Batalha Naval!!");
        jogo.jogo();
        System.out.println("Para começar o jogo digite 1");
        Scanner teclado = new Scanner(System.in);
        comecar = teclado.nextLine();
        if(comecar == 1)
        {
            while ( jogo . Encerrou ( cont ) != true )
            {
                jogo . imprime ();
                jogo . atirar ();
                cont ++;
                System.out.println("Você ainda tem" + jogo.getJogadas()"jogadas");
            }
        }
        else
        {
            System.out.println("Comando inválido!!");
        }
    }
}
