/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Arc
 */
public class AccueilAdminScreen extends JFrame
{
    public JLabel lbl1 = new JLabel("Accueil [AdminName]");
    public JButton btnDeco = new JButton("Deconnexion");
    public JLabel lbl4 = new JLabel("Nom du Quizz");
    public JLabel lbl5 = new JLabel("Theme");
    public JLabel lbl6 = new JLabel("Date Creation");
    public JLabel lbl7 = new JLabel("Date MaJ");
    public JLabel lbl8 = new JLabel("[listeQuizz]");
    public JLabel lbl9 = new JLabel("Difficulté");
    String[] head = {"Nom", "Theme", "Difficulté", "Date Création", "Date Maj"};
    Object[][] data = {};
    public JTable quizzTable = new JTable(data, head);
    public JButton classAdminBtn = new JButton("Classement");
    public JButton modifAdminBtn = new JButton("Modifier");
    public JButton delAdminBtn = new JButton("Supprimer");
    public JButton newAdminBtn = new JButton("Nouveau");
    
    public JPanel top = new JPanel();
    public JPanel topEast = new JPanel();
    public JPanel topEastC = new JPanel();
    public JPanel topCenter = new JPanel();
    public JPanel topCenterC = new JPanel();
    public JPanel topSouth = new JPanel();
    public JPanel topWest = new JPanel();
    public JPanel center = new JPanel();
    public JPanel centerTop = new JPanel();
    public JPanel centerBottom = new JPanel();
    public JPanel bottom = new JPanel();
    
    public JPanel JPlbl1 = new JPanel();
    public JPanel JPlbl4 = new JPanel();
    public JPanel JPlbl5 = new JPanel();
    public JPanel JPlbl6 = new JPanel();
    public JPanel JPlbl7 = new JPanel();
    public JPanel JPlbl8 = new JPanel();
    public JPanel JPlbl9 = new JPanel();
    public JPanel bottomClassBtn = new JPanel();
    public JPanel bottomModifBtn = new JPanel();
    public JPanel bottomDelBtn = new JPanel();
    public JPanel bottomNewBtn = new JPanel();
    
    AccueilAdminScreen()
    {
        //TOP
        lbl1.setFont(lbl1.getFont().deriveFont(18.0f));
        
        topCenterC.add(lbl1);
        topCenterC.setLayout(new BoxLayout(topCenterC, BoxLayout.Y_AXIS));
        topCenter.add(topCenterC);
        topEastC.add(btnDeco);
        topEast.add(topEastC);
        topEastC.setLayout(new BoxLayout(topEastC, BoxLayout.Y_AXIS));
       
        topSouth.add(new JSeparator(SwingConstants.HORIZONTAL));
        topSouth.setLayout(new BoxLayout(topSouth, BoxLayout.Y_AXIS));
        
        topWest.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topEast.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        
        
        top.setLayout(new BorderLayout());        
        top.add(BorderLayout.CENTER, topCenter);
        top.add(BorderLayout.SOUTH, topSouth);
        top.add(BorderLayout.WEST, topWest);
        top.add(BorderLayout.EAST, topEast);
        
        //CENTER       
        JPlbl4.add(lbl4);
        JPlbl5.add(lbl5);
        JPlbl6.add(lbl6);
        JPlbl7.add(lbl7);
        JPlbl9.add(lbl9);
        JPlbl4.setPreferredSize(new Dimension( 250, 25));
        JPlbl5.setPreferredSize(new Dimension( 100, 25));
        JPlbl6.setPreferredSize(new Dimension( 100, 25));
        JPlbl7.setPreferredSize(new Dimension( 100, 25));
        JPlbl8.setPreferredSize(new Dimension( 100, 25));
        JPlbl9.setPreferredSize(new Dimension( 100, 25));
        JPlbl4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerTop.add(JPlbl4);
        centerTop.add(JPlbl5);
        centerTop.add(JPlbl9);
        centerTop.add(JPlbl6);
        centerTop.add(JPlbl7);
        
        JPlbl8.setPreferredSize(new Dimension( 670, 230));
        JPlbl8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerBottom.add(JPlbl8);

        center.add(centerTop);
        center.add(centerBottom);
        center.add(new JSeparator(SwingConstants.HORIZONTAL));
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        //BOTTOM
        classAdminBtn.setPreferredSize(new Dimension( 120, 50));
        modifAdminBtn.setPreferredSize(new Dimension( 120, 50));
        delAdminBtn.setPreferredSize(new Dimension( 120, 50));
        newAdminBtn.setPreferredSize(new Dimension( 120, 50));
        
        bottomClassBtn.add(classAdminBtn);
        bottomModifBtn.add(modifAdminBtn);
        bottomDelBtn.add(delAdminBtn);
        bottomNewBtn.add(newAdminBtn);
        
        bottom.add(bottomClassBtn);
        bottom.add(bottomModifBtn);
        bottom.add(bottomDelBtn);
        bottom.add(bottomNewBtn);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        this.setTitle("QUIZZ : ACCUEIL Admin");
        this.setSize(700,400);
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
