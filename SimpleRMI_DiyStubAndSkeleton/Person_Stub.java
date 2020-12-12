package SimpleRMI_DiyStubAndSkeleton;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Person_Stub implements Person{
    private Socket socket;
    public Person_Stub() throws Throwable {
        socket = new Socket("localhost", 9000);
    }
    public int getAge() throws Throwable {
        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("age");
        outStream.flush();
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
        return inStream.readInt();
    }

    public String getName() throws Throwable {
        ObjectOutputStream outStream =new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("name");
        outStream.flush();
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
        return (String)inStream.readObject();
    }
}
