/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.adminScreenHome;
import static quizz.QUIZZ.quizzScreenCreation;

/**
 *
 * @author Mama
 */
public class AdminBtn extends JButton implements ActionListener
{
    AdminBtn(String str)
    {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Deconnexion".equals(this.getText()))
        {
            adminScreenHome.setVisible(false);
            connectionScreen.setVisible(true);
        }
        else if(this.getName().equalsIgnoreCase("btnModifAdmin"))
        {
            
        }
        else if(this.getName().equalsIgnoreCase("btnDelAdmin"))
        {
            
        }
        else if(this.getName().equalsIgnoreCase("btnNewAdmin"))
        {
            
        }
        else if("Nouveau".equals(this.getText()))
        {
            quizzScreenCreation.setVisible(true);
            adminScreenHome.setVisible(false);
        }
    }
    
}