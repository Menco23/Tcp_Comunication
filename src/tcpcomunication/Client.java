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
    Socket socket;
    public static final String BLUE = "\u001B[36m";
    public static final String RESET = "\u001B[0m";



    public Client(String nome){
        this.nome = nome;

    }

    public void connetti(String S, int portaServer){
        try {
            socket = new Socket(S, portaServer);
            System.out.println(BLUE + "Connessione al server avvenuta"+ RESET);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(BLUE +"Errore: Connessione con server non avvenuta"+ RESET);
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
            System.out.println(BLUE +"\n Ricevuto il messaggio: " + messaggio + RESET);
        } catch(IOException ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(BLUE +"\n Errore: Messaggio non ricevuto"+ RESET);
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
                System.out.println(BLUE +"\n Chiusura socket avvenuta"+ RESET);
            } catch (IOException e) {
                System.err.println(BLUE +"\n Errore nella chiusura con il client"+ RESET);
            }
        } else {
            System.out.println(BLUE +"\n Il Socket non è stato istanziato"+ RESET );
        }
    }
}