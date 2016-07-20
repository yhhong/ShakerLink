package com.shaker.link.core.socket.test;

import com.shaker.link.core.socket.SocketClient;
import com.shaker.link.core.socket.SocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * socket server test
 * Created by yinghuihong on 16/7/18.
 */
public class SocketServerTest {

    private static SocketServer server;

    public static void main(String... args) throws IOException {
        server = new SocketServer(new SocketClient.SocketReceiverListener() {
            @Override
            public void socketReceive(SocketClient socket, String data) {
                System.out.println("[Socket receive]" + data);
            }
        });
        server.start();

        sendMessageByTerminal();
    }

    private static void sendMessageByTerminal() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!line.equals("BYE")) {
            server.send(line);
            line = reader.readLine();
        }
        server.send(line);
        server.close();
    }
}
