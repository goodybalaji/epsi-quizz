/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.quizzScreenAnswer;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenFinish;

/**
 *
 * @author Mama
 */
public class QuizzBtn extends JButton implements ActionListener
{
    QuizzBtn(String str)
    {
        super(str);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("Abandonner".equals(this.getText()))
        {
            int reponse = JOptionPane.showConfirmDialog(this,
                "Voulez-vous abandonner le quizz ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                quizzScreenAnswer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		if(reponse == JOptionPane.YES_OPTION ){
			playerScreenHome.setVisible(true);
                        quizzScreenAnswer.dispose();
		}
        }
        else if("Valider Quizz".equals(this.getText()))
        {
                int reponse = JOptionPane.showConfirmDialog(this,
                "Voulez-vous valider votre quizz ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                quizzScreenAnswer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		if(reponse == JOptionPane.YES_OPTION ){
			quizzScreenFinish.setVisible(true);
                        quizzScreenAnswer.dispose();
		}
        }
    }    
}
