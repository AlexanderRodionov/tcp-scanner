package com.company;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] argv) throws IOException {

        CommandLineArgumentParser parser = new CommandLineArgumentParser(argv);
        parser.parse();

        System.out.println("\n\n");
        System.out.println(parser.hosts);
        System.out.println(parser.ports);
        System.out.println(parser.threads);

        /*
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
