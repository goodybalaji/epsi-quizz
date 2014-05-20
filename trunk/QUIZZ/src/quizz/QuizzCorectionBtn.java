/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.quiz;
import static quizz.QUIZZ.quizzScreenAddImage;
import static quizz.QUIZZ.quizzScreenQuestionCorrection;
import static quizz.QuizzCreationBtn.icon;

/**
 *
 * @author Mama
 */
public class QuizzCorectionBtn extends JButton implements ActionListener {

    QuizzCorectionBtn(String str) {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("  Suivant  ".equals(this.getText())) {
            try {
                quizzScreenQuestionCorrection.dispose();
                quiz.incCurrentQuestion();
                quizzScreenQuestionCorrection = new QuizzScreenQuestionCorrection();
                quizzScreenQuestionCorrection.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(QuizzCorectionBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Finir Correction".equals(this.getText())) {
            try {
                playerScreenHome.dispose();
                playerScreenHome = new PlayerScreenHome();
                playerScreenHome.setVisible(true);
                quizzScreenQuestionCorrection.dispose();
                quiz = null;
            } catch (SQLException ex) {
                Logger.getLogger(QuizzCorectionBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Visualiser".equals(this.getText())) {
            if (!quizzScreenQuestionCorrection.imageQuestion.getText().toString().equals("")) {
                try {
                    icon = new ImageIcon(new ImageIcon(new URL(quizzScreenQuestionCorrection.imageQuestion.getText().toString())).getImage());
                    quizzScreenAddImage = new QuizzScreenAddImage();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                }
                quizzScreenAddImage.setVisible(true);
            }
        }
    }

}
