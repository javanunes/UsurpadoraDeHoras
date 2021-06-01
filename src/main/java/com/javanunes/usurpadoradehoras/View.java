/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javanunes.usurpadoradehoras;
/**
 * @author ricardo
 */

public class View {
    public static void main(String[] parametros){
       Controller site = new Controller(); 
       System.out.println("\nAcertar o Horário, rode-me como Administrador \n\n");
       site.acertarHorario(site.getHoras());
    }
}
