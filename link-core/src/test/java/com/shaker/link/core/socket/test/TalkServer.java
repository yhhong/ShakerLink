package com.shaker.link.core.socket.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket server
 * Created by yinghuihong on 16/7/15.
 */
public class TalkServer {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(9999);
            Socket client = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = reader.readLine();
            while (line != null && !line.equals("bye")) {
                System.out.println("receive:" + line);
                line = reader.readLine();
            }
            System.out.println("receive:" + line);
            reader.close();
            client.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Process exit");
    }
}