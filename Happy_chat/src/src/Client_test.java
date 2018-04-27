import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.lang.*;

/**
 * Created by happy_code on 2017/6/2.
 */

public class Client_test implements Runnable{
    private Socket client;
    private boolean working;
    // 服务器 ip ，端口号
    public Client_test(String host,int port){
        client = null;
        try{
            client = new Socket(host,port);
            InetAddress server = client.getInetAddress();
            System.out.println("到"+server.getHostAddress()+"的连接已建立！");
        }catch (UnknownHostException e) {
            System.err.println("指定服务错地址错误");
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("创建和服务器的连接时发生错误");
            System.exit(-1);
        }
        working = true;
    }

    @Override
    public void run() {
            if (Thread.currentThread().getName().equals("write")) {
                try {
                    // 与服务器通信的代码
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    Scanner sc = new Scanner(System.in);    // 命令行读取
                    while (working) {
                        String str = sc.next();
                        if (str.equals("END") || str.equals("end")) {
                            working = false;
                        }
                        out.println(str);
                    }
                } catch (IOException e) {
                    System.err.println("和服务器的连接时发生错误");
                    System.exit(-1);
                }
            }

            if (Thread.currentThread().getName().equals("read")) {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    while (working) {
                        String str = in.readLine();
                        if (str.equals("END") || str.equals("end")) {
                            working = false;
                            continue;
                        }
                        System.out.println("he:" + str);
                    }

                } catch (IOException e) {
                    System.out.println("会话已结束!");
                    System.exit(0);
                }
            }

            try {
                client.close();   // 关闭socket
            } catch (IOException e) {
            }
    }

    public static void main(String[] args){
    }
}
