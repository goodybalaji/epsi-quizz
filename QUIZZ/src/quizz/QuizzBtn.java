/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quizz.PlayerBtn.rsQ;
import static quizz.PlayerBtn.rsS;
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
import static quizz.QUIZZ.quizzTimer;
import static quizz.PlayerBtn.timeMinute;
import static quizz.PlayerBtn.timeSecond;
import static quizz.QUIZZ.answer1;
import static quizz.QUIZZ.answer2;
import static quizz.QUIZZ.answer3;
import static quizz.QUIZZ.answer4;
import static quizz.QUIZZ.calculScore;
import static quizz.QUIZZ.question;
import static quizz.QUIZZ.quiz;

/**
 *
 * @author Mama
 */
public class QuizzBtn extends JButton implements ActionListener {

    public int compteurQ = 1;
    public double nbCorrectAnswers = 0;
    public int[] idJust;
    public double coeffDiff;
    public double minute = quizzTimer.getMinute();
    public double second = quizzTimer.getSeconde();


    public double timeT = minute + (second / 100);

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
                BtnColor = new int[40];
                for (int i = 0; i < 40; i++) {
                    BtnColor[i] = 0;
                }
                calculScore = new CalculScore(quiz.getNbRigthRep(), quiz.getDifficulte(), timeT);
                quizzTimer = null;
                quizzScreenAnswer.setVisible(false);
                quizzScreenFinish = new QuizzScreenFinish();
                quizzScreenFinish.setVisible(true);
            }
        } else if ("  Suivant  ".equals(this.getText())) {
            if (quizzScreenShowImage != null) {
                quizzScreenShowImage.dispose();
            }

            if (numQuestion < quiz.getNbQuestion()) {
                numQuestion++;
                java.sql.Statement statement;

                try {
                    statement = DBConnect.Connect();

                    //Question
                    System.out.println("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT,  COMPOSER C,  QUIZ Q  "
                            + "WHERE Q.IDQUIZ = " + quiz.getId()
                            + " AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
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
                    if (question.getUrlQuestion() != null) {
                        quizzScreenShowImage = new QuizzScreenShowImage(question.getUrlQuestion());
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
                    System.out.println("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT,  COMPOSER C,  QUIZ Q  "
                            + "WHERE Q.IDQUIZ = " + quiz.getId()
                            + " AND C.IDQUIZ = Q.IDQUIZ "
                            + "AND QT.IDQUESTION = C.IDQUESTION");
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
                    if (question.getUrlQuestion() != null) {
                        quizzScreenShowImage = new QuizzScreenShowImage(question.getUrlQuestion());
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

                //Question
                System.out.println("SELECT QT.idQuestion, QT.lblQuestion, QT.urlQuestion from QUESTION QT,  COMPOSER C,  QUIZ Q  "
                        + "WHERE Q.IDQUIZ = " + quiz.getId()
                        + " AND C.IDQUIZ = Q.IDQUIZ "
                        + "AND QT.IDQUESTION = C.IDQUESTION");
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
                cbxQ1.setSelected(false);
                cbxQ2.setSelected(false);
                cbxQ3.setSelected(false);
                cbxQ4.setSelected(false);
                if (numQuestion < quiz.getNbQuestion()) {

                    BtnColor[numQuestion - 1] = 1;
                    numQuestion++;
                    if (cbxQ1.isSelected()) {
                        if(answer1.getCorrection() == 1){
                            quiz.incNbRightRep();
                        } else {
                            quiz.decNbRightRep();
                        }
                    } 
                    if (cbxQ2.isSelected()) {
                         if(answer1.getCorrection() == 1){
                            quiz.incNbRightRep();
                        } else {
                            quiz.decNbRightRep();
                        }
                    }
                    if (cbxQ3.isSelected()) {
                        if(answer1.getCorrection() == 1){
                            quiz.incNbRightRep();
                        } else {
                            quiz.decNbRightRep();
                        }
                    }
                    if (cbxQ4.isSelected()) {
                        if(answer1.getCorrection() == 1){
                            quiz.incNbRightRep();
                        } else {
                            quiz.decNbRightRep();
                        }
                    }                    
                    timeMinute += quizzTimer.minute;
                    timeSecond += quizzTimer.seconde;
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
                        System.out.println(question.getUrlQuestion());
                        if (question.getUrlQuestion() != null) {
                            quizzScreenShowImage = new QuizzScreenShowImage(question.getUrlQuestion());
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
                        
                        quiz = null;
                        quizzTimer = null;
                        quizzScreenAnswer.setVisible(false);
                        quizzScreenFinish = new QuizzScreenFinish();
                        quizzScreenFinish.setVisible(true);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuizzBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
