package SimpleRMI_2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class UserServer {
    public static void main(String[] args) throws Exception{
        String url = "rmi://127.0.0.1:3333/User";
        User user = new UserImpl(); // 生成stub和skeleton,并返回stub代理引用
        LocateRegistry.createRegistry(3333); // 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上监听并接受请求
        Naming.bind(url, user); // 将stub代理绑定到Registry服务的URL上
        System.out.println("the rmi is running : " + url);
    }
}