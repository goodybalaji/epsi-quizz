/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author Pierre 
 */
public class PlayerScreenStat extends JFrame
{
    String utilisateur;
    public JLabel lbl1 = new JLabel(" ");
    public JPanel top = new JPanel();
    public JPanel topCenter = new JPanel();
    public JPanel topCenterC = new JPanel();
    public JPanel topEast = new JPanel();
    public JPanel topEastC = new JPanel();
    public JPanel topWest = new JPanel();
    public JPanel topWestC = new JPanel();
    public JPanel bottom = new JPanel();
    public JPanel bottomEast = new JPanel();
    public JPanel bottomEastC = new JPanel();
    public JPanel center = new JPanel();
    public JPanel background = new JPanel();
    
    public JPanel bottomRight = new JPanel();
    public JPanel underBottom = new JPanel();
  
    public PlayerBtn BackBtn = new PlayerBtn("Retour");
    public JButton btnDeco = new JButton("Déconnexion");
    String[] entetes = {"       ","Facile","Moyen","Difficile","Total"};
    Object [][] donnees ={
        {"NbQuizz","","","",""},
        {"Temps","","","",""},
        {"Score","","","",""}
    };
    
    PlayerScreenStat()
    {
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\StatsBG.png"))));
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
          
        topCenterC.add(new JLabel(" "));
        topCenterC.add(new JLabel(" "));
        topCenterC.setOpaque(false);
        topCenterC.setLayout(new BoxLayout(topCenterC, BoxLayout.Y_AXIS));
        topCenter.setOpaque(false);
        top.setLayout (new BorderLayout(5,5));
        top.add(BorderLayout.EAST,btnDeco);
        topEastC.add(btnDeco);
        topEastC.setOpaque(false);
        topEast.add(topEastC);
        topEast.setOpaque(false);
        topEastC.setLayout(new BoxLayout(topEastC, BoxLayout.Y_AXIS));
        
        topWest.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topWest.setOpaque(false);
        topEast.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        
        top.setLayout(new BorderLayout());        
        top.add(BorderLayout.CENTER, topCenter);
        top.add(BorderLayout.EAST, topEast);
        top.add(BorderLayout.WEST, topWest);
        top.setPreferredSize(new Dimension( 670, 71));
        top.setOpaque(false);
        
        
        /**Création de la table*/
        JTable tableau = new JTable (donnees,entetes);
        JScrollPane scrollPane = new JScrollPane(tableau);
        scrollPane.setPreferredSize(new Dimension( 670, 71));
        center.add(scrollPane);
        center.setOpaque(false);
        
        underBottom.add(new JLabel(""));
        underBottom.setOpaque(false);
        bottom.setLayout (new BorderLayout());
        bottomEastC.add(BackBtn);
        bottomEastC.setOpaque(false);
        bottomEast.add(bottomEastC);
        bottomEast.setOpaque(false);
        bottom.add(BorderLayout.EAST, bottomEast);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);
        BackBtn.addActionListener(BackBtn);
        
        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        

        /**Specifications de la page*/
        this.setResizable(false);
        setLayout(new BorderLayout());
        this.setSize(700,400);
        this.setTitle("QWIZZ : Statistiques du joueur");
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
