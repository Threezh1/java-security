package reflection;

public class Exec {
    public static void main(String[] args) throws Exception {
        Class runtimeClass = Class.forName("java.lang.Runtime");
        Object runtime = runtimeClass.getMethod("getRuntime").invoke(null); // getRuntime是静态方法，invoke时不需要传入对象
        runtimeClass.getMethod("exec", String.class).invoke(runtime, "open /System/Applications/Calculator.app");
    }
}
