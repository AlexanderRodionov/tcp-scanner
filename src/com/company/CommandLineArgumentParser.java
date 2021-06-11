package com.company;

import java.util.ArrayList;
import java.util.List;

public class CommandLineArgumentParser {

    private static String[] argv;

    List<String> hosts = new ArrayList<>();
    List<Integer> ports = new ArrayList<>();
    int threads = 1;

    public CommandLineArgumentParser(String[] argv) {
        CommandLineArgumentParser.argv = argv;
    }

    public void parse() {

        if (!argv[0].equals("scan"))
            throw new IllegalArgumentException("was waiting for 'scan...'");

        for (int i = 1; i < argv.length; i++) {
            switch (argv[i]) {
                case "-h" -> {
                    i++;
                    String[] a = argv[i].split(",");

                    for (int n = 0; n < a.length; n++) {
                        if (a[n].contains("-")) {
                            String[] leftAddr = a[n].split("-")[0].split("\\.");
                            String[] rightAddr = a[n].split("-")[1].split("\\.");

                            for (int j = Integer.parseInt(leftAddr[0]); j <= Integer.parseInt(rightAddr[0]); j++)
                                for (int k = Integer.parseInt(leftAddr[1]); k <= Integer.parseInt(rightAddr[1]); k++)
                                    for (int l = Integer.parseInt(leftAddr[2]); l <= Integer.parseInt(rightAddr[2]); l++)
                                        for (int m = Integer.parseInt(leftAddr[3]); m <= Integer.parseInt(rightAddr[3]); m++)
                                            hosts.add(j + "." + k + "." + l + "." + m);
                        } else
                            hosts.add(a[n]);

                    }
                }


                case "-p" -> {
                    i++;
                    String[] a = argv[i].split(",");
                    for (String s : a) {
                        String[] b = s.split("-");
                        for (int k = Integer.parseInt(b[0]); k <= Integer.parseInt(b[b.length - 1]); k++) {
                            ports.add(k);
                        }
                    }

                }
                case "-t" -> {
                    i++;
                    threads = Integer.parseInt(argv[i]);
                }
                default -> throw new IllegalArgumentException("requires -h, -p or -t parameters");
            }
        }

    }
}


