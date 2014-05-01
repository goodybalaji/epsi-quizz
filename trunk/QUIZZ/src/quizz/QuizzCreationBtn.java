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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.admin;
import static quizz.QUIZZ.adminScreenHome;
import static quizz.QUIZZ.quiz;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenAddImage;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
import static quizz.QuizzScreenQuestionCreation.numQuestion;


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
           if (quizzScreenQuestionCreation.txtQuestion.getText().isEmpty() == false && quizzScreenQuestionCreation.txtRep1.getText().isEmpty() == false
              && quizzScreenQuestionCreation.txtRep2.getText().isEmpty() == false)
           {
              if(quizzScreenQuestionCreation.cbxQ1.isSelected() == true ||
                 quizzScreenQuestionCreation.cbxQ2.isSelected() == true ||
                 quizzScreenQuestionCreation.cbxQ3.isSelected() == true ||
                 quizzScreenQuestionCreation.cbxQ4.isSelected() == true )
              {
                  if(quizzScreenQuestionCreation.imageQuestion.getText().isEmpty() == true ||
                     quizzScreenQuestionCreation.imageQuestion.getText().equals("http://"))
                  {
                      try
                      {
                            //création de la variable de connexion
                            final java.sql.Statement statement = DBConnect.Connect();
                            //création du quizz
                            
                            System.out.println("INSERT INTO QUESTION (idquestion, lblquestion) VALUES (inc_ques_seq.NEXTVAL, '" 
                                    + roping(quizzScreenQuestionCreation.txtQuestion.getText().toString())+"')");
                            ResultSet rs = statement.executeQuery("INSERT INTO QUESTION (idquestion, lblquestion) VALUES (inc_ques_seq.NEXTVAL, '" 
                                    + roping(quizzScreenQuestionCreation.txtQuestion.getText().toString())+"')");
                            rs = statement.executeQuery("select max(idquestion) from question");
                            rs.next();
                            int idQuestion = rs.getInt(1);
                            rs = statement.executeQuery("INSERT INTO composer values ("+ quiz.getId()+" ,"+idQuestion+")");
                            
                            int state;
                            //création de la solution 1
                            if(quizzScreenQuestionCreation.cbxQ1.isSelected() == true)
                            {
                                state = 1;
                            }
                            else
                            {
                                state = 0;
                            }
                            rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                    + roping(quizzScreenQuestionCreation.txtRep1.getText().toString())+"', "+idQuestion+", "
                                    +state+")");
                            //création de la solution 2
                            if(quizzScreenQuestionCreation.cbxQ2.isSelected() == true)
                            {
                                state = 1;
                            }
                            else
                            {
                                state = 0;
                            }
                            rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                    + roping(quizzScreenQuestionCreation.txtRep2.getText().toString())+"', "+idQuestion+", "
                                    +state+")");
                            //vérification d'une solution 3 et création
                            if(!quizzScreenQuestionCreation.txtRep3.getText().isEmpty())
                            {
                               if(quizzScreenQuestionCreation.cbxQ3.isSelected() == true)
                                {
                                    state = 1;
                                }
                                else
                                {
                                    state = 0;
                                }
                                rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                        + roping(quizzScreenQuestionCreation.txtRep3.getText().toString())+"', "+idQuestion+", "
                                        +state+")"); 
                            }
                            //vérification d'une solution 4 et création
                            if(!quizzScreenQuestionCreation.txtRep4.getText().isEmpty())
                            {
                               if(quizzScreenQuestionCreation.cbxQ4.isSelected() == true)
                                {
                                    state = 1;
                                }
                                else
                                {
                                    state = 0;
                                }
                                rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                        + roping(quizzScreenQuestionCreation.txtRep4.getText().toString())+"', "+idQuestion+", "
                                        +state+")"); 
                            } 
                            quizzScreenQuestionCreation.dispose();
                            numQuestion++;
                            quizzScreenQuestionCreation = new QuizzScreenQuestionCreation();
                      }
                      catch (SQLException ex)
                      {
                            Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                      } 
                  }
                  else
                  {
                      try
                      {
                            //création de la variable de connexion
                            final java.sql.Statement statement = DBConnect.Connect();
                            ResultSet rs = statement.executeQuery("INSERT INTO QUESTION VALUES (inc_ques_seq.NEXTVAL, '" + roping(quizzScreenQuestionCreation.txtQuestion.getText().toString()+"', '"+quizzScreenQuestionCreation.imageQuestion.getText().toString())+"')");
                            rs = statement.executeQuery("select max(idquestion) from question");
                            rs.next();
                            int idQuestion = rs.getInt(1);
                            rs = statement.executeQuery("INSERT INTO composer values ("+ quiz.getId()+" ,"+idQuestion+")");
                            
                            int state;
                            //création de la solution 1
                            if(quizzScreenQuestionCreation.cbxQ1.isSelected() == true)
                            {
                                state = 1;
                            }
                            else
                            {
                                state = 0;
                            }
                            rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                    + roping(quizzScreenQuestionCreation.txtRep1.getText().toString())+"', "+idQuestion+", "
                                    +state+")");
                            //création de la solution 2
                            if(quizzScreenQuestionCreation.cbxQ2.isSelected() == true)
                            {
                                state = 1;
                            }
                            else
                            {
                                state = 0;
                            }
                            rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                    + roping(quizzScreenQuestionCreation.txtRep2.getText().toString())+"', "+idQuestion+", "
                                    +state+")");
                            //vérification d'une solution 3 et création
                            if(!quizzScreenQuestionCreation.txtRep3.getText().isEmpty())
                            {
                               if(quizzScreenQuestionCreation.cbxQ3.isSelected() == true)
                                {
                                    state = 1;
                                }
                                else
                                {
                                    state = 0;
                                }
                                rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                        + roping(quizzScreenQuestionCreation.txtRep3.getText().toString())+"', "+idQuestion+", "
                                        +state+")"); 
                            }
                            //vérification d'une solution 4 et création
                            if(!quizzScreenQuestionCreation.txtRep4.getText().isEmpty())
                            {
                               if(quizzScreenQuestionCreation.cbxQ4.isSelected() == true)
                                {
                                    state = 1;
                                }
                                else
                                {
                                    state = 0;
                                }
                                rs = statement.executeQuery("INSERT INTO SOLUTION values (inc_sol_seq.NEXTVAL, '"
                                        + roping(quizzScreenQuestionCreation.txtRep4.getText().toString())+"', "+idQuestion+", "
                                        +state+")"); 
                            }
                      }
                      catch (SQLException ex)
                      {
                            Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                      } 
                      quizzScreenQuestionCreation.dispose();
                      numQuestion++;
                      quizzScreenQuestionCreation = new QuizzScreenQuestionCreation();
                  }                  
              }
              else
              {
                  JOptionPane.showMessageDialog(quizzScreenCreation, "Veuillez sélectionner au moin une réponse valide pour votre question.");
              }
           }
           else
           {
               JOptionPane.showMessageDialog(quizzScreenCreation, "Il faut créer une question avec deux réponse au minimum pour qu'elle soit valide");
           }           
       }
       else if("Finir Quizz".equals(this.getText())){
           int reponse = JOptionPane.showConfirmDialog(this,
                "Avez-vous terminé votre quizz ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                quizzScreenQuestionCreation.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		if(reponse == JOptionPane.YES_OPTION ){
			adminScreenHome.setVisible(true);
                        quizzScreenQuestionCreation.dispose();
		}

       }

       
    }
    
    public String roping(String str)
    {
        String quote = "'";
        char[] Char;
        String modif = str;
        Char = str.toCharArray();
        int inc = 0;
        for(int i=0 ; i < str.length(); i++)
                {
                    if(Char[i] == quote.charAt(0))
                    {
                        modif = setQuote(modif, quote, i+inc);
                        inc++;
                    }
                }
        return modif;        
    }    
    
    public String setQuote(String str, String lettre, int index)
    {
        StringBuilder bMot = new StringBuilder(str);
        bMot.setLength(str.length());
        bMot.insert(index, lettre.charAt(0));
        str = bMot.toString();
        return str;
    }
}
