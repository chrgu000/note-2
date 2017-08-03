package socketPrograming;

import java.io.*;
import java.net.Socket;

/**
 * Created by a1996_000 on 2017/8/3.
 */
public class TCPClient2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new  DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            //读取服务器的消息
            String s = null;
            while((s = dataInputStream.readUTF())!=null){
                System.out.println(s);
                System.out.println("服务器的ip" + socket.getInetAddress());
                System.out.println("服务器的端口号" + socket.getPort());
            }
            //向服务器写入消息
            dataOutputStream.writeUTF("我是客户端");

            dataInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
