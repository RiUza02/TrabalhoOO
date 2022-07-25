/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Outros;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import model.Jogador;

/**
 *
 * @author victo
 */
public class JSON {
    
    public static String toJSON(Jogador jogador){
        Gson gson = new Gson();
        String json = gson.toJson(jogador);
        return json;
    }
    
    public static String toJSON(List<Jogador> jogadores){
        Gson gson = new Gson();
        String json = gson.toJson(jogadores);
        return json;
    }
    
    public static Jogador toJogador(String conteudo){
        Gson gson = new Gson();
        Jogador jogador = gson.fromJson(conteudo, Jogador.class);
        
        return jogador;
    }
    
    public static List<Jogador> toJogadores(String conteudo){
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Jogador>>() {
        }.getType();
        List<Jogador> jogadores = gson.fromJson(conteudo, pessoasTipo);
        
        return jogadores;
    }
}
