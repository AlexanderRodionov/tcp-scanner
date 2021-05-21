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
                    for (String s : a) {
                        if (s.contains("-")) {
/*
                                String[] firstAddr[] = s[0].split(".");;
                                String[] secondAddr[] = s[1].split("-");;
                                String[] thirdAddr[] = s[2].split("-");;
                                String[] fourthAddr[] = s[3].split("-");;
                                for (int first = Integer.parseInt(firstAddr[0]); first <= Integer.parseInt(firstAddr[firstAddr.length - 1]); first++)
                                    for (int second = Integer.parseInt(secondAddr[0]); second <= Integer.parseInt(secondAddr[secondAddr.length - 1]); second++)
                                        for (int third = Integer.parseInt(thirdAddr[0]); third <= Integer.parseInt(thirdAddr[thirdAddr.length - 1]); third++)
                                            for (int fourth = Integer.parseInt(fourthAddr[0]); fourth <= Integer.parseInt(fourthAddr[fourthAddr.length - 1]); fourth++)
                                                hosts.add(first + "." + second + "." + third + "." + fourth);

 */
                        } else
                            hosts.add(s);
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
