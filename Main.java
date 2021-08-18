package pl.krakow.up;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static boolean runServer;
    public static Multiserver mServer;

    public static void main(String[] args) {
	// write your code here

        runServer = true;

		// uruchomienie aplikacji obsługującej pojędyńczego klienta 
//        SimpleServer sServer = new SimpleServer();
//        sServer.stopServer();

		// uruchomienie aplikacji obsługującej wielu klientów 
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mServer = new Multiserver();
//            }
//        });
//        t.start();
//
//        Scanner s = new Scanner(System.in);
//        boolean work = true;
//        while (work){
//            System.out.println("1) zmień stan servera \n" +
//                    "2) sprawdz stan servera\n" +
//                    "3) zakończ pracę");
//            int i = s.nextInt();
//
//            switch (i){
//                case 1:
//                    System.out.println("Obecny stan " + runServer);
//                    runServer = false;
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    work = false;
//                    break;
//            }
//        }
//        System.out.println("Zakończyłem działanie aplikacji");


		// uruchomienie aplikacji klienckiej 
//        Client client = new Client("pmazurek.ddns.net", 450);
//        client.sendMessage();
//        client.stop();
    }

}
