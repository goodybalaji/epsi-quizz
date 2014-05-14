/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.BtnColor;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.quizzScreenAddImage;
import static quizz.QUIZZ.quizzScreenAnswer;
import static quizz.QUIZZ.quizzScreenShowImage;
import static quizz.QUIZZ.quizzScreenFinish;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
import static quizz.QuizzCreationBtn.icon;
import static quizz.QuizzScreenAnswer.numQuestion;
import static quizz.QuizzScreenAnswer.cbxQ1;
import static quizz.QuizzScreenAnswer.cbxQ2;
import static quizz.QuizzScreenAnswer.cbxQ3;
import static quizz.QuizzScreenAnswer.cbxQ4;
import static quizz.QuizzScreenAnswer.quizzTimer;
import static quizz.PlayerBtn.quizNbQuestion;
import static quizz.PlayerBtn.leQuiz;
import static quizz.PlayerBtn.leQuizIdQuestion;
import static quizz.PlayerBtn.rsQ;
import static quizz.PlayerBtn.rsS;
import static quizz.PlayerBtn.quizQuestion;
import static quizz.PlayerBtn.quizSolution1;
import static quizz.PlayerBtn.quizSolution2;
import static quizz.PlayerBtn.quizSolution3;
import static quizz.PlayerBtn.quizSolution4;
import static quizz.PlayerBtn.AnswerCpt;
import static quizz.PlayerBtn.scorePlayer;
import static quizz.PlayerBtn.timeMinute;
import static quizz.PlayerBtn.timeSecond;

/**
 *
 * @author Mama
 */
public class QuizzBtn extends JButton implements ActionListener {

    public int compteurQ = 1;
    
    
    QuizzBtn(String str) {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Abandonner".equals(this.getText())) {
            int reponse = JOptionPane.showConfirmDialog(this,
                    "Voulez-vous abandonner le quizz ?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            quizzScreenAnswer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            if (reponse == JOptionPane.YES_OPTION) {
                playerScreenHome.setVisible(true);
                quizzScreenAnswer.dispose();
            }
        } else if ("Valider Quizz".equals(this.getText())) {
            int reponse = JOptionPane.showConfirmDialog(this,
                    "Voulez-vous valider votre quizz ?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            quizzScreenAnswer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            if (reponse == JOptionPane.YES_OPTION) {
                leQuiz = null;
                BtnColor = new int[40];
                for (int i = 0; i < 40; i++) {
                    BtnColor[i] = 0;
                }
                quizNbQuestion = 0;
                numQuestion = 1;
                quizzTimer = new QuizzTimer();
                quizzScreenAnswer.setVisible(false);
                quizzScreenFinish = new QuizzScreenFinish();
                quizzScreenFinish.setVisible(true);
            }
        } else if ("  Suivant  ".equals(this.getText())) {
            if (numQuestion < quizNbQuestion) {
                numQuestion++;
                java.sql.Statement statement;

                try {
                    statement = DBConnect.Connect();

                    //Question
                    rsQ = statement.executeQuery("SELECT lblquestion, QT.idquestion from QUESTION QT, COMPOSER C, QUIZ Q "
                            + "WHERE Q.IDQUIZ = " + playerScreenHome.idQuiz
                            + "AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
                    rsQ.next();
                    for (int i = 0; i < numQuestion - 1; i++) {

                        rsQ.next();
                    }
                    compteurQ++;
                    quizQuestion = rsQ.getString("lblquestion");
                    leQuizIdQuestion = rsQ.getInt("idquestion");
             
                    //SOLUTION
                    rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                            + "WHERE QT.IDQUESTION = " + leQuizIdQuestion
                            + "AND QT.IDQUESTION = S.IDQUESTION");
                    rsS.next();
                    quizSolution1 = rsS.getString("lblsolution");
                    rsS.next();
                    quizSolution2 = rsS.getString("lblsolution");
                    if (rsS.next() == true) {
                        quizSolution3 = rsS.getString("lblsolution");
                        AnswerCpt++;
                        if (rsS.next() == true) {
                            quizSolution4 = rsS.getString("lblsolution");
                            AnswerCpt++;
                        }
                    }

                    
                } catch (SQLException ex) {
                    Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizzScreenAnswer.dispose();
                quizzScreenAnswer = new QuizzScreenAnswer();
                if (false) {
                    try {
                        icon = new ImageIcon(new ImageIcon(new URL("http://blog.fysiki.com/wp-content/uploads/2010/07/biere.jpg")).getImage());
                        quizzScreenShowImage = new QuizzScreenShowImage();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    quizzScreenShowImage.setVisible(true);
                }

                quizzScreenAnswer.setVisible(true);
            }
        } else if ("Précédent".equals(this.getText())) {
            if (numQuestion > 1) {
                numQuestion--;
                try {
                    java.sql.Statement statement;
                    statement = DBConnect.Connect();

                    //Question
                    rsQ = statement.executeQuery("SELECT lblquestion, QT.idquestion from QUESTION QT, COMPOSER C, QUIZ Q "
                            + "WHERE Q.IDQUIZ = " + playerScreenHome.idQuiz
                            + "AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
                    rsQ.next();
                    for (int i = 0; i < numQuestion; i++) {
                        rsQ.next();
                    }
                    rsQ.previous();
                    quizQuestion = rsQ.getString("lblquestion");
                    leQuizIdQuestion = rsQ.getInt("idquestion");

                    //SOLUTION
                    rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                            + "WHERE QT.IDQUESTION = " + leQuizIdQuestion
                            + "AND QT.IDQUESTION = S.IDQUESTION");
                    rsS.next();
                    quizSolution1 = rsS.getString("lblsolution");
                    rsS.next();
                    quizSolution2 = rsS.getString("lblsolution");
                    if (rsS.next() == true) {
                        quizSolution3 = rsS.getString("lblsolution");
                        AnswerCpt++;
                        if (rsS.next() == true) {
                            quizSolution4 = rsS.getString("lblsolution");
                            AnswerCpt++;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizzScreenAnswer.dispose();
                quizzScreenAnswer = new QuizzScreenAnswer();
                if (false) {
                    try {
                        icon = new ImageIcon(new ImageIcon(new URL("http://blog.fysiki.com/wp-content/uploads/2010/07/biere.jpg")).getImage());
                        quizzScreenShowImage = new QuizzScreenShowImage();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    quizzScreenShowImage.setVisible(true);
                }
                quizzScreenAnswer.setVisible(true);
            }
        } else if ("Masquer".equals(this.getText())) {
            quizzScreenShowImage.setVisible(false);

        } else if ("Quitter".equals(this.getText())) {
            playerScreenHome.setVisible(true);
            quizzScreenFinish.setVisible(false);
        } else if ("Valider Question".equals(this.getText()) && (cbxQ1.isSelected() || cbxQ2.isSelected() ||cbxQ3.isSelected() ||cbxQ4.isSelected())) {

            if (numQuestion < quizNbQuestion) {
            
                BtnColor[numQuestion - 1] = 1;
                numQuestion++;
                
                
                try {

                    java.sql.Statement statement;
                    statement = DBConnect.Connect();

                    //Question
                    rsQ = statement.executeQuery("SELECT lblquestion, QT.idquestion from QUESTION QT, COMPOSER C, QUIZ Q "
                            + "WHERE Q.IDQUIZ = " + playerScreenHome.idQuiz
                            + "AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
                    rsQ.next();
                    for (int i = 0; i < numQuestion - 1; i++) {

                        rsQ.next();
                    }
                    compteurQ++;
                    quizQuestion = rsQ.getString("lblquestion");
                    leQuizIdQuestion = rsQ.getInt("idquestion");

                    //SOLUTION
                    rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                            + "WHERE QT.IDQUESTION = " + leQuizIdQuestion
                            + "AND QT.IDQUESTION = S.IDQUESTION");
                    rsS.next();
                    quizSolution1 = rsS.getString("lblsolution");
                    rsS.next();
                    quizSolution2 = rsS.getString("lblsolution");
                    if (rsS.next() == true) {
                        quizSolution3 = rsS.getString("lblsolution");
                        AnswerCpt++;
                        if (rsS.next() == true) {
                            quizSolution4 = rsS.getString("lblsolution");
                            AnswerCpt++;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                scorePlayer++;
                timeMinute += quizzTimer.minute;
                timeSecond += quizzTimer.seconde;
                System.out.print(scorePlayer);
                cbxQ1.setSelected(false);
                cbxQ2.setSelected(false);
                cbxQ3.setSelected(false);
                cbxQ4.setSelected(false);
                quizzScreenAnswer.dispose();
                quizzScreenAnswer = new QuizzScreenAnswer();
                if (false) {
                    try {
                        icon = new ImageIcon(new ImageIcon(new URL("http://blog.fysiki.com/wp-content/uploads/2010/07/biere.jpg")).getImage());
                        quizzScreenShowImage = new QuizzScreenShowImage();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    quizzScreenShowImage.setVisible(true);
                }
                quizzScreenAnswer.setVisible(true);
            } else {
                BtnColor[numQuestion - 1] = 1;
                quizzScreenAnswer.dispose();
                quizzScreenAnswer = new QuizzScreenAnswer();
                quizzScreenAnswer.setVisible(true);
            }
        }
    }
}
