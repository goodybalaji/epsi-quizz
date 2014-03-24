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
    
    boolean creation = false;
    ConnectionBtn(String str) {
        super(str);
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("btnConnection".equals(this.getName()))
        {
            char[] pwd = connectionScreen.txtPwd.getPassword();
            try {
                final java.sql.Statement statement = DBConnect.Connect();
                ResultSet rs = statement.executeQuery("SELECT idPersonne, loginPersonne, mdpPersonne from PERSONNNE, JOUEUR where PERSONNE.idPersonne = JOUEUR.idJoueur " 
                                                    + "AND PERSONNE.loginPersonne =" + connectionScreen.txtUser.toString()
                                                    + "AND PERSONNE.mdpPersonne = " + String.valueOf(pwd));
                if (rs.next() == true)
                {
                    
                }
                else
                {
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectionScreen.setVisible(false);

            playerScreenHome.setVisible(true);

        }
        else if ("btnDeco".equals(this.getName()))
        {
            connectionScreen.setVisible(true);
            playerScreenHome.setVisible(false);

        }
        else if ("Créer".equals(this.getText()))
        {   
            char[] pwd = connectionScreenAddUser.txtPwd.getPassword();
            char[] pwd2 = connectionScreenAddUser.txtPwd2.getPassword();
            if (String.valueOf(pwd).equals(String.valueOf(pwd2)))
            {
                try
                {
                    final java.sql.Statement statement = DBConnect.Connect();
                    ResultSet rs = statement.executeQuery("SELECT idPersonne, loginPersonne from PERSONNE, JOUEUR where PERSONNE.idPersonne = JOUEUR.idJoueur");
                    while(rs.next() == true){
                        if (rs.getCharacterStream("loginPersonne").toString().equals(connectionScreenAddUser.txtUser.getText()))
                        {
                            creation = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(connectionScreenAddUser, "Login utilisé, veuilliez en choisir un autre.");
                            connectionScreenAddUser.txtUser.setText("");
                            connectionScreenAddUser.txtPwd.setText("");
                            connectionScreenAddUser.txtPwd2.setText("");
                        }
                    }
                    if (creation == true)
                    {   
                        creation = false;
                        String queryCreaPers = "Insert Into PERSONNE (IDPERSONNE, LOGINPERSONNE, MDPPERSONNE) "
                                                   + "VALUES (inc_personne_seq.NEXTVAL, '" + connectionScreenAddUser.txtUser.getText() + "', '" 
                                                   + String.valueOf(pwd) + "')";                        
                        rs = statement.executeQuery(queryCreaPers);
                        
                        queryCreaPers = "SELECT * from PERSONNE WHERE LOGINPERSONNE = '" + connectionScreenAddUser.txtUser.getText() + "'";
                        System.out.println(queryCreaPers);
                        
                        ResultSet rsSelectId = statement.executeQuery(queryCreaPers);
                        rsSelectId.next();
                        
                       
                        int idpersonne = rsSelectId.getInt("IDPERSONNE");
                        
                        String queryCreaJou = "insert into nb_quiz_joueur (idnbquiz, NBFACILE, NBMOYEN, NBDIFFICILE) Values (inc_nbquiz_seq.NEXTVAL, 0, 0, 0)";
                        rs = statement.executeQuery(queryCreaJou);  
                        queryCreaJou = "SELECT MAX(IDNBQUIZ) from NB_QUIZ_JOUEUR";
                        rsSelectId = statement.executeQuery(queryCreaJou);
                        rsSelectId.next();
                        int idnbquizz = rsSelectId.getInt(1);
                        
                        queryCreaJou = "Insert Into JOUEUR (IDJOUEUR, IDNBQUIZ) Values (" + idpersonne + ","+ idnbquizz +")";
                        System.out.println(queryCreaJou);
                        rs = statement.executeQuery(queryCreaJou);    
                        
                        creation = true;
                        
                        if (creation == true)
                        {
                            JOptionPane.showMessageDialog(connectionScreenAddUser, "Votre utilisateur à bien été créer, vous pouvez maintenant vous connecter.");
                            connectionScreenAddUser.dispose();
                            connectionScreen.setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(connectionScreenAddUser, "Une erreur est survenue l'or de la création de votre compte. Celui-ci n'a pas été crée");
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
           }
           else
            {
                 JOptionPane.showMessageDialog(connectionScreenAddUser, "La confirmation de votre mot de passe n'est pas correct. Veuilliez les ressaisir");
                 connectionScreenAddUser.txtPwd.setText("");
                 connectionScreenAddUser.txtPwd2.setText("");
           }
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
