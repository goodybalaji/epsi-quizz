/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author Mama
 * Le nombre de question par QUIZZ sera compté par le soft et on valide la création avec le nombre de question.
 * 
 */
public class QuestionCreationScreen extends JFrame
{
    public JLabel lbl1 = new JLabel("Création du QUIZZ");
    public JLabel lbl2 = new JLabel("Nom du QUIZZ :");
    public JLabel lbl3 = new JLabel("Thème :");
    public JLabel lbl4 = new JLabel("Difficulté :");
    public JLabel lbl5 = new JLabel("Temps (en min) :");
    public JTextField txtNomQuizz = new JTextField();
    public JComboBox cbxTheme = new JComboBox();
    public JComboBox cbxDifficulte = new JComboBox();
    public JTextField txtTemps = new JTextField(); 
    
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    
    QuestionCreationScreen()
    {
        topLbl.add(lbl1);
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        
        
        this.setTitle("QUIZZ : Création du QUIZZ");
        this.setSize(700,400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
