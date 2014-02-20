/*
 * To change this template, choose Tools | Templates
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
import static quizz.QUIZZ.connectionAddUser;
import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.connectionScreen;

/**
 *
 * @author Mama
 */
public class ConnectionBtn extends JButton implements ActionListener {
    
    boolean creation = true;
    ConnectionBtn(String str) {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btnConnection".equals(this.getName())) {
            playerScreenHome.setVisible(true);
            connectionScreen.setVisible(false);
        } else if ("btnDeco".equals(this.getName())) {
            connectionScreen.setVisible(true);
            playerScreenHome.setVisible(false);
        } else if ("Créer".equals(this.getText())) {
            try
            {
                final java.sql.Statement statement = DBConnect.Connect();
                ResultSet rs = statement.executeQuery("SELECT idPersonne, loginPersonne from PERSONNE  where PERSONNE.idPersonne = JOUEUR.idJoueur");
                while(rs.next() == true){
                    if (rs.getCharacterStream("loginPersonne").toString().equals(connectionAddUser.txtUser.getText()))
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
    }

}
