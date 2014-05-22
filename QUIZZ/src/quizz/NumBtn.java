/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static quizz.QUIZZ.quizzScreenAnswer;
import static java.awt.Color.RED;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quizz.PlayerBtn.rsQ;
import static quizz.PlayerBtn.rsS;
import static quizz.QUIZZ.answer1;
import static quizz.QUIZZ.answer2;
import static quizz.QUIZZ.answer3;
import static quizz.QUIZZ.answer4;
import static quizz.QUIZZ.question;
import static quizz.QUIZZ.quiz;
import static quizz.QUIZZ.quizzScreenShowImage;
import static quizz.QuizzScreenAnswer.cbxQ1;
import static quizz.QuizzScreenAnswer.cbxQ2;
import static quizz.QuizzScreenAnswer.cbxQ3;
import static quizz.QuizzScreenAnswer.cbxQ4;

/**
 *
 * @author Arc
 */
public class NumBtn extends JButton implements ActionListener {

    public int idQuestion;

    NumBtn(String str) {
        super(str);
    }

    public void setIdQuestion(int i) {
        idQuestion = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (quizzScreenShowImage != null){
                quizzScreenShowImage.dispose();
            }
            Statement statement = DBConnect.Connect();
            quiz.setCurrentQuestion(Integer.parseInt(this.getText()));
            rsQ = statement.executeQuery("SELECT QT.lblQuestion, QT.urlQuestion from QUESTION QT "
                    + "where idQuestion = " + idQuestion);
            rsQ.next();
            question = new Question(idQuestion);
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

            quizzScreenAnswer.dispose();
            quizzScreenAnswer = new QuizzScreenAnswer();
            quizzScreenAnswer.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(NumBtn.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (question.getUrlQuestion() != null) {
                quizzScreenShowImage = new QuizzScreenShowImage(question.getUrlQuestion());
                quizzScreenShowImage.setVisible(true);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
