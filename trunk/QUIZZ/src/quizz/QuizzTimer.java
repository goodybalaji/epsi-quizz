/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Pierre
 */

//Ce compteur fonctionne de manière croissante (inverser les bonne donnée pour avoir un decompteur)
public class QuizzTimer extends JFrame
{
    int delai,seconde,minute;
    public String retour;
    public JLabel lbl1 = new JLabel("00:00");
    public JLabel lbl2 = new JLabel("");
    
    QuizzTimer()
    {
        delai = 1000; //en millisecondes
        seconde = 0;
        minute = 0;
              
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
            }
        };
        new Timer(delai, taskPerformer).start();
        retour = String.valueOf(lbl1);
    }

    public int getSeconde() {
        return seconde;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    

}
