package com.company;

public class Result {
    private String host;
    private String port;
    private boolean status;


    public Result(String host, String port, boolean status) {
        this.host = host;
        this.port = port;
        this.status = status;
    }


    @Override
    public String toString(){
        return this.host + ":" + this.port + " [" + this.status + "]";
    }
}
