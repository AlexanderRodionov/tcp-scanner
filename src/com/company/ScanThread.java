package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ScanThread implements Runnable{

    private List<Result> results;
    private String host;
    private String port;
    private int timeOut;

    public void scanThread() {

    }

    @Override
    public void run() {
        System.out.println(this.host);

        boolean status = false;
        //socket.close() не нужен, так как это closeable объект
        try (Socket socket = new Socket()){ //try-with-resources

            socket.connect(new InetSocketAddress(host, Integer.parseInt(port)), timeOut);
            status = true;
        } catch (IOException e) {
            status = false;
        } finally {
            synchronized (this) {
                //System.out.println(this.host + ":" + this.port + "[" + status + "]");
                //this.results.add(new Result(host, port, status));

                /**
                 * сделать через  stringbuilder
                 */

                System.out.println(this.host + ":" + this.port + " [" + status + "]");
                this.results.add(new Result(host, port, status));
                //StringBuilder sb

            }
        }


    }



    public ScanThread(String host, String port, int timeOut, List<Result> results) {
        this.results = results;
        this.host = host;
        this.port = port;
        this.timeOut = timeOut;
    }
}
