/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mama
 */
public class Admin
{
    static String login;
    static int id;
    static int nbQuizCrea;
    
    public Admin(String log, int iden)
    {
        login = log;
        id = iden;
    }
    
    public static void setNbQuizCrea(int iden)
    {
        try 
        {
           final java.sql.Statement statement = DBConnect.Connect();
           ResultSet rs = statement.executeQuery("SELECT NBQUIZADMIN from ADMIN where idadmin =" + iden);
           rs.next();           
        }
        catch (SQLException ex)
        {
           Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
