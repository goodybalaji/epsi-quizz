/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static quizz.QuizzScreenAnswer.numQuestion;
import static quizz.QUIZZ.quizzScreenAnswer;
import java.awt.Color;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.PageAttributes.ColorType.COLOR;
import javax.swing.SwingUtilities;
/**
 *
 * @author Arc
 */
public class NumBtn extends JButton implements ActionListener{
    NumBtn(String str)
    {
        super(str);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setBackground(RED);
       
        numQuestion= Integer.parseInt(this.getText());
          /*  quizzScreenAnswer.dispose();
            quizzScreenAnswer = new QuizzScreenAnswer();
            quizzScreenAnswer.setVisible(true);
    */
        quizzScreenAnswer.revalidate();
    quizzScreenAnswer.repaint();
    quizzScreenAnswer.lblNbQuestion.revalidate();
    quizzScreenAnswer.lblNbQuestion.repaint();
    }
}
