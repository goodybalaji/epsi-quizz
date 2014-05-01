/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.admin;
import static quizz.QUIZZ.adminScreenHome;
import static quizz.QUIZZ.quiz;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenAddImage;
import static quizz.QUIZZ.quizzScreenQuestionCreation;


/**
 *
 * @author Arc
 */
public class QuizzCreationBtn extends JButton implements ActionListener{
    
    public JLabel lbl,lbl1;
    public int indiceReponse;
    public JTextField txtRep;
    public JCheckBox cbx;
    public static ImageIcon icon;
    
    
    QuizzCreationBtn(String str)
    {
        super(str);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if ("Suivant".equals(this.getText()))
        {
            if (quizzScreenCreation.txtNameQuizz.getText().toString().isEmpty() != true)
            {
                int idDifficulte = 1;
                if (quizzScreenCreation.cbxLevel.getSelectedItem().toString().equals("Moyen"))
                {
                    idDifficulte = 2;
                }
                else if (quizzScreenCreation.cbxLevel.getSelectedItem().toString().equals("Difficile"))
                {
                    idDifficulte = 3;
                }
                int idThema = 1;
                
                if (quizzScreenCreation.cbxTheme.getSelectedItem().toString().equals("Sport"))
                {
                    idThema = 1;
                }
                else if (quizzScreenCreation.cbxTheme.getSelectedItem().toString().equals("Cinema"))
                {
                    idThema = 2;
                }
                else if (quizzScreenCreation.cbxTheme.getSelectedItem().toString().equals("Serie"))
                {
                    idThema = 3;
                }
                else if (quizzScreenCreation.cbxTheme.getSelectedItem().toString().equals("Histoire"))
                {
                    idThema = 4;
                }
                try
                {
                    //création de la variable de connexion
                    final java.sql.Statement statement = DBConnect.Connect();

                   
                    System.out.println();
                    ResultSet rs = statement.executeQuery("INSERT INTO QUIZ "

                    + "VALUES (inc_quiz_seq.NEXTVAL," + idDifficulte + ", " + idThema + ", "
                    + admin.getId() +", '"+ quizzScreenCreation.txtNameQuizz.getText().toString() + "', 0,'"
                    + quizzScreenCreation.txtTemps.getText().toString() +"', sysdate, 0)");
                    
                    rs = statement.executeQuery("Select Max(idQuiz) from QUIZ");
                    rs.next();
                    int idQuiz = rs.getInt(1);
                    quiz = new Quiz(idQuiz);                    
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                quizzScreenCreation.setVisible(false);
                quizzScreenQuestionCreation.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(quizzScreenCreation, "Vous devez donner un nom au QWIZZ avant de pouvoir le créer !!");
            }
        }
        else if("Quitter".equals(this.getText()))
        {
           quizzScreenCreation.setVisible(false);
           adminScreenHome.setVisible(true);
        }
       else if ("Annuler".equals(this.getText())){
           quizzScreenAddImage.setVisible(false);
       }

       else if ("Valider".equals(this.getText())){
           try {
               icon = new ImageIcon(new ImageIcon(new URL(quizzScreenQuestionCreation.imageQuestion.getText().toString())).getImage());
               quizzScreenAddImage = new QuizzScreenAddImage();
           } catch (MalformedURLException ex) {
               Logger.getLogger(QuizzCreationBtn.class.getName()).log(Level.SEVERE, null, ex);
           }
           quizzScreenAddImage.setVisible(true);
       }

       else if ("  Suivant  ".equals(this.getText())){
           quiz.incNbQuestion();
           if (!quizzScreenQuestionCreation.txtQuestion.toString().isEmpty() && !quizzScreenQuestionCreation.txtRep1.toString().isEmpty()
              && !quizzScreenQuestionCreation.txtRep2.toString().isEmpty())
           {
              /* if(quizzScreenQuestionCreation.cbxQ1.)*/
           }
           else
           {
               JOptionPane.showMessageDialog(quizzScreenCreation, "Il faut créer un question avec deux question au minimum pour qu'elle soit valide");
           }
           
       }
       else if("Finir".equals(this.getText())){
           quizzScreenCreation.setVisible(false);
           adminScreenHome.setVisible(true);
       }

       
    }
}
