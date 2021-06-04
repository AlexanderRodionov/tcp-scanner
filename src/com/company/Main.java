package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Provider;
import java.util.*;
//import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static Provider PropertyConfigurator;

    public static void main(String[] argv) throws IOException, InterruptedException {

        List<Result> results = Collections.synchronizedList(new ArrayList<>());
        //StringBuilder sb = new StringBuilder();
        CommandLineArgumentParser cap = new CommandLineArgumentParser(argv);
        cap.parse();

        String[] hosts = cap.hosts.toArray(new String[0]);
        String[] ports = new String[cap.ports.size()];
        for (int i = 0; i < cap.ports.size(); i++) {
            ports[i] = cap.ports.get(i).toString();
        }
        int threads = cap.threads;


        new PortScanner().start(hosts, ports, threads, results);
/*
        //connecting log4j settings
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/log4j.properties"));
        PropertyConfigurator.configure(String.valueOf(props));


 */

        //ScanThread sT = new ScanThread(ip, port, timeOut, res);
        //sT.run();
//
//
//        System.out.println(cap.hosts);
//        System.out.println(cap.ports);
//        System.out.println(cap.threads);


    }

}
