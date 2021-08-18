package pl.krakow.up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private Socket clientSocket;
    private PrintWriter clientOut;
    private BufferedReader clientIn;

    public Client(String host, int port){
        try {
            InetAddress address = InetAddress.getByName("pmazurek.ddns.net");
            clientSocket = new Socket(host,port);
            clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
            clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        String resp = null;
        String line = null;
        Scanner scan = new Scanner(System.in);

        while (true){
            try{
                do {
                    resp = clientIn.readLine();
                    System.out.println(resp);
                }while (!resp.isEmpty());
                line = scan.nextLine();
                if("e".equals(line)){
                    clientOut.println(line);
                    break;
                }else {
                    clientOut.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void stop(){
        try{
            System.out.println("Zamykanie połączenia");
            clientOut.close();
            clientIn.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Błąd podczas zamykania połączenia");
        }
    }

}
