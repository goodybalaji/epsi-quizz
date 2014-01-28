/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Mama
 */
public class QuizzScreenQuestionCorrection extends JFrame
{
    public ArrayList<JButton> questionBtnList = new ArrayList<JButton>();
    public int i;    
    public JLabel lblQuizzName = new JLabel("[Nom du QUIZZ]");
    public JLabel lblNbQuestion = new JLabel("Question : X/Y");
    public JLabel lblQuestion= new JLabel("Question : [ ... ] ");
    public JLabel lblRep1 = new JLabel("Solution 1 : [ ... ] ");
    public JLabel lblRep2 = new JLabel("Solution 2 : [ ... ] ");
    public JLabel lblRep3 = new JLabel("Solution 3 : [ ... ] ");
    public JCheckBox cbxQ1 = new JCheckBox();
    public JCheckBox cbxQ2 = new JCheckBox();
    public JCheckBox cbxQ3 = new JCheckBox();
    public QuizzBtn btnQuitterPlayer = new QuizzBtn("Quitter");
    public QuizzBtn btnNextCorrection = new QuizzBtn("  Suivant  ");    
    public QuizzBtn btnPreviousCorrection = new QuizzBtn("Précédent");
    
    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();
    public JPanel topLblBox = new JPanel();
    public JPanel topQuestion = new JPanel();
    public JPanel topQuestionList1 = new JPanel();
    public JPanel topQuestionList2 = new JPanel();
    
    public JPanel center = new JPanel();
    public JPanel panelCenterQuestion = new JPanel();
    public JPanel panelCenterRep1 = new JPanel();
    public JPanel panelCenterRep2 = new JPanel();
    public JPanel panelCenterRep3 = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();

    QuizzScreenQuestionCorrection() 
    {
        for(i=1; i<=41; i++)
        {
            JButton btn = new JButton("" + i);
            btn.setPreferredSize(new Dimension(28, 28));
            btn.setMargin(new Insets(0, 0, 0, 0));
            btn.setFont(btn.getFont().deriveFont(12.0f));
            //listener
            questionBtnList.add(btn);               
        }
        
        lblQuizzName.setFont(lblQuizzName.getFont().deriveFont(20.0f));
        lblNbQuestion.setFont(lblNbQuestion.getFont().deriveFont(18.0f));
        lblQuestion.setFont(lblQuestion.getFont().deriveFont(16.0f));
        
        topLblBox.add(lblQuizzName);
        topLblBox.add(lblNbQuestion);
        topLblBox.setLayout(new BoxLayout(topLblBox, BoxLayout.Y_AXIS));
        topLbl.add(topLblBox);
        for(i=0; i<=20; i++)
        {
            topQuestionList1.add(questionBtnList.get(i));
        }
        for(i=20; i<=39; i++)
        {
            topQuestionList2.add(questionBtnList.get(i));
        }
        topQuestion.add(topQuestionList1);
        topQuestion.add(topQuestionList2);
        topQuestion.setLayout(new BoxLayout(topQuestion, BoxLayout.Y_AXIS));
        
        top.add(topLbl);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.add(topQuestion);
        top.add(new JSeparator(SwingConstants.HORIZONTAL));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
     
        panelCenterQuestion.add(lblQuestion);
        center.add(panelCenterQuestion);
        panelCenterRep1.add(lblRep1);
        panelCenterRep1.add(cbxQ1);
        center.add(panelCenterRep1);
        panelCenterRep2.add(lblRep2);
        panelCenterRep2.add(cbxQ2);
        center.add(panelCenterRep2);
        panelCenterRep3.add(lblRep3);
        panelCenterRep3.add(cbxQ3);
        center.add(panelCenterRep3);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));     
          
        theBottom.add(btnQuitterPlayer);
        theBottom.add(new JLabel("                                                                                                                                     "));
        theBottom.add(btnPreviousCorrection);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnNextCorrection);
        underBottom.add(new JLabel(""));
        bottom.add(theBottom);
        bottom.add(underBottom);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        
        this.setTitle("QUIZZ : Corection du QUIZZ");
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
