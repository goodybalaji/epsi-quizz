/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mama
 */
public class QuestionCrationScreen extends JFrame
{
    public int numQuestion = 1;
    public JLabel lbl1 = new JLabel("Création de QUIZZ - Ajout de question");
    public JLabel lbl2 = new JLabel("Question N° "+ numQuestion + " : ");
    public JLabel lbl3 = new JLabel("Réponse n°1 : ");
    public JLabel lbl4 = new JLabel("Réponse n°2 : ");
    public JLabel lbl5 = new JLabel("Réponse N°3 : ");
    public JLabel lbl6 = new JLabel("Réponse N°4 : ");
    public JLabel lbl7 = new JLabel("Réponse N°5 : ");
    public JCheckBox cbxQ1 = new JCheckBox();
    public JCheckBox cbxQ2 = new JCheckBox();
    public JCheckBox cbxQ3 = new JCheckBox();
    public JCheckBox cbxQ4 = new JCheckBox();
    public JCheckBox cbxQ5 = new JCheckBox();
    
    
    QuestionCrationScreen()
    {
        
    }
        
}
