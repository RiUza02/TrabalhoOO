package Outros;

import java.io.FileNotFoundException;
import java.util.Scanner;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class LeituraArquivo {

    void LeArquivo() {
        try {
            String texto = Arquivo.lerArquivo("local");
            System.out.println(texto);
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
        String conteudo;
        Scanner Teclado = new Scanner(System.in);
        conteudo = Teclado.nextLine();
        Arquivo.escreverArquivo("local", conteudo);
    }
}
