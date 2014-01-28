/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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
        if(this.getName().equalsIgnoreCase("btnStatPlayer"))
        {
            
        }
        else if(this.getName().equalsIgnoreCase("btnRankPlayer"))
        {
            
        }
        else if(this.getName().equalsIgnoreCase("btnRetour"))
        {
            
        }
        else if(this.getName().equalsIgnoreCase("btnPlayPlayer"))
        {
            
        }
    }
    
}
