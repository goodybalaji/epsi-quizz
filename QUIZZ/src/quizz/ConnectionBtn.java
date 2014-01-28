/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.connectionScreen;
/**
 *
 * @author Mama
 */
public class ConnectionBtn extends JButton implements ActionListener
{
    ConnectionBtn(String str)
    {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ("btnConnection".equals(this.getName()))
        {
            playerScreenHome.setVisible(true);
            connectionScreen.setVisible(false);
        }
        else if ("btnDeco".equals(this.getName()))
        {
            connectionScreen.setVisible(true);
            playerScreenHome.setVisible(false);
            
        }
    }
}
