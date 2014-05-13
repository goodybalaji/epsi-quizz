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
 * @author Mathieu 'Triboulet' RONDOT
 */
public class ConnectionScreen extends JFrame
{
    
    
    /** parametre de la Frame */
    public JPanel top = new JPanel();
    public JPanel center = new JPanel();
    public JPanel centerUser = new JPanel();
    public JPanel centerPwd = new JPanel();
    public JPanel bottom = new JPanel(new GridLayout(1, 3));
    public JPanel bottomConnection = new JPanel();
    public JPanel bottomRadio = new JPanel();
    public JPanel background = new JPanel();
    public JLabel lbl2 = new JLabel("nom d'utilisateur : ");
    public JLabel lbl3 = new JLabel("mot de passe :       ");
    public JLabel lbl4 = new JLabel("type d'utilisateur :");
    public JTextField txtUser = new JTextField();
    public JPasswordField txtPwd = new JPasswordField();
    public ConnectionBtn btnConnection = new ConnectionBtn("Connexion");
    public ConnectionBtn btnCreationCompte = new ConnectionBtn("Créer un nouveau compte");
   
    ConnectionScreen()
    {
        
        /** mise en forme des éléments de la page */
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\ConnectionBG.png"))));
        txtUser.setPreferredSize(new Dimension( 200, 25));
        txtPwd.setPreferredSize(new Dimension( 200, 25));
        
       
        /** création des Panel et sous panel */
        top.add(new JLabel("   "));
        top.add(new JLabel("   "));
        top.add(new JLabel("   "));
        top.add(new JLabel("   "));
        top.add(new JLabel("   "));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        centerUser.add(lbl2);
        centerPwd.add(lbl3);        
        centerUser.add(txtUser);
        centerPwd.add(txtPwd);        
        center.add(centerUser);
        center.add(centerPwd);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        bottomConnection.add(new JLabel("   "));
        bottomConnection.add(btnCreationCompte);
        bottomConnection.add(btnConnection);
        
        
        bottom.add(bottomConnection);        
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        
        btnCreationCompte.addActionListener(btnCreationCompte);
        btnConnection.addActionListener(btnConnection);
        
        top.setOpaque(false);
        centerUser.setOpaque(false);
        centerPwd.setOpaque(false);
        center.setOpaque(false);
        bottomConnection.setOpaque(false);
        bottomRadio.setOpaque(false);
        bottom.setOpaque(false);
        
        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        
        /** Spécification de la page */
        setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.CENTER, center);
        this.setTitle("QWIZZ : Ecran de connexion");
        this.setSize(400,245);
        this.getRootPane().setDefaultButton(btnConnection);
        btnConnection.requestFocus();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
}


