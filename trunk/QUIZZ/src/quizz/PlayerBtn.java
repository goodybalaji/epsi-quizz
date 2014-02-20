/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static quizz.QUIZZ.playerRankQuizzScreen;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.playerScreenStat;


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
        if("btnStatPlayer".equals(this.getName()))
        {
            playerScreenStat.setVisible(true);
            playerScreenHome.setVisible(false);
        }
        else if(this.getName().equalsIgnoreCase("btnRankPlayer"))
        {
            playerScreenHome.setVisible(false);
            playerRankQuizzScreen.setVisible(false);
        }
        else if(this.getName().equalsIgnoreCase("btnPlayPlayer"))
        {
            
        }
    }
    
}
