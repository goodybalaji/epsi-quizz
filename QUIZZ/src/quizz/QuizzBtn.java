/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.quizzScreenAddImage;
import static quizz.QUIZZ.quizzScreenShowImage;
import static quizz.QUIZZ.quizzScreenAnswer;
import static quizz.QUIZZ.quizzScreenFinish;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
import static quizz.QuizzCreationBtn.icon;
import static quizz.QuizzScreenAnswer.numQuestion;

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
        else if("  Suivant  ".equals(this.getText()))
        {
            numQuestion++;
            quizzScreenAnswer = new QuizzScreenAnswer();
               if(true){
                   try {
                        icon = new ImageIcon(new ImageIcon(new URL("http://blog.fysiki.com/wp-content/uploads/2010/07/biere.jpg")).getImage());
                        quizzScreenShowImage = new QuizzScreenShowImage();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    quizzScreenShowImage.setVisible(true);
               }
        }
        else if("Précédent".equals(this.getText()))
        {
            if(numQuestion>1)
            {

            }
        }
        else if("Masquer".equals(this.getText()))
        {
            quizzScreenShowImage.setVisible(false);
        }
        
    }    
}
