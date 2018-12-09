package hari.edu.java.jdbc;

import org.apache.log4j.Logger;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 * Created by harih on 8/19/2018.
 */
public class RowSetSql {
    private static final Logger logger = Logger.getLogger(RowSetSql.class);
    public static void main(String[] args) {
        String query = "SELECT * FROM book ORDER By id";//Select
        try (JdbcRowSet jdbcRowSet= RowSetProvider.newFactory().createJdbcRowSet()) {
            jdbcRowSet.setUrl(DbConstants.URL);
            jdbcRowSet.setUsername(DbConstants.USERNAME);
            jdbcRowSet.setPassword(DbConstants.PASS);
            jdbcRowSet.setCommand(query);
            jdbcRowSet.execute();
            logger.debug("Printing Book Names...");
            while(jdbcRowSet.next()){
                logger.debug(jdbcRowSet.getString("name"));
            }
        }catch (SQLException e) {
            logger.error("SqlException occur while executing the RowSet.." + e);
        }
    }
}
