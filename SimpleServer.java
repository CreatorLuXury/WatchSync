package pl.krakow.up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter serverOut;
    private BufferedReader serverIn;

    public SimpleServer(){
        try{
            serverSocket = new ServerSocket(450);
            System.out.println("Oczekuje na klienta ...");
            clientSocket = serverSocket.accept();
            System.out.println("klient połączony z " + clientSocket.getInetAddress());
            serverOut = new PrintWriter(clientSocket.getOutputStream(), true);
            serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            serverOut.write("Podaj dowolny tekst\n");
//            String line = serverIn.readLine();
            while (true) {
                String line = serverIn.readLine();
                if (line.equals("e")){
                    System.out.println("Klient zakończył połązcenie");
                    break;
                }else{
                    System.out.println("treść od użtkownika" + line);
                    serverOut.write("możesz podać następną tresć\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer(){
        try{
            serverOut.close();
            serverIn.close();
            if (!clientSocket.isClosed()){
                clientSocket.close();
            }
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
