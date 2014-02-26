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
import javax.swing.JOptionPane;



import static quizz.QUIZZ.playerScreenHome;
import static quizz.QUIZZ.connectionScreen;

import static quizz.QUIZZ.connectionScreenAddUser;



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

            connectionScreen.setVisible(false);

            playerScreenHome.setVisible(true);

        } else if ("btnDeco".equals(this.getName())) {
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
                    else
                    {
                        JOptionPane.showConfirmDialog(connectionScreenAddUser, "Login utilisé, veuilliez en choisir un autre.");
                        connectionScreenAddUser.txtUser.setText("");
                        connectionScreenAddUser.txtPwd.setText("");
                        connectionScreenAddUser.txtPwd2.setText("");
                    }
                }
                if (creation == true)
                {   
                    // TO DO !!!!!!!!!!!!
                    String query = "Insert Into PERSONNE (IDPERSONNE, LOGINPERSONNE, MDPPERSONNE) "
                                                + "VALIUES (increment_personne_seq.NEXTVAL, " + connectionScreenAddUser.txtUser.getText() +", " 
                                                + connectionScreenAddUser.txtPwd.getPassword().toString() + ");";
                    ResultSet rsCrea = statement.executeQuery(query);
                    if (rsCrea.rowInserted() == true)
                    {
                        JOptionPane.showConfirmDialog(connectionScreenAddUser, "Votre utilisateur à bien été créer, vous pouvez maintenant vous connecter.");
                        connectionScreenAddUser.dispose();
                        connectionScreen.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showConfirmDialog(connectionScreenAddUser, "Une erreur est survenue l'or de la création de votre compte. Celui-ci n'a pas été crée");
                        connectionScreenAddUser.txtUser.setText("");
                        connectionScreenAddUser.txtPwd.setText("");
                        connectionScreenAddUser.txtPwd2.setText("");
                    }
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
