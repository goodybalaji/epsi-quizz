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
  static int nbMiddle;
  static int nbHard;
  static int id;
   
    public Player(String log, int identifier)
    {
        nbEasy = 0;
        nbMiddle = 0;
        nbHard = 0;
        login = log;
        id = identifier;
    }
   
   void setLogin(String log)
   {
       login = log;
   }
   
   String getLogin()
   {
       return login;
   }
   
   static void setQuizNb(int iden)
   {
        try 
        {
           final java.sql.Statement statement = DBConnect.Connect();
           ResultSet rs = statement.executeQuery("SELECT NBFACILE, NBMOYEN, NBDIFFICILE from NB_QUIZ_JOUEUR, JOUEUR" +
                                                 "WHERE JOUEUR.IDJOUEUR = " + iden + "AND JOUEUR.IDNBQUIZ=NB_QUIZ_JOUEUR.IDNBQUIZ");
           if (rs.next() == true)
           {
            nbEasy = rs.getInt(1);
            nbMiddle = rs.getInt(2);
            nbHard = rs.getInt(3);
           }
        }
        catch (SQLException ex)
        {
           Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }    
   }   
}
