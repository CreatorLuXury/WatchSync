package pl.krakow.up;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Multiserver {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int port;

    public Multiserver(int port){
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Czekam na połączenia od klientów");
            while (Main.runServer){
                new ClientHandler(serverSocket.accept()).start();
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
