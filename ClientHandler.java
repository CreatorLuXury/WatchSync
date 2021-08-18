package pl.krakow.up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Random;

public class ClientHandler extends Thread {

    private Socket client;
    private PrintWriter clientOut;
    private BufferedReader clientIn;

    public ClientHandler(Socket s){
        this.client = s;
        System.out.println("Nowe połązcenie z " + s.getInetAddress());
    }

    @Override
    public void run() {
//        super.run();
        try{
            clientIn = new BufferedReader( new InputStreamReader( client.getInputStream(),"UTF-8"));
            clientOut = new PrintWriter(client.getOutputStream(), true);

            boolean work = true;
            String line;

            while (work){
                clientOut.println("1) Akutalny czas\n" +
                                    "2) losowa liczba\n" +
                                    "3) podaj dowolną treść\n" +
                                    "e) zakończenie połączenia\n" +
                                    "wybierz opcję\n ");
                clientOut.println("");
                line = clientIn.readLine();
                switch (line){
                    case "1":
                        clientOut.println(LocalDateTime.now());
                        break;
                    case "2":
                        Random rand = new Random();
                        clientOut.println("wylosowana liczba " + rand.nextInt());
                        break;
                    case "3":
//                        clientOut.println("Podaj dowolny tekst (pusta linia oznacza koniec wiadomości)");
//                        String message = "";
//                        do {
//                            message = clientIn.readLine();
//                            System.out.println(message);
//                        }while (!message.isEmpty());
//                        clientOut.println("Dziękuje za wysłanie wiadomości");
                        break;
                    case "e":
                        work = false;
                        clientOut.println("Bey");
                        break;
                    default:
                        clientOut.println("nie wybrano opcji");
                        break;
                }

            }
            clientDisconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientDisconnect(){
        try{
            clientOut.close();
            clientIn.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
