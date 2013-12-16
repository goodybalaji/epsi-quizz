/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.TextField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

/**
 *
 * @author Mathieu 'Triboulet' RONDOT
 */
public class ConnexionScreen extends JFrame
{
    public JLabel lbl1 = new JLabel("bienvenue");
    public JLabel lbl2 = new JLabel("nom d'utilisateur");
    public JLabel lbl3 = new JLabel("mot de passe");
    public JLabel lbl4 = new JLabel("type d'utilisateur");
    public TextField txtUser = new TextField();
    public TextField txtPwd = new TextField();
    public JRadioButton btnUser = new JRadioButton(" Joueur ");
    public JRadioButton btnAdmin = new JRadioButton("Administrateur");
    public JSeparator separator = new JSeparator();
    public Connexion btnCnx = new Connexion("se connecter");
    
    ConnexionScreen()
    {
        
    }
    
    
}


