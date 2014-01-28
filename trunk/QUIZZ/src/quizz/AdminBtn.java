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
public class AdminBtn extends JButton implements ActionListener
{
    AdminBtn(String str)
    {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.getName().equalsIgnoreCase("btnClassAdmin"))
        {
            
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
    }
    
}
