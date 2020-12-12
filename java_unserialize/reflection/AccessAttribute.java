package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class AccessAttribute {
    public static void main(String[] args) throws Exception {
        Class UserClass = Class.forName("reflection.User");
        Constructor constructor = UserClass.getConstructor(String.class);
        User user = (User) constructor.newInstance("sanzhi");

        Field[] fields = UserClass.getDeclaredFields(); // 获取所有属性对象
        System.out.println(Arrays.toString(fields));

        Field field = UserClass.getDeclaredField("name"); // 获取某个属性对
        field.setAccessible(true); // name是private属性，需要将其设置为可访问
        field.set(user, "Threezh1"); // 设置值

        System.out.println(user.getName());
    }
}
