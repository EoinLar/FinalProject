package com.eoinl.fantasygaa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class client {

    private static final String host = "10.0.2.2";
    private static final int port = 8080;

    DataInputStream input;
    DataOutputStream output;

    public client() {
        try {
            Socket socket = new Socket(host, port);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }

    public String seeData() {

        return null;
    }
}
