import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TestMain implements Runnable{

    public static void main(String[] args) {
        Thread myThread = new Thread(new TestMain());
        myThread.start();

    }

    @Override
    public void run() {
        try {
            @SuppressWarnings("resource")
            ServerSocket serverSocket = new ServerSocket(12574);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("开始接收");
                try {
                    //接收客户端的数据
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(),"utf-8"));
                    String str = in.readLine();
                    move(str);
                    System.out.println("收到指令:" + str);

                    //返回数据给客户端
                    PrintWriter pout = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), "utf-8"));
                    pout.println("返回数据给客户端 " + "已收到数据");
                    System.out.println("发送完毕");
                    pout.close();
                    in.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } finally {
                    client.close();
                    System.out.println("close");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void move (String direction) {
        if (direction == "forward") {
            //调用命令行
        } else if (direction == "back") {

        } else if (direction == "left") {

        } else if (direction == "right") {

        } else {

        }
    }

    private void navigation(String location) {
        //获取坐标调用导航模块
    }

    private void sendMap() {
        //向客户端发送map
    }

}
