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
public class QuizzBtn extends JButton implements ActionListener
{
    QuizzBtn(String str)
    {
        super(str);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.getName().equalsIgnoreCase("btnQuitterPlayer"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnValideQuizz"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnValideQuestion"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnNextAnswer"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnPreviousAnswer"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnQuitterAdmin"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnNextQuestion"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnNextCorrection"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnPreviousCorrection"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnNextQuestionCreation"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnPreviousQuestionCreation"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnToCorrection"))
        {
            
        }
        else if (this.getName().equalsIgnoreCase("btnToRanking"))
        {
            
        }        
    }    
}
