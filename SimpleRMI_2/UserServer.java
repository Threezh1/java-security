package SimpleRMI_2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserServer {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.createRegistry(3333); // 本地主机上的远程对象注册表Registry的实例
        User user = new UserImpl(); // 创建一个远程对象
        registry.rebind("HelloRegistry", user); // 把远程对象注册到RMI注册服务器上，并命名为HelloRegistr
        System.out.println("rmi start at 3333");
    }
}