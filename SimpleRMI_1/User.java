package SimpleRMI_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote{
    String name(String name) throws RemoteException;
    void say(String say) throws RemoteException;
    void dowork(Object work) throws RemoteException;
}