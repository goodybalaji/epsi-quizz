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
public class Player {
  static String login;
  static int nbEasy;
  static int nbMidle;
  static int nbHard;
  static int id;
   

    /**
     *
     * @param log
     * @param identifier
     */
    public Player(String log, int identifier)
    {
        nbEasy = 0;
        nbMidle = 0;
        nbHard = 0;
        login = log;
        id = identifier;
        Player.setQuizNb();
    }
   
   void setLogin(String log)
   {
       login = log;
   }
   
   String getLogin()
   {
       return login;
   }
   
   static void setQuizNb()
   {
        try 
        {
           final java.sql.Statement statement = DBConnect.Connect();
           ResultSet rs = statement.executeQuery("SELECT NBFACILE, NBMOYEN, NBDIFFICILE from NB_QUIZ_JOUEUR, JOUEUR" +
                                                 "WHERE JOUEUR.IDJOUEUR = " + id + "AND JOUEUR.IDNBQUIZ=NB_QUIZ_JOUEUR.IDNBQUIZ");
           rs.next();
           
        }
        catch (SQLException ex)
        {
           Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }        
   }   
}
