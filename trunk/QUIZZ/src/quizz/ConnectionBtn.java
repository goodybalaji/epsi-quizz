/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.ButtonModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.connectionScreenAddUser;
import static quizz.QUIZZ.adminScreenHome;



/**
 *
 * @author Mama
 */
public class ConnectionBtn extends JButton implements ActionListener {
    
    boolean creation = true;
    ConnectionBtn(String str) {
        super(str);
    }

    public void actionPerformed(ActionEvent e)
    {
    
       if ("Connexion".equals(this.getText()))
        {

        

            connectionScreen.setVisible(false);

            playerScreenHome.setVisible(true);
        }
        else if ("btnDeco".equals(this.getName())) {
            connectionScreen.setVisible(true);
            playerScreenHome.setVisible(false);

        } else if ("Créer".equals(this.getText())) {
            try
            {
                final java.sql.Statement statement = DBConnect.Connect();
                ResultSet rs = statement.executeQuery("SELECT idPersonne, loginPersonne from PERSONNE  where PERSONNE.idPersonne = JOUEUR.idJoueur");
                while(rs.next() == true){
                    if (rs.getCharacterStream("loginPersonne").toString().equals(connectionScreenAddUser.txtUser.getText()))
                    {
                        creation = false;
                    }
                }
                if (creation == true)
                {
                    // TO DO !!!!!!!!!!!!
                    //ResultSet rsCrea = Statement.executeQuery("Insert Into PERSONNE ( ")
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if ("Retour".equals(this.getText())) {

        }
       else if("Créer un nouveau compte".equals(this.getText()))
       {
           connectionScreenAddUser.setVisible(true);
           connectionScreen.setVisible(false);
       }
       else if("Retour".equals(this.getText()))
       {
           connectionScreenAddUser.setVisible(false);
           connectionScreen.setVisible(true);
       }
  
    }

}
