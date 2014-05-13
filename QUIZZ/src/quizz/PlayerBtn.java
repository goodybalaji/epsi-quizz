/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static quizz.QUIZZ.playerScreenRankQuizz;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.playerScreenStat;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.quizzScreenAnswer;

/**
 *
 * @author Mama
 */
public class PlayerBtn extends JButton implements ActionListener
{
    static public Quiz leQuiz;
    static public int leQuizNbQuestion;
    static public int leQuizIdQuestion;

    /**
     *
     */
    static public ResultSet rsQ;
    static public ResultSet rsS;
    static public String leQuizQuestion="";
    static public String leQuizSolution1="";
    static public String leQuizSolution2="";
    static public String leQuizSolution3="";
    
    PlayerBtn(String str)
    {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if("Statistiques".equals(this.getText()))
        {
            playerScreenStat.setVisible(true);
            playerScreenHome.setVisible(false);
        }
        else if("Classement".equals(this.getText()))
        {
            playerScreenHome.setVisible(false);
            playerScreenRankQuizz.setVisible(true);
        }
       else if("Deconnexion".equals(this.getText()))
        {
            playerScreenHome.setVisible(false);
            connectionScreen.setVisible(true);
        }
       else if("Retour".equals(this.getText()))
        {
            playerScreenRankQuizz.setVisible(false);
            playerScreenStat.setVisible(false);
            playerScreenHome.setVisible(true);
        }
        else if("Jouer".equals(this.getText()))
        {
            playerScreenHome.setVisible(false); 
            int idDuQuizz = 64;

            //BDD
            java.sql.Statement statement;
           try {
               statement = DBConnect.Connect();
               
               //PREVIOUS
               //Connection conn = null;
                //statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
               
               //ID
                ResultSet rsID = statement.executeQuery("SELECT nbquestionquiz from QUIZ "
                                + "WHERE idquiz = "+ idDuQuizz);
                rsID.next();
                leQuizNbQuestion = rsID.getInt("nbquestionquiz");
                                 
                //Question
                rsQ = statement.executeQuery("SELECT lblquestion, QT.idquestion from QUESTION QT, COMPOSER C, QUIZ Q "
                        + "WHERE Q.IDQUIZ = "+ idDuQuizz
                        + "AND C.IDQUIZ = Q.IDQUIZ "
                        + "AND QT.IDQUESTION = C.IDQUESTION");
                rsQ.next();
                leQuizQuestion = rsQ.getString("lblquestion");
                leQuizIdQuestion = rsQ.getInt("idquestion");
                

                //Solution
                rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                        + "WHERE QT.IDQUESTION = "+ leQuizIdQuestion
                        + "AND QT.IDQUESTION = S.IDQUESTION");
                rsS.next();
                leQuizSolution1 = rsS.getString("lblsolution");
                rsS.next();
                leQuizSolution2 = rsS.getString("lblsolution");
                if(rsS.next() == true){
                     leQuizSolution3 = rsS.getString("lblsolution");
                } 
                
                QuizzTimer quizzTimer = new QuizzTimer(); 
                quizzScreenAnswer = new QuizzScreenAnswer();
                quizzScreenAnswer.setVisible(true);
                
           } 
           catch (SQLException ex) {
               Logger.getLogger(PlayerBtn.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            
        }
    }

}
