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

    public JLabel lbl1 = new JLabel(" ");
    public JLabel lbl2 = new JLabel("nom d'utilisateur : ");
    public JLabel lbl3 = new JLabel("mot de passe :       ");
    public JLabel lbl4 = new JLabel("confirmer :             ");
    public JTextField txtUser = new JTextField();
    public JPasswordField txtPwd = new JPasswordField();
    public JPasswordField txtPwd2 = new JPasswordField();
    public JButton btnCreate = new JButton("Créer");
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
    public JPanel background = new JPanel();
    
    AdminScreenAddAdmin()
    {
        
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\AddAdminBG.png"))));
        /** mise en forme des éléments de la page */
        lbl1.setFont(lbl1.getFont().deriveFont(25.0f));
        txtUser.setPreferredSize(new Dimension( 200, 25));
        txtPwd.setPreferredSize(new Dimension( 200, 25));
        txtPwd2.setPreferredSize(new Dimension( 200, 25));
        
        /** création des Panel et sous panel */
        topLbl.add(lbl1);
        topLbl.setOpaque(false);
        top.add(topLbl);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setOpaque(false);
        
        centerUser.add(lbl2);
        centerUser.setOpaque(false);
        centerPwd.add(lbl3);
        centerPwd.setOpaque(false);
        centerPwd2.add(lbl4);
        centerPwd2.setOpaque(false);
        centerUser.add(txtUser);
        centerPwd.add(txtPwd);    
        centerPwd2.add(txtPwd2); 
        center.add(centerUser);
        center.add(centerPwd);
        center.add(centerPwd2);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);
        

        bottomConnection.add(btnCreate);
        bottomConnection.setOpaque(false);
        bottomReturn.add(btnReturn);
        bottomReturn.setOpaque(false);
        bottom.add(bottomReturn);
        bottom.add(bottomConnection); 
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);
        
        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        
        
        /** Spécification de la page */
        this.setTitle("Création d'un Admin");
        setLayout(new BorderLayout());
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
