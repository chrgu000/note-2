package chatroom;

/**
 * Created by a1996_000 on 2017/8/3.
 */
/*
 * 功能：这是一个服务器，实现简易的对讲机,带界面
 * author：ywq
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer3 extends JFrame implements ActionListener{

    //定义组件
    JTextArea jta=null;//文本区
    JTextField jtf=null;//文本框
    JButton jb=null;//按钮
    JPanel jp=null;//面板
    JScrollPane jsp=null;//滚动条

    InputStreamReader isr=null;//读取流
    BufferedReader br=null;//读取流
    PrintWriter pw=null;//打印流

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestServer3 ts=new TestServer3();
    }

    public TestServer3()
    {
        //创建组件
        jta=new JTextArea();//文本区域
        jtf=new JTextField(10);//设置输入框宽度为10列
        jb=new JButton("发送");//按钮
        //设置监听
        jb.addActionListener(this);//是为按钮添加监听

        jsp=new JScrollPane(jta);//为文本区域添加滚动条

        jp=new JPanel();//面板
        jp.add(jtf);//向面板添加输入框 按钮
        jp.add(jb);//向面板添加按钮

        this.add(jp,"South");
        this.add(jsp,"Center");

        this.setSize(300, 300);
        this.setVisible(true);
        this.setTitle("简易QQ聊天--服务器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //建立socket连接
        try {
            ServerSocket ss=new ServerSocket(1234);
            Socket s=ss.accept();

            isr=new InputStreamReader(s.getInputStream());
            br=new BufferedReader(isr);
            pw=new PrintWriter(s.getOutputStream(),true);
            //做一个循环
            while(true)
            {
                //在循环中读取来自客户端的消息并且显示
                String info=br.readLine();
                jta.append("客户端说：  "+info+"\r\n");


            }


        } catch (IOException e) {

            e.printStackTrace();
        }





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //进行相应的操作
        if(e.getSource()==jb)
        {
            //点击发送按钮后，将消息发送出去
            String resp=jtf.getText();//获取输入框中的值
            jta.append("你对客户端说：  "+resp+"\r\n");//设置到服务器当前聊天框中
            pw.println(resp);
            jtf.setText("  ");
        }

    }
}

