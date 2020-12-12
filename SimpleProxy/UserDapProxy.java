package proxy1;

public class UserDapProxy implements IUserDao{
    private IUserDao target;

    public UserDapProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("doSomething before");
        target.save();
        System.out.println("doSomething after");
    }
}
