/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Outros;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author victo
 */
public class LeituraArquivo {
    
    void LeArquivo(){
        try{
            String texto = Arquivo.lerArquivo("local");
            System.out.println(texto);
        } catch (FileNotFoundException e){
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
        
        String conteudo;
        Scanner Teclado = new Scanner(System.in);
        conteudo = Teclado.nextLine();
        Arquivo.escreverArquivo("local", conteudo);
    }
}
