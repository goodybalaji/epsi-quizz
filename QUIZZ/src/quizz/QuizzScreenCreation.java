/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Mama
 * Le nombre de question par QUIZZ sera compté par le soft et on valide la création avec le nombre de question.
 * 
 */
public class QuizzScreenCreation extends JFrame
{
    public JLabel lbl1 = new JLabel("Création du QUIZZ");
    public JLabel lbl2 = new JLabel("Nom du QUIZZ : ");
    public JLabel lbl3 = new JLabel("Thème :               ");
    public JLabel lbl4 = new JLabel("Difficulté :            ");
    public JLabel lbl5 = new JLabel("Temps (en min) : ");
    public static JTextField txtNameQuizz = new JTextField();
    public JComboBox cbxTheme = new JComboBox();
    public JComboBox cbxLevel = new JComboBox();
    public JTextField txtTemp = new JTextField();
    public QuizzBtn btnQuitterAdmin = new QuizzBtn("Quitter");
    public QuizzBtn btnNextQuestion = new QuizzBtn("Suivant");
    
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    
    public JPanel center = new JPanel();
    public JPanel panelCenterSpace = new JPanel();
    public JPanel panelCenterName = new JPanel();
    public JPanel panelCenterTheme = new JPanel();
    public JPanel panelCenterLevel = new JPanel();
    public JPanel panelCenterTemp = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();
    
    
    QuizzScreenCreation()
    {
        lbl1.setFont(lbl1.getFont().deriveFont(38.0f));
        txtNameQuizz.setPreferredSize(new Dimension( 200, 25));
        txtTemp.setPreferredSize(new Dimension( 200, 25));
        cbxLevel.setPreferredSize(new Dimension( 198, 25));
        cbxTheme.setPreferredSize(new Dimension( 198, 25));
        
        topLbl.add(lbl1);
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        panelCenterSpace.add(new JLabel(""));
        center.add(panelCenterSpace);
        panelCenterName.add(lbl2);
        panelCenterName.add(txtNameQuizz);
        center.add(panelCenterName);        
        panelCenterTheme.add(lbl3);
        panelCenterTheme.add(cbxTheme);
        center.add(panelCenterTheme);        
        panelCenterLevel.add(lbl4);
        panelCenterLevel.add(cbxLevel);
        center.add(panelCenterLevel);        
        panelCenterTemp.add(lbl5);
        panelCenterTemp.add(txtTemp);
        center.add(panelCenterTemp);        
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        btnQuitterAdmin.addActionListener(btnQuitterAdmin);
        btnNextQuestion.addActionListener(btnNextQuestion);
        
        theBottom.add(new JLabel("                                                                                                                                                                          "));
        theBottom.add(btnQuitterAdmin);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnNextQuestion);
        underBottom.add(new JLabel(""));
        bottom.add(theBottom);
        bottom.add(underBottom);
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
