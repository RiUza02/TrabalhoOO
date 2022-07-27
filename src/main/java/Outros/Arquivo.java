package Outros;

import java.io.*;
import java.util.Scanner;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Arquivo {

    public static String lerArquivo(String caminho) throws FileNotFoundException {
        StringBuilder conteudo = new StringBuilder();
        File arquivo = new File(caminho);
        Scanner leitor = new Scanner(arquivo);

        while (leitor.hasNextLine()) {
            conteudo.append(leitor.nextLine()).append('\n');
        }
        return conteudo.toString();
    }

    public static void escreverArquivo(String caminho, String conteudo) {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
        try {
            File arquivo = new File(caminho);
            fwArquivo = new FileWriter(arquivo, false);
            bwArquivo = new BufferedWriter(fwArquivo);

            bwArquivo.write(conteudo + '\n');

            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao tentar Escrever no arquivo: " + e.toString());
        }
    }

}
