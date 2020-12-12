package proxy1;

public class TestDynamicProxy {
    public static void main(String[] args) {
        IUserDao taget = new UserDao();
        System.out.println(taget.getClass());
        IUserDao proxy = (IUserDao) new UserProxyFactory(taget).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
