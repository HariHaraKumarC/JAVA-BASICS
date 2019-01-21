package hari.edu.java.jdbc;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by harih on 8/19/2018.
 */
public class ResultSetMetaDataSql {
    private static final Logger logger = Logger.getLogger(ResultSetMetaDataSql.class);
    public static void main(String[] args) {
        Connection connection = GetPostgreSqlConn.getConnection();
        String query = "SELECT * FROM book ORDER By id";//Select
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);ResultSet resultSet=statement.executeQuery(query)) {
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            logger.debug("Printing Book Table Meta Data...");
            logger.debug("Total Number of Columns..."+resultSetMetaData.getColumnCount());
            for(int i=1;i<resultSetMetaData.getColumnCount();i++){
                logger.debug(resultSetMetaData.getColumnName(i));
                logger.debug(resultSetMetaData.getColumnTypeName(i));
                logger.debug("----");
            }
        }catch (SQLException e) {
            logger.error("SqlException occur while executing the SQL Statement.." + e);
        }
        GetPostgreSqlConn.closeConnection(connection);
    }
}
