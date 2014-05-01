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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author Arc
 */
public class PlayerScreenHome extends JFrame
{
    public PlayerBtn btnDeco = new PlayerBtn("Déconnexion");
    public JLabel lbl2 = new JLabel("Nom : ");
    public JTextField txtNameQuizz = new JTextField();
    public JLabel lbl3 = new JLabel("Theme : ");
    public JComboBox cbxTheme = new JComboBox();
    public JRadioButton radioEasy = new JRadioButton(" Facile ", true);
    public JRadioButton radioNormal = new JRadioButton(" Normal ", true);
    public JRadioButton radioHard = new JRadioButton(" Difficle ", true);
    public JLabel lbl4 = new JLabel("Nom du Quizz");
    public JLabel lbl5 = new JLabel("Thème");
    public JLabel lbl6 = new JLabel("Date Création");
    public JLabel lbl8 = new JLabel("[listeQuizz]");
    public JLabel lbl9 = new JLabel("Difficulté");
    String[] head = {"Nom", "Thème", "Difficulté", "Date Création"};
    Object[][] data = new Object[100][4];
    public PlayerBtn btnStatPlayer = new PlayerBtn("Statistiques");
    public PlayerBtn btnRankPlayer = new PlayerBtn("Classement");
    public PlayerBtn btnPlayPlayer = new PlayerBtn("Jouer");
    
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
    public JPanel JPlbl8 = new JPanel();
    public JPanel JPlbl9 = new JPanel();
    public JPanel bottomBtnStat = new JPanel();
    public JPanel bottomBtnClass = new JPanel();
    public JPanel bottomBtnPlay = new JPanel();
    public JPanel background = new JPanel();
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    @SuppressWarnings("empty-statement")
    PlayerScreenHome() throws SQLException
    {   
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\HomeBG.png"))));

        
        topCenterC.add(new JLabel(" "));
        topCenterC.add(new JLabel(" "));
        topCenterC.setOpaque(false);
        topCenterC.setLayout(new BoxLayout(topCenterC, BoxLayout.Y_AXIS));
        topCenter.add(topCenterC);
        topCenter.setOpaque(false);
        topEastC.add(btnDeco);
        topEastC.setOpaque(false);
        topEast.add(topEastC);
        topEast.setOpaque(false);
        topEastC.setLayout(new BoxLayout(topEastC, BoxLayout.Y_AXIS));
       
        topSouth.setLayout(new BoxLayout(topSouth, BoxLayout.Y_AXIS));
        topSouth.setOpaque(false);
        
        topWest.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topEast.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topWest.setOpaque(false);
        
        
        top.setLayout(new BorderLayout());        
        top.add(BorderLayout.CENTER, topCenter);
        top.add(BorderLayout.SOUTH, topSouth);
        top.add(BorderLayout.WEST, topWest);
        top.add(BorderLayout.EAST, topEast);
        top.setOpaque(false);
        
        btnDeco.addActionListener(btnDeco);
        
        //CENTER
        txtNameQuizz.setPreferredSize(new Dimension( 150, 25));
        cbxTheme.setPreferredSize(new Dimension( 120, 25));
        centerTopName.add(lbl2);
        centerTopName.add(txtNameQuizz);
        centerTopName.setOpaque(false);
        centerTopTheme.add(lbl3);
        centerTopTheme.add(cbxTheme);
        centerTopTheme.setOpaque(false);
        centerTopCheck.add(radioEasy);
        centerTopCheck.add(radioNormal);
        centerTopCheck.add(radioHard);
        radioEasy.setOpaque(false);
        radioNormal.setOpaque(false);
        radioHard.setOpaque(false);
        centerTopCheck.setOpaque(false);
        centerTop.add(centerTopName);
        centerTop.add(centerTopTheme);
        centerTop.add(centerTopCheck);
        centerTop.setOpaque(false);
        
        JPlbl4.add(lbl4);
        JPlbl5.add(lbl5);
        JPlbl6.add(lbl6);
        JPlbl9.add(lbl9);
        JPlbl4.setPreferredSize(new Dimension( 250, 25));
        JPlbl5.setPreferredSize(new Dimension( 125, 25));
        JPlbl6.setPreferredSize(new Dimension( 125, 25));
        JPlbl9.setPreferredSize(new Dimension( 125, 25));
        JPlbl4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPlbl9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerBottom.add(JPlbl4);
        centerBottom.add(JPlbl5);
        centerBottom.add(JPlbl9);
        centerBottom.add(JPlbl6);
        centerBottom.setOpaque(false);
        
        JPlbl8.setPreferredSize(new Dimension( 670, 180));
        JPlbl8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        final java.sql.Statement statement = DBConnect.Connect();
        ResultSet rs = statement.executeQuery("SELECT Q.nomQuiz, T.lblTheme, D.lblDifficulte, Q.dateCreaQuiz FROM QUIZ Q, THEME T, DIFFICULTE D WHERE Q.idDifficulte = D.idDifficulte AND Q.idTheme = T.idTheme");
        rs.next();
        while(rs.next() == true){
            String nomQuiz = rs.getString("nomQuiz");
            String lblDifficulte = rs.getString("lblDifficulte");
            String lblTheme = rs.getString("lblTheme");
            String dateQuiz = rs.getDate("dateCreaQuiz").toString();
            int i=0;
            data[i][0]=nomQuiz;
            data[i][1]=lblTheme;
            data[i][2]=lblDifficulte;
            data[i][3]=dateQuiz;
            i++;
            rs.next();    
        }
        
           

        
        
        JTable tableau = new JTable (data, head);
        tableau.setPreferredSize(new Dimension( 665, 170));
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableau.getColumnModel().getColumn(0).setPreferredWidth(250);
        tableau.getColumnModel().getColumn(1).setPreferredWidth(125);
        tableau.getColumnModel().getColumn(2).setPreferredWidth(125);
        tableau.getColumnModel().getColumn(3).setPreferredWidth(125);
        tableau.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(tableau);
        scrollPane.setPreferredSize(new Dimension( 670, 500));
        JPlbl8.add(tableau);
        centerUnderBottom.add(JPlbl8);
        centerUnderBottom.setOpaque(false);

        center.add(centerTop);
        center.add(centerBottom);
        center.add(centerUnderBottom);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);
        
        
        //BOTTOM
        btnStatPlayer.setPreferredSize(new Dimension( 120, 50));
        btnStatPlayer.addActionListener(btnStatPlayer);
        btnRankPlayer.setPreferredSize(new Dimension( 120, 50));
        btnRankPlayer.addActionListener(btnRankPlayer);
        btnPlayPlayer.setPreferredSize(new Dimension( 120, 50));
        btnPlayPlayer.addActionListener(btnPlayPlayer);
        btnDeco.addActionListener(btnDeco);
        
        bottomBtnStat.add(btnStatPlayer);
        bottomBtnStat.setOpaque(false);
        bottomBtnClass.add(btnRankPlayer);
        bottomBtnClass.setOpaque(false);
        bottomBtnPlay.add(btnPlayPlayer);
        bottomBtnPlay.setOpaque(false);
        
        bottom.add(bottomBtnStat);
        bottom.add(bottomBtnClass);
        bottom.add(bottomBtnPlay);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);
        
        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        
        
        this.setTitle("QWIZZ : Accueil");
        setLayout(new BorderLayout());
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
