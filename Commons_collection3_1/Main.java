package Commons_collection3_1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/threezh1/IdeaProjects/Commons-collections3-1/src/vuln/calc.payload");
        ObjectInputStream input = new ObjectInputStream(fileInputStream);
        Object object = input.readObject();
        input.close();
        fileInputStream.close();
    }
}
