package socketPrograming;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Created by a1996_000 on 2017/8/3.
 */
public class UDPClient {
    public static void main(String[]args){
        long n = 10000L;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeLong(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //byte[]buf = (new String("Hello")).getBytes();
        byte[]buf = baos.toByteArray();
        DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",5678));

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9999);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            ds.send(dp);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
