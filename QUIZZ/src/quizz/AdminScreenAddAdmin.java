/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
/**
 *
 * @author Arc
 */
public class AdminScreenAddAdmin extends JFrame
{

    public JLabel lbl1 = new JLabel("Creer un nouvel Admin");
    public JLabel lbl2 = new JLabel("nom d'utilisateur : ");
    public JLabel lbl3 = new JLabel("mot de passe :       ");
    public JLabel lbl4 = new JLabel("confirmer :             ");
    public JTextField txtUser = new JTextField();
    public JPasswordField txtPwd = new JPasswordField();
    public JPasswordField txtPwd2 = new JPasswordField();
    public JButton btnCreationCompte = new JButton("Créer");
    public JButton btnReturn = new JButton("Retour");
    
    public JPanel center = new JPanel();
    public JPanel centerUser = new JPanel();
    public JPanel centerPwd = new JPanel();
    public JPanel centerPwd2 = new JPanel();
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    public JPanel bottom = new JPanel(new GridLayout(1, 3));
    public JPanel bottomConnection = new JPanel();
    public JPanel bottomReturn = new JPanel();
    
    AdminScreenAddAdmin()
    {
        /** mise en forme des éléments de la page */
        lbl1.setFont(lbl1.getFont().deriveFont(25.0f));
        txtUser.setPreferredSize(new Dimension( 200, 25));
        txtPwd.setPreferredSize(new Dimension( 200, 25));
        txtPwd2.setPreferredSize(new Dimension( 200, 25));
        
        /** création des Panel et sous panel */
        topLbl.add(lbl1);
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        centerUser.add(lbl2);
        centerPwd.add(lbl3);     
        centerPwd2.add(lbl4);
        centerUser.add(txtUser);
        centerPwd.add(txtPwd);    
        centerPwd2.add(txtPwd2); 
        center.add(centerUser);
        center.add(centerPwd);
        center.add(centerPwd2);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        

        bottomConnection.add(btnCreationCompte);
        bottomReturn.add(btnReturn);
        bottom.add(bottomReturn);
        bottom.add(bottomConnection); 
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        
        /** Spécification de la page */
        this.setTitle("Création d'un Admin");
        this.setSize(400,245);
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
