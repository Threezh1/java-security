package SimpleRMI_3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserServerTest {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(3333);
        Registry registry_remote = LocateRegistry.getRegistry("127.0.0.1", 3333);
        User user = new UserImpl();
        registry_remote.bind("HelloRegistry", user);
        System.out.println("rmi start at 3333");
    }
}
