package com.company.huawei;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class MyClient extends JFrame{
    private PrintWriter writer;
    Socket socket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();
    Container cc;
    public MyClient(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.print(tf.getText());
                ta.append(tf.getText()+'\n');
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");
            }
        });
    }
    private void connection(){
        ta.append("尝试连接");
        try {
            socket = new Socket("127.0.0.1",8998);
            writer = new PrintWriter(socket.getOutputStream(),true);
            ta.append("完成连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        MyClient client = new MyClient("向服务器发送数据");
        client.setSize(200,200);
        client.setVisible(true);
        client.connection();
    }
}
