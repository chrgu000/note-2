package socketPrograming;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by a1996_000 on 2017/8/3.
 */
public class UDPServer {
    public static void main(String[]args){
        byte[]buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        try {
            DatagramSocket ds = new DatagramSocket(5678);
            while(true){
                ds.receive(dp);
                ByteArrayInputStream bis = new ByteArrayInputStream(buf);
                DataInputStream dis = new DataInputStream(bis);
                System.out.println(dis.readLong());
                System.out.println(new String(buf,0,dp.getLength()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
