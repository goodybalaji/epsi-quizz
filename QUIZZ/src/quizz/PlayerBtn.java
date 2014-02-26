/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            quizzScreenAnswer.setVisible(true);
        }
    }

}
