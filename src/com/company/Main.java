package com.company;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        Socket s;

        for (int i = 0; i < 65536; i++) {

            try {
                s = new Socket(args[0], i);
                System.out.println("Port open " + i);

            } catch (IOException e) {
                //System.out.println("err");
            }
        }

    }
}
