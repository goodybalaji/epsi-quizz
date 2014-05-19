/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static quizz.PlayerBtn.timeMinute;
import static quizz.PlayerBtn.timeSecond;
import static quizz.QUIZZ.calculScore;
import static quizz.QuizzBtn.scoreQuiz;
import static quizz.QUIZZ.playerScreenHome;

/**
 *
 * @author mathieu
 */
public class QuizzScreenFinish extends JFrame {
    
    Double score = new Double (calculScore.getScore());
 
    public JLabel lbl1 = new JLabel("   ");
    public JLabel lbl2 = new JLabel("Votre Score : " + score.toString());
    public JLabel lbl3 = new JLabel("Votre Temps : " + timeMinute + " min " + timeSecond + " sec ");
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
    public JPanel background = new JPanel();

    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();

    QuizzScreenFinish() {

        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\QuizFinishBG.png"))));
        lbl1.setFont(lbl1.getFont().deriveFont(38.0f));
        PlayerScore.setPreferredSize(new Dimension(200, 25));
        PlayerTime.setPreferredSize(new Dimension(200, 25));

        topLbl.add(lbl1);
        topLbl.setOpaque(false);
        top.add(topLbl);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setOpaque(false);

        panelCenterSpace.add(new JLabel(""));
        panelCenterSpace.setOpaque(false);
        center.add(panelCenterSpace);
        center.setOpaque(false);
        panelCenterPlayerScore.add(lbl2);
        panelCenterPlayerScore.setOpaque(false);
        center.add(panelCenterPlayerScore);
        panelCenterPlayerTime.add(lbl3);
        panelCenterPlayerTime.setOpaque(false);
        center.add(panelCenterPlayerTime);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        theBottom.add(new JLabel("                                  "));
        theBottom.add(btnToCorrection);
        theBottom.add(new JLabel("   "));
        theBottom.add(btnToRanking);
        theBottom.add(new JLabel("   "));
        theBottom.add(btnQuitterPlayer);
        theBottom.setOpaque(false);
        underBottom.add(new JLabel(""));
        underBottom.setOpaque(false);
        bottom.add(theBottom);
        bottom.add(underBottom);
        bottom.setOpaque(false);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));

        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        btnToCorrection.addActionListener(btnToCorrection);
        btnToRanking.addActionListener(btnToRanking);
        btnQuitterPlayer.addActionListener(btnQuitterPlayer);

        this.setTitle("QWIZZ : Fin du Quiz");
        setLayout(new BorderLayout());
        this.setSize(700, 400);
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
