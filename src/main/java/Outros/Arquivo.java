package Outros;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.Jogador;
//yuri Alexsander Sudre Almeida Souza   202065512b
//Rafaela da Silva Cunha    202065509b
//Victor Aluisio dos Santos Oliveira    20206509ab

public class Arquivo {

    public static ArrayList<String> lerArquivo(String caminho) throws FileNotFoundException {
        ArrayList<String> conteudo = new ArrayList<String>();
        File arquivo = new File(caminho);
        Scanner leitor = new Scanner(arquivo);

        while (leitor.hasNextLine()) {
            conteudo.add(leitor.nextLine() + '\n');
        }
        return conteudo;
    }

    public static void escreverArquivo(String caminho, ArrayList<Jogador> conteudo) {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
        try {
            File arquivo = new File(caminho);
            fwArquivo = new FileWriter(arquivo, false);
            bwArquivo = new BufferedWriter(fwArquivo);

            for (int i = 0; i < 10; i++) {
                bwArquivo.write(conteudo.get(i).getNome() + "_____" + conteudo.get(i).getPontos() + '\n');
            }

            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao tentar Escrever no arquivo: " + e.toString());
        }
    }

}
