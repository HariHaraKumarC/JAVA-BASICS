package hari.edu.java.ldap;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

public class LDAPCommons {
    private static final Logger logger = Logger.getLogger(LDAPCommons.class);
    private LDAPCommons() {
    }

    public static DirContext getDirectoryContext() throws NamingException {
        Properties properties=new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL,"ldap://localhost:10389");
        properties.put(Context.SECURITY_AUTHENTICATION,"simple");
        properties.put(Context.SECURITY_PRINCIPAL,"uid=companyAdmin,o=company");
        properties.put(Context.SECURITY_CREDENTIALS,"admin");
        logger.info("Creating the connection to the directory server...");
        return new InitialDirContext(properties);
    }
}
