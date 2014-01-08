/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Pierre 
 */
public class QuizzStatJoueurScreen extends JFrame
{
    /**public BtnQuitter = new BtnQuitter("Quitter");*/
    public JLabel lbl1 = new JLabel("Statistiques");
    public JPanel top = new JPanel();
    public JPanel bottom = new JPanel();
    public JPanel center = new JPanel();
    
    
  
    public LeaveToAdminBtn btnQuitter = new LeaveToAdminBtn("Quitter");
    public LeaveToAdminBtn btnDeconnexion = new LeaveToAdminBtn("Deconnexion");
    String[] entetes = {"       ","Facile","Moyen","Difficile","Total"};
    Object [][] donnees ={
        {"NbQuizz","","","",""},
        {"Temps","","","",""},
        {"Score","","","",""}
    };
    
    QuizzStatJoueurScreen()
    {
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
        top.add(lbl1);
        top.add(btnDeconnexion);
        bottom.add(btnQuitter);
       
        
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
