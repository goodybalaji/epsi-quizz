/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mama
 */
public class DBConnect {
    public static final String DBURL = "jdbc:oracle:thin:@//193.252.48.189:1521/XE";
    public static final String DBUSER = "b3i_groupe_2";
    public static final String DBPASS = "123Soleil";

    public final static Statement Connect() throws SQLException
    {
        // Load Oracle JDBC Driver
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS); 
        java.sql.Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return statement;
       // ResultSet rs = statement.executeQuery("SELECT * from TABLE1222");
    }
}
