/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static quizz.QUIZZ.accueilPlayerScreen;
import static quizz.QUIZZ.quizzStatPlayerScreen;
/**
 *
 * @author Arc
 */
public class PlayerBtnReturnStat extends JButton implements ActionListener{
    PlayerBtnReturnStat(String str)
    {
        super(str);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        accueilPlayerScreen.setVisible(true);
        quizzStatPlayerScreen.setVisible(false);
    }
}