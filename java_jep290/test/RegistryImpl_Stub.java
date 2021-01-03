package test;

import org.hibernate.metamodel.source.annotations.ReflectionHelper;
import sun.rmi.transport.StreamRemoteCall;

import java.io.IOException;
import java.io.ObjectOutput;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteCall;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;

public class RegistryImpl_Stub {
    public void bind(Registry registry, String var1, Remote var2) throws AccessException, AlreadyBoundException, RemoteException {
        try {
            RemoteRef ref = (RemoteRef) ReflectionHelper.getFieldValue(registry, "ref");
            RemoteCall var3 = ref.newCall((RemoteObject) registry, operations, 0, 4905912898345647071L);


            try {
                ObjectOutput var4 = var3.getOutputStream();
                ReflectionHelper.setFieldValue(var4, "enableReplace", false);
                var4.writeObject(var1);
                var4.writeObject(var2);
            } catch (IOException var5) {
                throw new MarshalException("error marshalling arguments", var5);
            }

            ref.invoke(var3);
            ref.done(var3);
        } catch (RuntimeException var6) {
            throw var6;
        } catch (RemoteException var7) {
            throw var7;
        } catch (AlreadyBoundException var8) {
            throw var8;
        } catch (Exception var9) {
            throw new UnexpectedException("undeclared checked exception", var9);
        }
    }
}
