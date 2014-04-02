/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
import static quizz.QuizzScreenCreation.txtNameQuizz;

/**
 *
 * @author Arc
 */
public class QuizzCreationBtn extends JButton implements ActionListener{
    
    QuizzCreationBtn(String str)
    {
        super(str);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if ("Suivant".equals(this.getName()))
        {
            
            quizzScreenCreation.setVisible(false);
            quizzScreenQuestionCreation.setVisible(true);
            
            try
                    {
                        //création de la variable de connexion
                        final java.sql.Statement statement = DBConnect.Connect();
                       ResultSet rs = statement.executeQuery("INSERT INTO QUIZZ"
                                + "VALUES (" + QuizzScreenCreation.txtNameQuizz.getText().toString() + ") ");
                               
                    }
            catch (SQLException ex)
                    {
                        Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                    } 
        }
    }
}
