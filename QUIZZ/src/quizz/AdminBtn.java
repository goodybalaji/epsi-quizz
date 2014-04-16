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

import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.adminScreenHome;
import static quizz.QUIZZ.adminScreenAddAdmin;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
import static quizz.QUIZZ.admin;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.connectionScreenAddUser;

/**
 *
 * @author Mama
 */
public class AdminBtn extends JButton implements ActionListener
{
    boolean creation = true;
    AdminBtn(String str)
    {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Deconnexion".equals(this.getText()))
        {
            admin = null;
            adminScreenHome.setVisible(false);
            connectionScreen.setVisible(true);            
        }
        else if("Nouveau".equals(this.getText()))
        {
            quizzScreenCreation.setVisible(true);
            adminScreenHome.setVisible(false);
        }
        else if ("Ajouter Admin".equals(this.getText()))
        {
            adminScreenAddAdmin.setVisible(true);
        }
        else if ("Retour".equals(this.getText()))
        {
            adminScreenAddAdmin.setVisible(false);
        }
        else if ("Créer".equals(this.getText()))
        {   
            //création des variable de verification du mdp
            char[] pwd = adminScreenAddAdmin.txtPwd.getPassword();
            char[] pwd2 = adminScreenAddAdmin.txtPwd2.getPassword();
            //vérification du mdp
            if (String.valueOf(pwd).equals(String.valueOf(pwd2)))
            {
                try
                {
                    //création de la variable de connexion
                    final java.sql.Statement statement = DBConnect.Connect();
                    //vérification de la disponbilité du login du nouvel utilisateur
                    ResultSet rs = statement.executeQuery("SELECT idPersonne, loginPersonne from PERSONNE, ADMIN where PERSONNE.idPersonne = ADMIN.idAdmin");
                    while(rs.next() == true){
                        //si disponible
                        if (rs.getCharacterStream("loginPersonne").toString().equals(adminScreenAddAdmin.txtUser.getText()))
                        {
                            creation = false;
                            JOptionPane.showMessageDialog(adminScreenAddAdmin, "Login utilisé, veuilliez en choisir un autre.");
                            adminScreenAddAdmin.txtUser.setText("");
                            adminScreenAddAdmin.txtPwd.setText("");
                            adminScreenAddAdmin.txtPwd2.setText("");
                        }          
                    }
                    //création du nouvel utilisateur
                    if (creation == true)
                    {   
                        creation = false;
                        
                        //création de l'utilisateur dans la table PERSONNE
                        String queryCreaPers = "Insert Into PERSONNE (IDPERSONNE, LOGINPERSONNE, MDPPERSONNE) "
                                                   + "VALUES (inc_personne_seq.NEXTVAL, '" + adminScreenAddAdmin.txtUser.getText() + "', '" 
                                                   + String.valueOf(pwd) + "')";                        
                        rs = statement.executeQuery(queryCreaPers);
                        
                        //Recuperation de l'id de PERSONNE
                        queryCreaPers = "SELECT * from PERSONNE WHERE LOGINPERSONNE = '" + adminScreenAddAdmin.txtUser.getText() + "'";
                        System.out.println(queryCreaPers);                        
                        ResultSet rsSelectId = statement.executeQuery(queryCreaPers);
                        rsSelectId.next();
                        int idpersonne = rsSelectId.getInt("IDPERSONNE");
                        
                        
                        
                        //création du JOUEUR avec l'id PERSONNE et l'id NbQuizJoueur
                        String queryCreaJou = "Insert Into ADMIN (IDADMIN, NBQUIZADMIN) Values (" + idpersonne + ", 0)";
                        System.out.println(queryCreaJou);
                        rs = statement.executeQuery(queryCreaJou);    
                        
                        creation = true;
                        
                        if (creation == true)
                        {
                            JOptionPane.showMessageDialog(adminScreenAddAdmin, "Votre administrateur a bien été crée, vous pouvez maintenant vous connecter.");
                            adminScreenAddAdmin.dispose();
                            adminScreenHome.setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(adminScreenAddAdmin, "Une erreur est survenue l'or de la création de ce compte. Celui-ci n'a pas été crée");
                            adminScreenAddAdmin.txtUser.setText("");
                            adminScreenAddAdmin.txtPwd.setText("");
                            adminScreenAddAdmin.txtPwd2.setText("");
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
                 JOptionPane.showMessageDialog(adminScreenAddAdmin, "La confirmation de votre mot de passe n'est pas correct. Veuilliez les ressaisir");
                 adminScreenAddAdmin.txtPwd.setText("");
                 adminScreenAddAdmin.txtPwd2.setText("");
           }
       }
    }
    
}
