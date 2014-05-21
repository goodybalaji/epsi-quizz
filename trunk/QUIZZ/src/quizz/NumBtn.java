/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static quizz.QUIZZ.quizzScreenAnswer;
import static java.awt.Color.RED;
import static quizz.QUIZZ.quiz;
/**
 *
 * @author Arc
 */
public class NumBtn extends JButton implements ActionListener{
    public int idQuestion;
    
    NumBtn(String str)
    {
        super(str);
    }
    
    public void setIdQuestion(int i)
    {
        idQuestion = i;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setBackground(RED);
       
        quiz.setCurrentQuestion(Integer.parseInt(this.getText()));
       // BtnColor[numQuestion-1]=1;
        quizzScreenAnswer.dispose();
        quizzScreenAnswer = new QuizzScreenAnswer();
        quizzScreenAnswer.setVisible(true);
 
    }
}
