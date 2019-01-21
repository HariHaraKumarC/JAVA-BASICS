package hari.edu.java.ldap;

import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.naming.directory.*;

public class LDAPRemoveAttribute {
    private static final Logger logger = Logger.getLogger(LDAPRemoveAttribute.class);
    public static void main(String[] args) {
        LDAPRemoveAttribute removeAttribute =new LDAPRemoveAttribute();
        String dn="employeeNumber=0005,ou=users,o=company";
        try {
            DirContext directoryContext=LDAPCommons.getDirectoryContext();
            removeAttribute.getAllEmployees(directoryContext,dn,"mail");
        } catch (NamingException e) {
            logger.error("Naming Exception Occurs while removing attribute..." +e);
        }
    }

    public void getAllEmployees(DirContext dirContext, String dn, String attributeName) throws NamingException {
        Attribute attribute=new BasicAttribute(attributeName);
        ModificationItem[] modificationItems=new ModificationItem[1];
        modificationItems[0]=new ModificationItem(DirContext.REMOVE_ATTRIBUTE,attribute);
        dirContext.modifyAttributes(dn,modificationItems);
        logger.debug("Attribute "+attributeName+" is successfully removed from DN "+dn);
    }
}
