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
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
/**
 *
 * @author Arc
 */
public class PlayerScreenHome extends JFrame
{
    public JLabel lbl1 = new JLabel("Accueil [PlayerName]");
    public JButton btnDeco = new JButton("Deconnexion");
    public JLabel lbl2 = new JLabel("Nom : ");
    public JTextField txtNameQuizz = new JTextField();
    public JLabel lbl3 = new JLabel("Theme : ");
    public JComboBox cbxTheme = new JComboBox();
    public JRadioButton radioEasy = new JRadioButton(" Facile ", true);
    public JRadioButton radioNormal = new JRadioButton(" Normal ", true);
    public JRadioButton radioHard = new JRadioButton(" Difficle ", true);
    public JLabel lbl4 = new JLabel("Nom du Quizz");
    public JLabel lbl5 = new JLabel("Theme");
    public JLabel lbl6 = new JLabel("Date Creation");
    public JLabel lbl7 = new JLabel("Date MaJ");
    public JLabel lbl8 = new JLabel("[listeQuizz]");
    public JLabel lbl9 = new JLabel("Difficulté");
    String[] head = {"Nom", "Theme", "Difficulté", "Date Création", "Date Maj"};
    Object[][] data = {};
    public JTable quizzTable = new JTable(data, head);
    public PlayerBtnStatQuizz statPlayer = new PlayerBtnStatQuizz("Statistiques");
    public PlayerBtnRankQuizz rankPlayer = new PlayerBtnRankQuizz("Classement");
    public JButton playPlayer = new JButton("Jouer");
    
    public JPanel top = new JPanel();
    public JPanel center = new JPanel();
    
    public JPanel centerTop = new JPanel();
    public JPanel centerBottom = new JPanel();
    public JPanel centerUnderBottom = new JPanel();
    public JPanel bottom = new JPanel();
    
    public JPanel topCenter = new JPanel();
    public JPanel topCenterC = new JPanel();
    public JPanel topEast = new JPanel();
    public JPanel topEastC = new JPanel();
    public JPanel topWest = new JPanel();
    public JPanel topWestC = new JPanel();
    public JPanel topSouth = new JPanel();
    public JPanel centerTopName = new JPanel();
    public JPanel centerTopTheme = new JPanel();
    public JPanel centerTopCheck = new JPanel();
    public JPanel JPlbl4 = new JPanel();
    public JPanel JPlbl5 = new JPanel();
    public JPanel JPlbl6 = new JPanel();
    public JPanel JPlbl7 = new JPanel();
    public JPanel JPlbl8 = new JPanel();
    public JPanel JPlbl9 = new JPanel();
    public JPanel bottomBtnStat = new JPanel();
    public JPanel bottomBtnClass = new JPanel();
    public JPanel bottomBtnPlay = new JPanel();
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    PlayerScreenHome()
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
        txtNameQuizz.setPreferredSize(new Dimension( 150, 25));
        cbxTheme.setPreferredSize(new Dimension( 120, 25));
        centerTopName.add(lbl2);
        centerTopName.add(txtNameQuizz);
        centerTopTheme.add(lbl3);
        centerTopTheme.add(cbxTheme);
        centerTopCheck.add(radioEasy);
        centerTopCheck.add(radioNormal);
        centerTopCheck.add(radioHard);
        centerTop.add(centerTopName);
        centerTop.add(centerTopTheme);
        centerTop.add(centerTopCheck);
        
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
        centerBottom.add(JPlbl4);
        centerBottom.add(JPlbl5);
        centerBottom.add(JPlbl9);
        centerBottom.add(JPlbl6);
        centerBottom.add(JPlbl7);
        
        JPlbl8.setPreferredSize(new Dimension( 670, 180));
        JPlbl8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerUnderBottom.add(JPlbl8);

        center.add(centerTop);
        center.add(centerBottom);
        center.add(centerUnderBottom);
        center.add(new JSeparator(SwingConstants.HORIZONTAL));
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        
        //BOTTOM
        statPlayer.setPreferredSize(new Dimension( 120, 50));
        statPlayer.addActionListener(statPlayer);
        rankPlayer.setPreferredSize(new Dimension( 120, 50));
        rankPlayer.addActionListener(rankPlayer);
        playPlayer.setPreferredSize(new Dimension( 120, 50));
        
        bottomBtnStat.add(statPlayer);
        bottomBtnClass.add(rankPlayer);
        bottomBtnPlay.add(playPlayer);
        
        bottom.add(bottomBtnStat);
        bottom.add(bottomBtnClass);
        bottom.add(bottomBtnPlay);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        this.setTitle("QUIZZ : Création du QUIZZ");
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
