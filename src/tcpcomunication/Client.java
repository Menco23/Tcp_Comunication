package tcpcomunication;

import java.io.*;
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
public class  Client {

    String nome;
    String colore;
    Socket socket;

    public Client(String nome){
        this.nome = nome;
        this.colore = colore;

    }

    public void connetti(String S, int portaServer){
        try {
            socket = new Socket(S, portaServer);
            System.out.println("Connessione al server avvenuta");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Connessione con server non avvenuta");
        }

    }
    public void leggi() {
        InputStream i;
        BufferedReader br;
        String messaggio;

        try {
            i=socket.getInputStream();
            br=new BufferedReader(new InputStreamReader(i));
            messaggio=br.readLine();
            System.out.println("Ricevuto il messaggio: " + messaggio);
        } catch(IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore: Messaggio non ricevuto");
        }
    }

    public void scrivi() {
        OutputStream os;
        BufferedWriter bw;
        String mess="Client attivo";
        try{
            os=socket.getOutputStream();
            bw=new BufferedWriter(new OutputStreamWriter(os));
            bw.write(mess);
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chiudi() {
        if (socket!=null) {
            try {
                socket.close();
                System.out.println("\n Chiusura socket avvenuta");
            } catch (IOException e) {
                System.err.println("Errore nella chiusura con il client");
            }
        } else {
            System.out.println("Il Socket non è stato istanziato");
        }
    }
}