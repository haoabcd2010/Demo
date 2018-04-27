import java.util.Scanner;
/**
 * Created by happy_code on 2017/6/2.
 */
public class Kind {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("你是作为:");
        System.out.println("1.服务器:");
        System.out.println("2.客户机:");
        try {
            int op = sc.nextInt();
            if (op<1||op>2){
                System.err.println("输入错误！");
                System.exit(-1);
            }
            if (op==1){
                Server_test s1 = new Server_test(7788);
                Thread th1 = new Thread(s1,"read");
                Thread th2 = new Thread(s1,"write");
                th1.start();
                th2.start();
            }
            if (op==2){
                System.out.print("输入服务器ip:");
                String str = sc.next();
                Client_test c1 = new Client_test(str,7788);
                Thread th1 = new Thread(c1,"read");
                Thread th2 = new Thread(c1,"write");
                th1.start();
                th2.start();
            }
        } catch (Exception e){
            System.err.println("输入错误！");
            System.exit(-1);
        }
    }
}
