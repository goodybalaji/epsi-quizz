/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.HeadlessException;
import javax.swing.*;

/**
 *
 * @author Mama
 */
public class QuestionCorrectionScreen extends JFrame
{
    public JLabel lblQuizzName = new JLabel("[Nom du QUIZZ]");
    public JLabel lblNbQuestion = new JLabel("Question : X/Y" );
    public JLabel lblQuestion= new JLabel("Question : [ ... ] ");
    public JLabel lblRep1 = new JLabel("Solution 1 : [ ... ] ");
    public JLabel lblRep2 = new JLabel("Solution 2 : [ ... ] ");
    public JLabel lblRep3 = new JLabel("Solution 3 : [ ... ] ");
    public JCheckBox cbxQ1 = new JCheckBox();
    public JCheckBox cbxQ2 = new JCheckBox();
    public JCheckBox cbxQ3 = new JCheckBox();
    public LeaveToAdminBtn btnQuitter = new LeaveToAdminBtn("Quitter");
    public QuestionCreationBtn btnNext = new QuestionCreationBtn("Suivant");
    
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

    QuestionCorrectionScreen() 
    {
        
    }
    
    
}
