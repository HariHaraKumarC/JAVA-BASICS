package hari.edu.java.jdbc;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by harih on 8/19/2018.
 */
public class PreparedStatementSql {
    private static final Logger logger = Logger.getLogger(PreparedStatementSql.class);

    public static void main(String[] args) {
        Connection connection = GetPostgreSqlConn.getConnection();
        String query = "INSERT INTO book (id,name,language_code,author_id) VALUES(?,?,?,?)"; // Insert
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1,3);
            statement.setString(2,"Jala Deebam");
            statement.setInt(3,1);
            statement.setInt(4,1);
            statement.executeUpdate();
            logger.debug("Prepared Statement executed successfully...");
        }catch (SQLException e) {
            logger.error("SqlException occur while executing the Prepared Statement.." + e);
        }
        GetPostgreSqlConn.closeConnection(connection);
    }
}
