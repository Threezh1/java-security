package SimpleRMI_DiyStubAndSkeleton;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Person_Skeleton extends Thread {
    private PersonServer myServer;
    public Person_Skeleton(PersonServer server) {
        this.myServer = server;
    }
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Running at 9000...");
            Socket socket = serverSocket.accept();
            while (socket != null) {
                ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
                String method = (String) inStream.readObject();
                System.out.println(method);
                if (method.equals("age")) {
                    int age = myServer.getAge();
                    ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                    outStream.writeInt(age);
                    outStream.flush();
                }
                if (method.equals("name")) {
                    String name = myServer.getName();
                    ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
                    outStream.writeObject(name);
                    outStream.flush();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            //System.exit(0);
        }
    }
}
