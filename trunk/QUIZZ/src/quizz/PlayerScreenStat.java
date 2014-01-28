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
import javax.swing.Box;
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
    public JLabel lbl1 = new JLabel("Statistiques [User]");
    public JPanel top = new JPanel();
    public JPanel bottom = new JPanel();
    public JPanel center = new JPanel();
    public JPanel right = new JPanel();
    public JPanel left = new JPanel();
    
    public JPanel topRight = new JPanel();
    public JPanel bottomRight = new JPanel();
    public JPanel underBottom = new JPanel();
  
    public PlayerBtnReturnStat btnRetour = new PlayerBtnReturnStat("Retour");
    public JButton btnDeconnexion = new JButton("Deconnexion");
    String[] entetes = {"       ","Facile","Moyen","Difficile","Total"};
    Object [][] donnees ={
        {"NbQuizz","","","",""},
        {"Temps","","","",""},
        {"Score","","","",""}
    };
    
    PlayerScreenStat()
    {
        
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
          
        top.setLayout (new BorderLayout(5,5));
        top.add(BorderLayout.EAST,btnDeconnexion);
        top.add(BorderLayout.CENTER,lbl1);
        
        underBottom.add(new JLabel(""));
        bottom.setLayout (new BorderLayout());
        bottom.add(BorderLayout.EAST,btnRetour);
        btnRetour.addActionListener(btnRetour);
        
        /**Création de la table*/
        JTable tableau = new JTable (donnees,entetes);
        JScrollPane scrollPane = new JScrollPane(tableau);
        center.add(scrollPane);

        /**Specifications de la page*/
        this.setResizable(false);
        this.setSize(700,400);
        this.setTitle("QUIZZ : Statistiques du joueur");
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        this.getContentPane().add(BorderLayout.EAST, right);
        this.getContentPane().add(BorderLayout.WEST, left);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
