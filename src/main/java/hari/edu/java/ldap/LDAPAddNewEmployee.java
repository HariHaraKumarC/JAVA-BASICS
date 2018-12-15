package hari.edu.java.ldap;

import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.naming.directory.*;

public class LDAPAddNewEmployee {
    private static final Logger logger = Logger.getLogger(LDAPAddNewEmployee.class);
    public static void main(String[] args) {
        LDAPAddNewEmployee ldapAddNewEmployee=new LDAPAddNewEmployee();
        String newEmployeeDN="employeeNumber=0005,ou=users,o=company";
        try {
            DirContext directoryContext=LDAPCommons.getDirectoryContext();
            ldapAddNewEmployee.addNewEmployee(directoryContext,newEmployeeDN);
            logger.info("New employee successfully added to the Directory");
        } catch (NamingException e) {
            logger.error("Naming Exception Occurs while adding new employee to Directory..." +e);
        }
    }

    public void addNewEmployee(DirContext dirContext,String dn) throws NamingException {
        Attributes attributes=new BasicAttributes();

        Attribute objectClass=new BasicAttribute("objectClass");
        objectClass.add("inetOrgPerson");
        attributes.put(objectClass);

        Attribute cn=new BasicAttribute("cn");
        cn.add("Vanitha");
        attributes.put(cn);

        Attribute sn=new BasicAttribute("sn");
        sn.add("Chandrabose");
        attributes.put(sn);

        dirContext.createSubcontext(dn,attributes);
    }
}
