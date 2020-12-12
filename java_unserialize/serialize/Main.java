package serialize;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setName(("Threezh1"));

        byte[] serializeData = serialize(user); // 创建是一个字节型的数据
        FileOutputStream fout = new FileOutputStream("user.bin");
        fout.write(serializeData);
        fout.close();
        User user2 = (User)unserialize(serializeData);
        System.out.println(user2.getName());
    }

    public static byte[] serialize(final Object obj) throws Exception {
        ByteArrayOutputStream btout = new ByteArrayOutputStream(); // 创建一个32字节（默认大小）的缓冲区
        ObjectOutputStream objOut = new ObjectOutputStream(btout); // 通过传入byte字节流来存储写入的对象
        objOut.writeObject(obj); // 将对象写入流中
        return btout.toByteArray(); // 创建一个新分配的字节数组。数组的大小和当前输出流的大小，内容是当前输出流的拷贝。
    }

    public static Object unserialize(final byte[] serialized) throws Exception {
        ByteArrayInputStream btin = new ByteArrayInputStream(serialized); // 接收字节数组作为参数创建
        ObjectInputStream objIn = new ObjectInputStream(btin); // 从输入流中读取Java对象
        return objIn.readObject();
    }
}
