/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.BorderLayout;
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
public class TimerTest extends JFrame
{
    int delai,seconde,minute;
    public JPanel center = new JPanel();
    public JLabel lbl1 = new JLabel("00:00");
    
    TimerTest()
    {
        delai = 1000; //milliseconds
        seconde = 0;
        minute = 0;
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
        center.add(lbl1);
       
        ActionListener taskPerformer = new ActionListener() 
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
            }
        };
        new Timer(delai, taskPerformer).start();
  
        this.setResizable(false);
        this.setSize(700,400);
        this.setTitle("QUIZZ : test du timer");
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
