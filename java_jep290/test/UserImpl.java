package test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// java.rmi.server.UnicastRemoteObject构造函数中将生成stub和skeleton
public class UserImpl extends UnicastRemoteObject implements User{
    // 必须有一个显式的构造函数，并且要抛出一个RemoteException异常
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