package socketPrograming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by a1996_000 on 2017/8/3.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",65535);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Hello World");
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
