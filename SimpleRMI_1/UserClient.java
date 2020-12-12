package SimpleRMI_2;

import java.rmi.Naming;

public class UserClient {
    public static void main(String[] args) throws Exception{
        String url = "rmi://127.0.0.1:3333/User";
        User userClient = (User)Naming.lookup(url); // 从RMI Registry中请求stub
        System.out.println(userClient.name("test")); // 通过stub调用远程接口实现
        userClient.say("world"); // 在客户端中调用，在服务端输出
    }
}