/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanunes.usurpadoradehoras;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element; 
import org.jsoup.select.Elements;
/**
 *
 * @author ricardo
 */
public class Controller {
    
   public String getHoras(){
        String horas="xx:xx:xx";
        try{
            // Usa o Jsoup para pegar o conteudo do site
            Document htmlPorID = Jsoup.connect("https://www.horariodebrasilia.org/").get();
            //pega o valor entre a tag html que tenha o id relogio
            Elements htmlValores = htmlPorID.select("#relogio");
            // não precisa de for nesse caso mas irei usar para quem quiser pegar elementos com ids iguais em outros sites
            for (Element htmlValorUnico : htmlValores) {
              // pega o valor da tag que tem o horário no site e joga para  variavel horas  
              horas = htmlValorUnico.html();  
            }
            return horas;
        }
        catch(Exception e){
           // se der erro, retorna horario xx:xx:xx 
           return horas; 
        }
    }
   
    public void acertarHorario(String horas){
        try{
          if(!horas.isEmpty()){  
            Runtime.getRuntime().exec("cmd /c time "+horas);
            System.out.printf("No Brasil são %s horas\n",horas) ;
          }
          else{
           System.out.println("Amor, você não mandou a hora para eu acertar, saindo...");
          } 
        }
        catch(Exception e){
          System.out.println("Erro ao obter o horário, você deve rodar esse app como administrador!");  
        }
    }
}
