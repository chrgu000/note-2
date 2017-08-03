package socketPrograming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by a1996_000 on 2017/8/3.
 */
public class TCPServer2 {
    public static void main(String[]args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF("服务器首先向客户端写程序");
            System.out.println("读取客户端的程序");
            String content = null;
            while((content=dataInputStream.readUTF())!=null){
                System.out.println(content);
                System.out.println("address:" + serverSocket.getInetAddress());
                System.out.println("port:" + serverSocket.getLocalPort());

            }
            dataInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("出现异常");
        }
    }
}
