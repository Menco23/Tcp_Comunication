/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcomunication;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mencu
 */
public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;
    public static final String VERDE = "\u001B[38;2;0;255;204m";
    public static final String RESET = "\u001B[0m";
    
    public Server(int porta){
        this.porta=porta;
        try{
            serverSocket = new ServerSocket(porta);
            System.out.println(VERDE + " Server in Ascolto" + RESET);
        }
        catch(BindException ex) {
            System.out.println(VERDE + "\n porta occupata" + RESET);
        } catch(IllegalArgumentException ex) {
             System.out.println(VERDE + "\n numero di porta non valido" + RESET);
        }
        catch(IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(VERDE + "\n Errore nella fase di binding" + RESET);
        }
    }
    
        public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println(VERDE + "\n Connessione avvenuta con il client e data socket creato" + RESET);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(VERDE + "\n Poblemi di connessione con il client" + RESET);
        }
        return clientSocket;
        }
        
        public void leggi(){
           InputStream i;
        try {
            i = clientSocket.getInputStream();
            i.read();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void scrivi(){
            OutputStream o;
            BufferedWriter bw;
            String mess = "Server Attivo";
        try {
             o = clientSocket.getOutputStream();
             bw = new BufferedWriter(new OutputStreamWriter(o));
             bw.write(mess + "\n");
             bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        public void chiudi(){
        if(clientSocket!=null){
            try{
                clientSocket.close();
                System.out.println(VERDE + "\n Chiusura della connessione con il client" + RESET);
            }
            catch(IOException ex){
             Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
        public void termina(){
           try {
            serverSocket.close();
            System.out.println(VERDE + "\n chiusura Server" + RESET);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
  }