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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.BtnColor;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.quizzScreenAnswer;
import static quizz.QUIZZ.quizzScreenShowImage;
import static quizz.QUIZZ.quizzScreenFinish;
import static quizz.QuizzScreenAnswer.numQuestion;
import static quizz.QuizzScreenAnswer.cbxQ1;
import static quizz.QuizzScreenAnswer.cbxQ2;
import static quizz.QuizzScreenAnswer.cbxQ3;
import static quizz.QuizzScreenAnswer.cbxQ4;
import static quizz.PlayerBtn.quizNbQuestion;
import static quizz.PlayerBtn.leQuiz;
import static quizz.PlayerBtn.quizIdQuestion;
import static quizz.PlayerBtn.rsQ;
import static quizz.PlayerBtn.rsS;
import static quizz.PlayerBtn.quizQuestion;
import static quizz.PlayerBtn.quizSolution1;
import static quizz.PlayerBtn.quizSolution2;
import static quizz.PlayerBtn.quizSolution3;
import static quizz.PlayerBtn.quizSolution4;
import static quizz.PlayerBtn.quizUrlQuestion;
import static quizz.QUIZZ.quizzTimer;
import static quizz.PlayerBtn.AnswerCpt;
import static quizz.PlayerBtn.scorePlayer;
import static quizz.PlayerBtn.timeMinute;
import static quizz.PlayerBtn.timeSecond;
import static quizz.QUIZZ.calculScore;
import static quizz.QUIZZ.quiz;

/**
 *
 * @author Mama
 */
public class QuizzBtn extends JButton implements ActionListener {

    public int compteurQ = 1;
    public int answers[] = new int[quizNbQuestion+1];
    public double nbCorrectAnswers = 0;
    public int[] idJust;
    public double coeffDiff;
    public double minute = quizzTimer.getMinute();
    public double second = quizzTimer.getSeconde();
    
    public double timeT = minute + (second / 100);
    public static double scoreQuiz = 0;

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
                    "Voulez-vous valider votre quizz ? Attention, toute question non validée sera considérée comme fausse !",
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

                java.sql.Statement statement;
                try {
                    statement = DBConnect.Connect();
                    ResultSet rsIdS = statement.executeQuery("SELECT idSolution from SOLUTION S, QUESTION QT, composer c "
                            + "WHERE c.IDQUIZ = " + quiz.getId()
                            + " AND QT.IDQUESTION = S.IDQUESTION"
                            + " AND c.IDquestion = QT.IDQUESTION"
                            + " AND S.ESTJUSTE = 1");
                    int i = 0;
                    while (rsIdS.next()) {
                        i++;
                    }
                    idJust = new int[i+1];
                    rsIdS.first();
                    idJust[1] = rsIdS.getInt("idSolution");
                    int j = 2;
                    while (rsIdS.next()){
                        idJust[j] = rsIdS.getInt("idSolution"); 
                        j++;
                    }
                    for (i = 1; i <= idJust.length-1; i++) {
                        if (answers[i] == idJust[i]) {
                            nbCorrectAnswers++;
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    statement = DBConnect.Connect();
                    ResultSet rsDiff = statement.executeQuery("SELECT idDifficulte FROM QUIZ"
                            + " WHERE idQuiz = " + quiz.getId());
                    rsDiff.next();
                    coeffDiff = rsDiff.getInt("idDifficulte");
                    System.out.println("temps : "+minute+" "+second);
                    System.out.println(nbCorrectAnswers);
                    calculScore = new CalculScore(nbCorrectAnswers, coeffDiff, timeT);

                } catch (SQLException ex) {
                    Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizNbQuestion = 0;
                numQuestion = 1;
                quizzTimer = new QuizzTimer();
                quizzScreenAnswer.setVisible(false);
                quizzScreenFinish = new QuizzScreenFinish();
                quizzScreenFinish.setVisible(true);
            }
        } else if ("  Suivant  ".equals(this.getText())) {
            if (quizzScreenShowImage != null) {
                quizzScreenShowImage.dispose();
            }
            if (numQuestion < quizNbQuestion) {
                numQuestion++;
                java.sql.Statement statement;

                try {
                    statement = DBConnect.Connect();

                    //Question
                    rsQ = statement.executeQuery("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT, COMPOSER C, QUIZ Q "
                            + "WHERE Q.IDQUIZ = " + quiz.getId()
                            + "AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
                    rsQ.next();
                    for (int i = 0; i < numQuestion - 1; i++) {

                        rsQ.next();
                    }
                    compteurQ++;
                    quizQuestion = rsQ.getString("lblquestion");
                    quizIdQuestion = rsQ.getInt("idquestion");
                    quizUrlQuestion = rsQ.getString("urlquestion");
                    //SOLUTION
                    rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                            + "WHERE QT.IDQUESTION = " + quizIdQuestion
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
                    cbxQ1.setSelected(false);
                    cbxQ2.setSelected(false);
                    cbxQ3.setSelected(false);
                    cbxQ4.setSelected(false);

                } catch (SQLException ex) {
                    Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizzScreenAnswer.dispose();
                quizzScreenAnswer = new QuizzScreenAnswer();
                try {
                    if (quizUrlQuestion != null) {
                        quizzScreenShowImage = new QuizzScreenShowImage(quizUrlQuestion);
                        quizzScreenShowImage.setVisible(true);
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizzScreenAnswer.setVisible(true);
            }
        } else if ("Précédent".equals(this.getText())) {
            if (quizzScreenShowImage != null) {
                quizzScreenShowImage.dispose();
            }
            if (numQuestion > 1) {
                numQuestion--;
                try {
                    java.sql.Statement statement;
                    statement = DBConnect.Connect();

                    //Question
                    rsQ = statement.executeQuery("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT, COMPOSER C, QUIZ Q "
                            + "WHERE Q.IDQUIZ = " + quiz.getId()
                            + "AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
                    rsQ.next();
                    for (int i = 0; i < numQuestion; i++) {
                        rsQ.next();
                    }
                    rsQ.previous();
                    quizQuestion = rsQ.getString("lblquestion");
                    quizIdQuestion = rsQ.getInt("idquestion");
                    quizUrlQuestion = rsQ.getString("urlquestion");
                    //SOLUTION
                    rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                            + "WHERE QT.IDQUESTION = " + quizIdQuestion
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
                try {
                    if (quizUrlQuestion != null) {
                        quizzScreenShowImage = new QuizzScreenShowImage(quizUrlQuestion);
                        quizzScreenShowImage.setVisible(true);
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizzScreenAnswer.setVisible(true);
            }
        } else if ("Masquer".equals(this.getText())) {
            quizzScreenShowImage.dispose();

        } else if ("Quitter".equals(this.getText())) {
            playerScreenHome.setVisible(true);
            quizzScreenFinish.setVisible(false);
        } else if ("Valider Question".equals(this.getText()) && (cbxQ1.isSelected() || cbxQ2.isSelected() || cbxQ3.isSelected() || cbxQ4.isSelected())) {
            try {

                java.sql.Statement statement;
                statement = DBConnect.Connect();
                
                if (cbxQ1.isSelected()) {
                    ResultSet rsJust = statement.executeQuery("SELECT idSolution FROM SOLUTION "
                            + "WHERE lblSolution = '" + quizSolution1 + "' "
                            + "AND idQuestion = " + quizIdQuestion);
                    rsJust.next();
                    answers[numQuestion] = rsJust.getInt("idSolution");
                } else if (cbxQ2.isSelected()) {
                    ResultSet rsJust = statement.executeQuery("SELECT idSolution FROM SOLUTION "
                            + "WHERE lblSolution = '" + quizSolution2 + "' "
                            + "AND idQuestion = " + quizIdQuestion);
                    rsJust.next();
                    answers[numQuestion] = rsJust.getInt("idSolution");
                } else if (cbxQ3.isSelected()) {
                    ResultSet rsJust = statement.executeQuery("SELECT idSolution FROM SOLUTION "
                            + "WHERE lblSolution = '" + quizSolution3 + "' "
                            + "AND idQuestion = " + quizIdQuestion);
                    rsJust.next();
                    answers[numQuestion] = rsJust.getInt("idSolution");
                } else if (cbxQ4.isSelected()) {
                    ResultSet rsJust = statement.executeQuery("SELECT idSolution FROM SOLUTION "
                            + "WHERE lblSolution = '" + quizSolution4 + "' "
                            + "AND idQuestion = " + quizIdQuestion);
                    rsJust.next();
                    answers[numQuestion] = rsJust.getInt("idSolution");
                } else {
                    answers[numQuestion] = 0;
                }
                if (numQuestion < quizNbQuestion) {

                    BtnColor[numQuestion - 1] = 1;
                    numQuestion++;

                    //Question
                    rsQ = statement.executeQuery("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT, COMPOSER C, QUIZ Q "
                            + "WHERE Q.IDQUIZ = " + quiz.getId()
                            + "AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
                    rsQ.next();
                    for (int i = 0; i < numQuestion - 1; i++) {

                        rsQ.next();
                    }
                    compteurQ++;
                    quizQuestion = rsQ.getString("lblquestion");
                    quizIdQuestion = rsQ.getInt("idquestion");
                    quizUrlQuestion = rsQ.getString("urlquestion");
                    //SOLUTION
                    rsS = statement.executeQuery("SELECT lblsolution from SOLUTION S, QUESTION QT "
                            + "WHERE QT.IDQUESTION = " + quizIdQuestion
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
            if (quizzScreenShowImage != null) {
                quizzScreenShowImage.dispose();
            }
            quizzScreenAnswer = new QuizzScreenAnswer();
            try {
                System.out.println(quizUrlQuestion);
                if (quizUrlQuestion != null) {
                    quizzScreenShowImage = new QuizzScreenShowImage(quizUrlQuestion);
                    quizzScreenShowImage.setVisible(true);
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
            quizzScreenAnswer.setVisible(true);
        } else {
            int reponse = JOptionPane.showConfirmDialog(this,
                    "Vous avez validé toutes les questions, voulez-vous terminer le quiz ?",
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
        }
    }
}
