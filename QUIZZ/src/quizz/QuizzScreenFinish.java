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
public class QuizzScreenFinish extends JFrame
{
    public JLabel lbl1 = new JLabel("Félicitation !");
    public JLabel lbl2 = new JLabel("Votre Score : Score_Joueur");
    public JLabel lbl3 = new JLabel("Votre Temps : Temps_Joueur");
    public JPanel PlayerScore = new JPanel();
    public JPanel PlayerTime = new JPanel();
    
    public QuizzBtn btnToCorrection = new QuizzBtn("Voir Correction");
    public QuizzBtn btnToRanking = new QuizzBtn("Classement");
    public QuizzBtn btnQuitterPlayer = new QuizzBtn("Quitter");
    
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    
    public JPanel center = new JPanel();
    public JPanel panelCenterSpace = new JPanel();
    public JPanel panelCenterPlayerScore = new JPanel();
    public JPanel panelCenterPlayerTime = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();
    
    QuizzScreenFinish()
    {
        
        lbl1.setFont(lbl1.getFont().deriveFont(38.0f));
        PlayerScore.setPreferredSize(new Dimension( 200, 25));
        PlayerTime.setPreferredSize(new Dimension( 200, 25));

        
        topLbl.add(lbl1);
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        panelCenterSpace.add(new JLabel(""));
        center.add(panelCenterSpace);
        panelCenterPlayerScore.add(lbl2);
        center.add(panelCenterPlayerScore);
        panelCenterPlayerTime.add(lbl3);
        center.add(panelCenterPlayerTime);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        theBottom.add(new JLabel("                                  "));
        theBottom.add(btnToCorrection);
        theBottom.add(new JLabel("   "));
        theBottom.add(btnToRanking);
        theBottom.add(new JLabel("   "));
        theBottom.add(btnQuitterPlayer);
        underBottom.add(new JLabel(""));
        bottom.add(theBottom);
        bottom.add(underBottom);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        this.setTitle("QUIZZ : Fin du QUIZZ");
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
