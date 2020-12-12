package SimpleRMI_2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserImpl extends UnicastRemoteObject implements User {

    public UserImpl() throws RemoteException{
        super();
    }
    public String name(String name) throws RemoteException{
        return name;
    }
    public void say(String say) throws  RemoteException{
        System.out.println("you speak" + say);
    }
    public void dowork(Object work) throws  RemoteException{
        System.out.println("your work is " + work);
    }
}