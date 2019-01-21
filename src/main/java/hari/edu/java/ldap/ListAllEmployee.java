package hari.edu.java.ldap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class ListAllEmployee {
    private static final Logger logger = Logger.getLogger(ListAllEmployee.class);
    public static void main(String[] args) {
        ListAllEmployee listAllEmployee =new ListAllEmployee();
        try {
            DirContext directoryContext=LDAPCommons.getDirectoryContext();
            listAllEmployee.getAllEmployees(directoryContext);
        } catch (NamingException e) {
            logger.error("Naming Exception Occurs while getting employee count from Directory..." +e);
        }
    }

    public void getAllEmployees(DirContext dirContext) throws NamingException {
        String searchBase="ou=users,o=company";
        String[] returningAttributes={"employeeNumber","cn","sn"};
        String searchFilter="(objectClass=*)";
        SearchControls searchControls=new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setReturningAttributes(returningAttributes);
        searchControls.setCountLimit(100);
        NamingEnumeration<SearchResult> results=dirContext.search(searchBase,searchFilter,searchControls);
        int totalEmployeeCount=0;
        while(results.hasMoreElements()){
            SearchResult searchResult=results.next();
            if(searchResult != null && !StringUtils.isBlank(searchResult.getName())){
                logger.debug("Employee Id : "+ searchResult.getName());
                Attributes attributes=searchResult.getAttributes();
                Attribute cnAttribute=attributes.get("cn");
                logger.debug("Employee CN : "+ cnAttribute.get());
                Attribute snAttribute=attributes.get("sn");
                logger.debug("Employee SN : "+ snAttribute.get());
                logger.debug("-------------------");
                totalEmployeeCount=totalEmployeeCount+1;
            }
        }
        logger.debug("Total number of the employees in the company is "+totalEmployeeCount);
    }
}
