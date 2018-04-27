import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by happy_code on 2017/6/2.
 */
public class Server_test implements Runnable{
    private ServerSocket serve;
    private Socket clientSocket;
    private boolean working;

    public Server_test(int port){
        serve=null;
        try{
            serve = new ServerSocket(port); //开启端口
            System.out.println("服务器开始运行:");
            InetAddress my_IP=InetAddress.getLocalHost();
            System.out.println("本机IP:"+my_IP.getHostAddress());
            System.out.println("开放端口:"+serve.getLocalPort());
        } catch (IOException e){
            System.err.println("无法在"+port+"端口提供侦听服务.");
            System.exit(1);
        }
        clientSocket = null;
        try{
            clientSocket = serve.accept();
            String address = clientSocket.getInetAddress().getHostAddress();
            System.out.println("一个来自"+address+"的连接已经建立");
        } catch (IOException e) {
            System.err.println("建立连接失败.");
            System.exit(1);
        }
        working = true;
    }

    @Override
    public void run(){
        // 开始和客户端通信
        // 代码
        BufferedReader in = null;
        PrintWriter out = null;
        if (Thread.currentThread().getName().equals("write")) {
            try{
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                Scanner sc = new Scanner(System.in);    // 命令行读取
                String str = null;
                while (working){
                    str = sc.next();
                    if (str.equals("END")||str.equals("end")){
                        working = false;
                    }
                    out.println(str);
                }
            } catch (IOException e){
                System.err.println("创建和服务器的连接时发生错误");
                System.exit(-1);
            }
        }

        if (Thread.currentThread().getName().equals("read")) {
            try{
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String info=null;
                while (working){
                    info = in.readLine();
                    if (info.equals("END")||info.equals("end")){
                        working = false;
                        continue;
                    }
                    System.out.println("he:"+info);
                }
            } catch (IOException e){
                System.out.println("会话已结束!");
                System.exit(-1);
            }
        }

        try{
            clientSocket.close();   // 关闭socket
            serve.close();          //关闭端口
        } catch (IOException e){
        }
    }

    public static void main(String[] args){
    }
}

