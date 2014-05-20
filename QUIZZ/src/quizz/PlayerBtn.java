/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static quizz.QUIZZ.BtnColor;
import static quizz.QUIZZ.answer1;
import static quizz.QUIZZ.answer2;
import static quizz.QUIZZ.answer3;
import static quizz.QUIZZ.answer4;
import static quizz.QUIZZ.playerScreenRankQuizz;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.playerScreenStat;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.player;
import static quizz.QUIZZ.quiz;
import static quizz.QUIZZ.question;
import static quizz.QUIZZ.quizzTimer;
import static quizz.QUIZZ.quizzScreenAnswer;
import static quizz.QUIZZ.quizzScreenShowImage;

/**
 *
 * @author Mama
 */
public class PlayerBtn extends JButton implements ActionListener {

    static public ResultSet rsQ;
    static public ResultSet rsS;

    PlayerBtn(String str) {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Statistiques".equals(this.getText())) {
            playerScreenStat.setVisible(true);
            playerScreenHome.setVisible(false);
        } else if ("Classement".equals(this.getText())) {
            playerScreenHome.setVisible(false);
            playerScreenRankQuizz.setVisible(true);
        } else if ("Déconnexion".equals(this.getText())) {
            player = null;
            playerScreenHome.setVisible(false);
            connectionScreen.txtUser.setText("");
            connectionScreen.txtPwd.setText("");
            connectionScreen.setVisible(true);
        } else if ("Retour".equals(this.getText())) {
            playerScreenRankQuizz.setVisible(false);
            playerScreenStat.setVisible(false);
            playerScreenHome.setVisible(true);
        } else if ("Jouer".equals(this.getText())) {
            playerScreenHome.setVisible(false);
            playerScreenHome.dispose();
            //BDD
            java.sql.Statement statement;
            try {
                statement = DBConnect.Connect();

                //ID
                ResultSet rsID = statement.executeQuery("SELECT nbquestionquiz, iddifficulte from QUIZ "
                        + "WHERE idquiz = " + quiz.getId());
                rsID.next();
                quiz.setNbQuestion(rsID.getInt("nbquestionquiz"));
                quiz.setDifficulte(rsID.getInt("iddifficulte"));

                rsID = statement.executeQuery("Select count(idSolution) from solution s, question q , composer c"
                        + " where c.idquiz = " + quiz.getId()
                        + " and c.idquestion = q.idquestion and q.idquestion = s.idquestion"
                        + " and s.estJuste = 1");
                rsID.next();
                quiz.setNbTtRightRep(rsID.getInt(1));

                //Question
                rsQ = statement.executeQuery("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT,  COMPOSER C,  QUIZ Q  "
                        + "WHERE Q.IDQUIZ = " + quiz.getId()
                        + " AND C.IDQUIZ = Q.IDQUIZ "
                        + "AND QT.IDQUESTION = C.IDQUESTION");
                rsQ.next();
                question = new Question(rsQ.getInt("idquestion"));
                question.setLblQuestion(rsQ.getString("lblquestion"));
                question.setUrlQuestion(rsQ.getString("urlQuestion"));

                //Solution
                rsS = statement.executeQuery("SELECT idsolution, lblsolution, estJuste from SOLUTION S, QUESTION QT "
                        + "WHERE QT.IDQUESTION = " + question.getIdQuestion()
                        + "AND QT.IDQUESTION = S.IDQUESTION");
                rsS.next();
                question.incNbReponse();
                answer1 = new Answer(rsS.getInt("idsolution"));
                answer1.setLblAnswer(rsS.getString("lblsolution"));
                answer1.setCorrection(rsS.getInt("estJuste"));

                rsS.next();
                question.incNbReponse();
                answer2 = new Answer(rsS.getInt("idsolution"));
                answer2.setLblAnswer(rsS.getString("lblsolution"));
                answer2.setCorrection(rsS.getInt("estJuste"));

                if (rsS.next() == true) {
                    question.incNbReponse();
                    answer3 = new Answer(rsS.getInt("idsolution"));
                    answer3.setLblAnswer(rsS.getString("lblsolution"));
                    answer3.setCorrection(rsS.getInt("estJuste"));
                    if (rsS.next() == true) {
                        question.incNbReponse();
                        answer4 = new Answer(rsS.getInt("idsolution"));
                        answer4.setLblAnswer(rsS.getString("lblsolution"));
                        answer4.setCorrection(rsS.getInt("estJuste"));
                    }
                }
                try {
                    if (question.getUrlQuestion() != null) {
                        quizzScreenShowImage = new QuizzScreenShowImage(question.getUrlQuestion());
                        quizzScreenShowImage.setVisible(true);
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                BtnColor = new int[quiz.getNbQuestion()];
                for (int i = 0; i < quiz.getNbQuestion(); i++) {
                    BtnColor[i] = 0;
                }
                quizzTimer = new QuizzTimer();
                quizzTimer.setMinute(0);
                quizzTimer.setSeconde(0);
                quizzScreenAnswer = new QuizzScreenAnswer();
                quizzScreenAnswer.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(PlayerBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
