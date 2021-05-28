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
                    for(int n = 0; n < a.length; n++) {
                        if(a[i].contains("-")) {
                            String[] firstAddress = a[0].split("-");
                            String[] secondAddress = a[1].split("-");
                            String[] thirdAddress = a[2].split("-");
                            String[] fourthAddress = a[3].split("-");
                            for (int j = Integer.parseInt(firstAddress[0]); j <= Integer.parseInt(firstAddress[firstAddress.length - 1]); j++)
                                for (int k = Integer.parseInt(secondAddress[0]); k <= Integer.parseInt(secondAddress[secondAddress.length - 1]); k++)
                                    for (int l = Integer.parseInt(thirdAddress[0]); l <= Integer.parseInt(thirdAddress[thirdAddress.length - 1]); l++)
                                        for (int m = Integer.parseInt(fourthAddress[0]); m <= Integer.parseInt(fourthAddress[fourthAddress.length - 1]); m++)
                                            hosts.add(j + "." + k + "." + l + "." + m);
                        } else
                            hosts.add(a[i]);
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
