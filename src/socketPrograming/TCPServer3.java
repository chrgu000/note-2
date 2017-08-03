package socketPrograming;

/**
 * Created by a1996_000 on 2017/8/3.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简易聊天室
 */
public class TCPServer3 {
    public static void main(String[]args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            //服务器获取客户端发送的消息
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            //读取客户端发送的消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client is :" + bufferedReader.readLine());
            String line = sin.readLine();
            while(!line.equals("bye")){
                printWriter.print(line);
                printWriter.flush();
                System.out.println("Sever is:" + line);
                System.out.println("Client is:" + bufferedReader.readLine());
                line = sin.readLine();
            }
            bufferedReader.close();
            printWriter.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
