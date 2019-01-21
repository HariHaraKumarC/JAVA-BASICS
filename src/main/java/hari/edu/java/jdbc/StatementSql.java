package hari.edu.java.jdbc;

import java.sql.Connection;

/**
 * Created by harih on 8/19/2018.
 */
public class StatementSql {

    public static void main(String[] args) {
        Connection connection = GetPostgreSqlConn.getConnection();
        //String query = "INSERT INTO books (id,name,language_code,author_id) VALUES(3,'Jala Deebam',1,1)"; // Insert
        //String query = "UPDATE books set name='Kadal Pura'WHERE name='KadalPura'";//Update
        String query = "DELETE FROM book WHERE name='Jala Deebam'";//Delete
        GetPostgreSqlConn.executeQuery(connection,query);
        GetPostgreSqlConn.closeConnection(connection);
    }

}


