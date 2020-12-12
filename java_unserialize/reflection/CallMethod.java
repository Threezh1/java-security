package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class CallMethod {
    public static void main(String[] args) throws Exception {
        Class UserClass = Class.forName("reflection.User");
        Constructor constructor = UserClass.getConstructor(String.class);
        User user = (User) constructor.newInstance("Threezh1");
        Method[] methods = UserClass.getDeclaredMethods(); // 获得该类所有方法

        System.out.println(Arrays.toString(methods)); // 打印所有方法
        Method method = UserClass.getDeclaredMethod("setName", String.class); // 获取该类某个方法
        method.invoke(user, "Threezh1");
        System.out.println(user.getName());
    }
}