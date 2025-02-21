/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcomunication;

/**
 *
 * @author mencu
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client c = new Client("Tommaso");
        c.connetti("localhost", 2006);
        c.scrivi();
        c.leggi();
        c.chiudi();
    }
    
}
