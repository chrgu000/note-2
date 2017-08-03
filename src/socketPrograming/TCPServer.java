package socketPrograming;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by a1996_000 on 2017/8/3.
 */
public class TCPServer {
    public static void main(String[] args) {
        try {

                ServerSocket serverSocket = new ServerSocket(65535);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client connect");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                System.out.println(dis.readUTF());
                dis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
