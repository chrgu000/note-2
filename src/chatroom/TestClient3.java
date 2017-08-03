package chatroom;

/**
 * Created by a1996_000 on 2017/8/3.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient3 extends JFrame implements ActionListener{

    //定义组件
    JTextArea jta=null;
    JTextField jtf=null;
    JButton jb=null;
    JPanel jp=null;
    JScrollPane jsp=null;

    InputStreamReader isr=null;
    BufferedReader br=null;
    PrintWriter pw=null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestClient3 tc=new TestClient3();
    }

    public TestClient3()
    {
        //创建组件
        jta=new JTextArea();
        jtf=new JTextField(10);
        jb=new JButton("发送");
        //设置监听
        jb.addActionListener(this);

        jsp=new JScrollPane(jta);

        jp=new JPanel();
        jp.add(jtf);
        jp.add(jb);

        this.add(jp,"South");
        this.add(jsp,"Center");

        this.setSize(300, 300);
        this.setVisible(true);
        this.setTitle("简易QQ聊天--客户端");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //建立socket连接
        try {
            Socket s=new Socket("127.0.0.1",1234);

            isr=new InputStreamReader(s.getInputStream());
            br=new BufferedReader(isr);
            pw=new PrintWriter(s.getOutputStream(),true);

            while(true)
            {
                //在循环中读取来自服务器的消息，并且显示
                String info=br.readLine();
                jta.append("服务器说：  "+info+"\r\n");

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //点击发送按钮后，将消息发送出去
        if(e.getSource()==jb)
        {
            String resp=jtf.getText();
            jta.append("你对服务器说：  "+resp+"\r\n");
            pw.println(resp);
            //清空
            jtf.setText("  ");
        }
    }

}
