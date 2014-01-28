/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Llauron
 */
public class PlayerScreenRankQuizz extends JFrame 
{
    
    public JLabel lbl1 = new JLabel("Classement");
    public JLabel lbl2 = new JLabel("N° ");
    public JLabel lbl3 = new JLabel("Pseudo Joueur ");
    public JLabel lbl4 = new JLabel("Score ");
    public JLabel lbl5 = new JLabel("Temps ");
    public JLabel lbl6 = new JLabel("Date Jeu ");
    public JPanel PlayerNumber = new JPanel();
    public JPanel PlayerName = new JPanel();
    public JPanel PlayerScore = new JPanel();
    public JPanel PlayerTime = new JPanel();
    public JPanel PlayerGameDate = new JPanel();
    public JPanel PlayersRank = new JPanel();
    
    public PlayerBtn btnRetour = new PlayerBtn("Retour");
    
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    
    public JPanel center = new JPanel();
    public JPanel panelCenterSpace = new JPanel();
    public JPanel panelCenterPlayerNumber = new JPanel();
    public JPanel panelCenterPlayerName = new JPanel();
    public JPanel panelCenterPlayerScore = new JPanel();
    public JPanel panelCenterPlayerTime = new JPanel();
    public JPanel panelCenterPlayerGameDate = new JPanel();
    public JPanel panelCenterPlayersRank = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();
    
    
 
    PlayerScreenRankQuizz()
    {
        lbl1.setFont(lbl1.getFont().deriveFont(38.0f));
        PlayerNumber.setPreferredSize(new Dimension( 50, 25));
        PlayerNumber.setBorder(BorderFactory.createRaisedBevelBorder());
        PlayerName.setPreferredSize(new Dimension( 150, 25));
        PlayerName.setBorder(BorderFactory.createRaisedBevelBorder());
        PlayerScore.setPreferredSize(new Dimension( 100, 25));
        PlayerScore.setBorder(BorderFactory.createRaisedBevelBorder());
        PlayerTime.setPreferredSize(new Dimension( 100, 25));
        PlayerTime.setBorder(BorderFactory.createRaisedBevelBorder());
        PlayerGameDate.setPreferredSize(new Dimension( 100, 25));
        PlayerGameDate.setBorder(BorderFactory.createRaisedBevelBorder());
        PlayersRank.setPreferredSize(new Dimension( 530, 200));
        PlayersRank.setBorder(BorderFactory.createEtchedBorder());
        
        topLbl.add(lbl1);
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        panelCenterSpace.add(new JLabel(""));
        center.add(panelCenterSpace);
        PlayerNumber.add(lbl2);
        panelCenterSpace.add(PlayerNumber);        
        PlayerName.add(lbl3);
        panelCenterSpace.add(PlayerName);        
        PlayerScore.add(lbl4);
        panelCenterSpace.add(PlayerScore);        
        PlayerTime.add(lbl5);
        panelCenterSpace.add(PlayerTime);
        PlayerGameDate.add(lbl6);
        panelCenterSpace.add(PlayerGameDate);
        panelCenterSpace.add(new JLabel(" "));
        panelCenterSpace.add(PlayersRank);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        theBottom.add(new JLabel("                                                                                                                                                                          "));
        theBottom.add(btnRetour);
        btnRetour.addActionListener(btnRetour);
        underBottom.add(new JLabel(""));
        bottom.add(theBottom);
        bottom.add(underBottom);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        this.setTitle("QUIZZ : Classement du QUIZZ");
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
