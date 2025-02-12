package tcpcomunication;

import java.net.ConnectException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
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
public class Client {
    String nome;
    String colore;
    Socket socket;
    
    public Client(String nome, String colore){
        this.nome=nome;
        this.colore=colore;
    }
    
    public void connetti(String nomeServer, int porta){
        try {
            socket = new Socket(nomeServer, porta);
            System.out.println("1) CONNESSIONE AVVENUTA CON IL SERVER");
        } catch(ConnectException ex){
            System.out.println("errore connessione Server");
        } catch(UnknownHostException ex){
            System.out.println("errore risoluzione del nome");
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERRORE NELLA CONNESSIONE");
        }
        }
    
     public void leggi() {
       InputStream i;
        try {
            i = socket.getInputStream();
            i.read();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void scrivi() {
         try {
             OutputStream o = socket.getOutputStream();
             o.write(1);
             o.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void chiudi(){
        if(socket!=null){
            try{
                socket.close();
                System.out.println("4) CHIUSURA DELLA CONNESSIONE CON IL SERVER");
            }
            catch(ConnectException ex){
            System.err.println("ERRORE: SERVER NON CONNESSO");
            }
            catch(IOException ex){
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}