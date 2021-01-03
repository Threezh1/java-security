package jndi_test1;

import javax.naming.InitialContext;

public class JNDIClient {
    public static void main(String[] args) throws Exception {
        new InitialContext().lookup("ldap://127.0.0.1:7777/testObject");
    }
}
