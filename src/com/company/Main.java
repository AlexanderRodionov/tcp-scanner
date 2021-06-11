package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import java.util.*;

public class Main {


    public static void main(String[] argv) throws IOException, InterruptedException {

        Properties props = new Properties();
        props.load(new FileInputStream("src/logs/log4j.properties"));
        PropertyConfigurator.configure(props);

        List<Result> results = Collections.synchronizedList(new ArrayList<>());
        CommandLineArgumentParser cap = new CommandLineArgumentParser(argv);
        cap.parse();

        String[] hosts = cap.hosts.toArray(new String[0]);
        String[] ports = new String[cap.ports.size()];
        for (int i = 0; i < cap.ports.size(); i++) {
            ports[i] = cap.ports.get(i).toString();
        }
        int threads = cap.threads;

        hosts[0] = "yandex.ru";



        new PortScanner().start(hosts, ports, threads, results);
    }

}
