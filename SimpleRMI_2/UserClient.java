package SimpleRMI_2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserClient {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry(3333); // 获取注册表
        User userClient = (User) registry.lookup("HelloRegistry"); // 获取命名为HelloRegistr的远程对象的stub
        System.out.println(userClient.name("test"));
        userClient.say("world");
    }
}