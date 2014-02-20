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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Pierre
 */

//Ce compteur fonctionne de manière croissante (inverser les bonne donnée pour avoir un decompteur)
public class TimerTest extends JFrame
{
    int delai,seconde,minute;
    String duree;
    public JPanel center = new JPanel();
    public JPanel haut = new JPanel();
    public JLabel lbl1 = new JLabel("00:00");
    public JLabel lbl2 = new JLabel("");
    
    TimerTest()
    {
        delai = 1000; //en millisecondes
        seconde = 50;
        minute = 0;
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
        lbl2.setFont(lbl1.getFont().deriveFont(24.0f));
        
        
        center.add(lbl1);
        haut.add(lbl2);
       
        ActionListener taskPerformer; 
        taskPerformer = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                seconde = seconde+1;
                if(seconde == 60)
                {
                    seconde = 0;
                    minute = minute+1;
                    lbl1.setText(String.valueOf(minute)+":"+String.valueOf(seconde));
                }
                if(seconde >= 0 && seconde <= 9)
                {
                    if(minute >= 0 && minute <= 9)
                    {
                        lbl1.setText("0"+String.valueOf(minute)+":0"+String.valueOf(seconde));
                    }
                    //test
                    if(minute > 9)
                    {
                        lbl1.setText(String.valueOf(minute)+":0"+String.valueOf(seconde));
                    }
                    
                    
                }
                else
                {
                    if(minute >= 0 && minute <= 9)
                    {
                        lbl1.setText("0"+String.valueOf(minute)+":"+String.valueOf(seconde));
                    }
                    else
                    {
                        lbl1.setText(String.valueOf(minute)+":"+String.valueOf(seconde));
                    }
                }
                              
                if((minute == 1) && (seconde == 0)){
                    lbl2.setForeground(Color.green);
                    lbl2.setText("Allez, tu peux le faire");
                }
                if((minute == 1) && (seconde == 5)){
                    lbl2.setForeground(Color.orange);
                    lbl2.setText("Allez, fais pas ta tortue");
                }
                if((minute == 1) && (seconde == 10)){
                    lbl2.setForeground(Color.red);
                    lbl2.setText("Espèce de tortue !!! bouge ton cul !!!");
                }
            }
        };
        new Timer(delai, taskPerformer).start();
  
        this.setResizable(false);
        this.setSize(700,400);
        this.setTitle("QUIZZ : test du timer");
        this.getContentPane().add(BorderLayout.CENTER, center);
        this.getContentPane().add(BorderLayout.NORTH, haut);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
