package hari.edu.java.jdbc;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by harih on 8/19/2018.
 */
public class GetPostgreSqlConn {
    private static final Logger logger = Logger.getLogger(GetPostgreSqlConn.class);
    private static Connection connection = null;

    private GetPostgreSqlConn() {
    }

    public static Connection getConnection() {
        try {
            //Step 1: Registering the Driver
            Class.forName("org.postgresql.Driver");
            logger.debug("PostgreSql Driver Registered Successfully");
            //Step 2: Creating Connection
            connection = DriverManager.getConnection(DbConstants.URL, DbConstants.USERNAME, DbConstants.PASS);
            logger.debug("Connection established Successfully");
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException occur. Check whether the JDBC Driver is in the Classpath.." + e);
        } catch (SQLException e) {
            logger.error("SqlException occur while establishing the connection.." + e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
            logger.debug("Connection closed Successfully");
        } catch (SQLException e) {
            logger.error("SqlException occur while closing the connection.." + e);
        }
    }

    public static void executeQuery(Connection connection,String query){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            logger.debug("Sql Statement Executed Successfully.");
            GetPostgreSqlConn.closeConnection(connection);
        } catch (SQLException e) {
            logger.error("SqlException occur while executing the SQL Statement.." + e);
        }
    }
}
