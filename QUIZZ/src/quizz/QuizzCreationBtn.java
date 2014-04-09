/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenAddImage;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
//import static quizz.QUIZZ.quizzScreenQuestionCreationBis;
import static quizz.QuizzScreenCreation.txtNameQuizz;

/**
 *
 * @author Arc
 */
public class QuizzCreationBtn extends JButton implements ActionListener{
    
    public JLabel lbl,lbl1;
    public int indiceReponse;
    public JTextField txtRep;
    public JCheckBox cbx;
    
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
       else if ("Ajouter Reponse".equals(this.getText()))
        {
            /*//création d'une nouvelle ligne réponse
            lbl = new JLabel ("Réponse n°");
            lbl1 = new JLabel("");
            indiceReponse =3;
            lbl1.setText(lbl+Integer.toString(indiceReponse)+" : ");
            
            txtRep = new JTextField();
            txtRep.setPreferredSize(new Dimension( 500, 25));
            cbx = new JCheckBox();
            //insertion de la ligne réponse
            quizzScreenQuestionCreationBis.panelCenterRep4.add(lbl1);
            quizzScreenQuestionCreationBis.panelCenterRep4.add(txtRep);
            quizzScreenQuestionCreationBis.panelCenterRep4.add(cbx);
            quizzScreenQuestionCreationBis.center.add(quizzScreenQuestionCreationBis.panelCenterRep4);
            */
            //quizzScreenQuestionCreationBis.repaint();
        }
       else if ("Annuler".equals(this.getText())){
           quizzScreenAddImage.setVisible(false);
       }
       
    }
}
