package hari.edu.java.jdbc;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by harih on 8/19/2018.
 */
public class ResultSetSql {
    private static final Logger logger = Logger.getLogger(ResultSetSql.class);
    public static void main(String[] args) {
        Connection connection = GetPostgreSqlConn.getConnection();
        String query = "SELECT * FROM book ORDER By id";//Select
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);ResultSet resultSet=statement.executeQuery(query)) {
            logger.debug("Printing Book Names...");
            while(resultSet.next()){
                logger.debug(resultSet.getString("name"));
            }
        }catch (SQLException e) {
            logger.error("SqlException occur while executing the SQL Statement.." + e);
        }
        GetPostgreSqlConn.closeConnection(connection);
    }
}
