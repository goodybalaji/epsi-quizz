/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Mama
 */
public class QuizzScreenQuestionCreation extends JFrame
{
    public int numQuestion = 1;
    public JLabel lbl1 = new JLabel("Création de QUIZZ - Ajout de question");
    public JLabel lbl2 = new JLabel("Question N° "+ numQuestion + " : ");
    public JLabel lbl3 = new JLabel("Réponse n°1 : ");
    public JLabel lbl4 = new JLabel("Réponse n°2 : ");
    public JLabel lbl5 = new JLabel("Réponse N°3 : ");
    public JLabel lbl6 = new JLabel("Réponse N°4 : ");
    public JLabel lbl7 = new JLabel("Réponse N°5 : ");
    public JTextField txtQuestion = new JTextField();
    public JTextField txtRep1 = new JTextField();
    public JTextField txtRep2 = new JTextField();
    public JTextField txtRep3 = new JTextField();
    public JTextField txtRep4 = new JTextField();
    public JTextField txtRep5 = new JTextField();
    public JCheckBox cbxQ1 = new JCheckBox();
    public JCheckBox cbxQ2 = new JCheckBox();
    public JCheckBox cbxQ3 = new JCheckBox();
    public JCheckBox cbxQ4 = new JCheckBox();
    public JCheckBox cbxQ5 = new JCheckBox();
    public QuizzBtn btnQuitterAdmin = new QuizzBtn("Quitter");
    public QuizzBtn btnNextQuestionCreation = new QuizzBtn("  Suivant  ");    
    public QuizzBtn btnPreviousQuestionCreation = new QuizzBtn("Précédent");
    
    
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    
    public JPanel center = new JPanel();
    public JPanel panelCenterSpace = new JPanel();
    public JPanel panelCenterValidateLbl = new JPanel();
    public JPanel panelCenterQuestion = new JPanel();
    public JPanel panelCenterRep1 = new JPanel();
    public JPanel panelCenterRep2 = new JPanel();
    public JPanel panelCenterRep3 = new JPanel();
    public JPanel panelCenterRep4 = new JPanel();
    public JPanel panelCenterRep5 = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();
    
    QuizzScreenQuestionCreation()
    {
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
        txtQuestion.setPreferredSize(new Dimension( 550, 25));
        txtRep1.setPreferredSize(new Dimension( 500, 25));
        txtRep2.setPreferredSize(new Dimension( 500, 25));
        txtRep3.setPreferredSize(new Dimension( 500, 25));
        txtRep4.setPreferredSize(new Dimension( 500, 25));
        txtRep5.setPreferredSize(new Dimension( 500, 25));
        
        topLbl.add(lbl1); 
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        panelCenterSpace.add(new JLabel(""));
        center.add(panelCenterSpace);
        
        panelCenterQuestion.add(lbl2);
        panelCenterQuestion.add(txtQuestion);
        center.add(panelCenterQuestion); 
        panelCenterValidateLbl.add(new JLabel("                                                                                                                                                                                                    "));
        panelCenterValidateLbl.add(new JLabel("V"));
        center.add(panelCenterValidateLbl);
        panelCenterRep1.add(lbl3);
        panelCenterRep1.add(txtRep1);
        panelCenterRep1.add(cbxQ1);
        center.add(panelCenterRep1);        
        panelCenterRep2.add(lbl4);
        panelCenterRep2.add(txtRep2);
        panelCenterRep2.add(cbxQ2);
        center.add(panelCenterRep2); 
        panelCenterRep3.add(lbl5);
        panelCenterRep3.add(txtRep3);
        panelCenterRep3.add(cbxQ3);
        center.add(panelCenterRep3); 
        panelCenterRep4.add(lbl6);
        panelCenterRep4.add(txtRep4);
        panelCenterRep4.add(cbxQ4);
        center.add(panelCenterRep4); 
        panelCenterRep5.add(lbl7);
        panelCenterRep5.add(txtRep5);
        panelCenterRep5.add(cbxQ5);
        center.add(panelCenterRep5); 
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        theBottom.add(btnQuitterAdmin);
        theBottom.add(new JLabel("                                                                                                                                     "));
        theBottom.add(btnPreviousQuestionCreation);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnNextQuestionCreation);
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
