/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcomunication;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mencu
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server(2006);
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di client con la quale si vuole realizzare una comunicazione TCP: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            num = Integer.parseInt(br.readLine());
            System.out.println("Numero inserito con successo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for(int i=0; i<num; i++){
        s.attendi();
        s.leggi();
        s.scrivi();
        s.chiudi();
    }
        s.termina();
    }
}