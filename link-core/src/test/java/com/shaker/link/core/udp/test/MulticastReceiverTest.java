package com.shaker.link.core.udp.test;

import com.shaker.link.core.udp.MulticastReceiver;

import java.net.DatagramPacket;
import java.util.Arrays;

/**
 * multicast receiver test
 * Created by yinghuihong on 16/7/19.
 */
public class MulticastReceiverTest {

    public static void main(String... args) throws InterruptedException {
        MulticastReceiver receiver = new MulticastReceiver(new MulticastReceiver.MulticastReceiverListener() {
            @Override
            public void multicastReceive(DatagramPacket packet) {
                byte[] receiveBytes = Arrays.copyOfRange(packet.getData(), 0, packet.getLength());
                System.out.println("Receive multicast msg from " + packet.getAddress().getHostAddress()
                        + ":" + packet.getPort() + "\n" + new String(receiveBytes) + "\n");
            }
        });
        receiver.start();
        Thread.sleep(10 * 1000L);
        receiver.close();
    }
}
