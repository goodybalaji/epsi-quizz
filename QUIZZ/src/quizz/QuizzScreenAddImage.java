/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Arc
 */
public class QuizzScreenAddImage extends JFrame{
    
    public QuizzCreationBtn btnSave = new QuizzCreationBtn("Sauvegarder");
    public QuizzCreationBtn btnReturn = new QuizzCreationBtn("Annuler");
    
    public JPanel image = new JPanel();
    public JPanel bottom = new JPanel();
    
    QuizzScreenAddImage() {
        
        bottom.add(btnReturn);
        bottom.add(btnSave);
        
        btnSave.addActionListener(btnSave);
        btnReturn.addActionListener(btnReturn);
        
    /** Spécification de la page */
        this.setTitle("Ajout d'une image");
        setLayout(new BorderLayout());
        this.setSize(400,450);
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.CENTER, image);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}
