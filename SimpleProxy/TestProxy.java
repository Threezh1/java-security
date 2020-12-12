package proxy1;

public class TestProxy {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();
        // 代理对象
        UserDapProxy proxy = new UserDapProxy(target);
        // 通过代理调用方法
        proxy.save();
    }
}
