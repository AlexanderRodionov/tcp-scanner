package com.company;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] argv) throws IOException {


/*
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        Thread thread3 = new Thread();

        thread1.start();
        thread2.start();
        thread3.start();


 */

        List<String> res = new ArrayList<>();
        List<Result> results = Collections.synchronizedList(new ArrayList<>());
        //StringBuilder sb = new StringBuilder();


        String ip = "127.0.0.1";
        String port = "135";
        int timeOut = 100;

        //ScanThread sT = new ScanThread(ip, port, timeOut, res);
        //sT.run();


        System.out.println(res);

        //Client c = new Client();
        //c.startConnection(ip, port);
        //c.sendMessage("test msg");
        //c.stopConnection();

        //System.out.println(c.sendMessage("testmsg 2").length());




        /*



        CommandLineArgumentParser parser = new CommandLineArgumentParser(argv);
        parser.parse();

        System.out.println("\n\n");
        System.out.println(parser.hosts);
        System.out.println(parser.ports);
        System.out.println(parser.threads);


        Socket s;


        for (String h : parser.hosts) {
            for (Integer p : parser.ports) {
                try {
                    s = new Socket(h, p);
                    System.out.println("Port open " + p + " on " + h);

                } catch (IOException e) {
                    System.out.println("!");

                }
            }

        }

         */



    }

}
