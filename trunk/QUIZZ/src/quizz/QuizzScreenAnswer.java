/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import quizz.CustomFont;
/**
 *
 * @author Mama  
 */
public class QuizzScreenAnswer extends JFrame {

    
    static public QuizzTimer quizzTimer;
    


    public static CustomFont CustomFont;

    public ArrayList<JButton> questionBtnList = new ArrayList<JButton>();

    public int i; 

    public static int numQuestion = 1;


    public JLabel lblQuizzName = new JLabel("[Nom du QUIZZ]");

   // public JLabel lblQuizzName = new JLabel("Nom du Qwizz");

    public JLabel lblNbQuestion = new JLabel("Question : "+ numQuestion +"/40");
    public JLabel lblQuestion= new JLabel("Question : [ ... ] ");
    public JLabel lblRep1 = new JLabel("Solution 1 : [ ... ] ");
    public JLabel lblRep2 = new JLabel("Solution 2 : [ ... ] ");
    public JLabel lblRep3 = new JLabel("Solution 3 : [ ... ] ");
    public JLabel lblTimer = new JLabel("XX:YY");
    public JCheckBox cbxQ1 = new JCheckBox();
    public JCheckBox cbxQ2 = new JCheckBox();
    public JCheckBox cbxQ3 = new JCheckBox();
    public QuizzBtn btnQuitterPlayer = new QuizzBtn("Abandonner");
    public QuizzBtn btnValideQuizz = new QuizzBtn("Valider Quizz");
    public QuizzBtn btnValideQuestion = new QuizzBtn("Valider Question");
    public SwitchBtn btnNextAnswer = new SwitchBtn("  Suivant  ");    
    public SwitchBtn btnPreviousAnswer = new SwitchBtn("Précédent");
    public Font CFont;
    
    public JPanel top = new JPanel();
    public JPanel topCenter = new JPanel();
    public JPanel topSouth = new JPanel();
    public JPanel topEast = new JPanel();
    public JPanel topWest = new JPanel();
    public JPanel topCenterC = new JPanel();
    public JPanel topEastC = new JPanel();
    public JPanel topWestC = new JPanel();
    public JPanel topQuestionList1 = new JPanel();
    public JPanel topQuestionList2 = new JPanel();
    
    public JPanel center = new JPanel();
    public JPanel panelCenterQuestion = new JPanel();
    public JPanel panelCenterRep1 = new JPanel();
    public JPanel panelCenterRep2 = new JPanel();
    public JPanel panelCenterRep3 = new JPanel();
    public JPanel background = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();
    
    
    QuizzScreenAnswer()
    {

        quizzTimer = new QuizzTimer();     
        lblTimer = quizzTimer.lbl1;
        

        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\QuizAnswer.png"))));


        
        CustomFont = new CustomFont();
        CFont = CustomFont.getFont("Hanged Letters.ttf"); 
        /*
        addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fermer();
			}
		});
        */

        for(i=1; i<=41; i++)
        {
            JButton btn = new JButton("" + i);
            btn.setPreferredSize(new Dimension(28, 28));
            btn.setMargin(new Insets(0, 0, 0, 0));
            btn.setFont(btn.getFont().deriveFont(12.0f));
            //listener
            questionBtnList.add(btn);               
        }
        
        
        lblQuizzName.setForeground(WHITE);
        lblQuizzName.setFont(CFont.deriveFont(20.0f));
        lblNbQuestion.setFont(lblNbQuestion.getFont().deriveFont(18.0f));
        lblQuestion.setFont(lblQuestion.getFont().deriveFont(16.0f));
        lblTimer.setFont(lblTimer.getFont().deriveFont(16.0f));
        
        topWestC.add(lblTimer);
        topWestC.setOpaque(false);
        topWest.add(topWestC);
        topWest.setOpaque(false);
        topWestC.setLayout(new BoxLayout(topWestC, BoxLayout.Y_AXIS));
        topCenterC.add(lblQuizzName);
        topCenterC.add(lblNbQuestion);
        topCenterC.setLayout(new BoxLayout(topCenterC, BoxLayout.Y_AXIS));
        topCenterC.setOpaque(false);
        topCenter.add(topCenterC);
        topCenter.setOpaque(false);
        topEastC.add(btnQuitterPlayer);
        topEastC.setOpaque(false);
        topEast.add(topEastC);
        topEast.setOpaque(false);
        topEastC.setLayout(new BoxLayout(topEastC, BoxLayout.Y_AXIS));
        for(i=0; i<=20; i++)
        {
            topQuestionList1.add(questionBtnList.get(i));
            topQuestionList1.setOpaque(false);
        }
        for(i=20; i<=39; i++)
        {
            topQuestionList2.add(questionBtnList.get(i));
            topQuestionList2.setOpaque(false);
        }

        topSouth.add(topQuestionList1);
        topSouth.add(topQuestionList2);
        topSouth.setOpaque(false);
        topSouth.setLayout(new BoxLayout(topSouth, BoxLayout.Y_AXIS));
        
        topWest.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topEast.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        
        
        top.setLayout(new BorderLayout());        
        top.add(BorderLayout.CENTER, topCenter);
        top.add(BorderLayout.SOUTH, topSouth);
        top.add(BorderLayout.WEST, topWest);
        top.add(BorderLayout.EAST, topEast);
        top.setOpaque(false);
     
        panelCenterQuestion.add(lblQuestion);
        panelCenterQuestion.setOpaque(false);
        center.add(panelCenterQuestion);
        panelCenterRep1.add(lblRep1);
        panelCenterRep1.add(cbxQ1);
        cbxQ1.setOpaque(false);
        panelCenterRep1.setOpaque(false);
        center.add(panelCenterRep1);
        panelCenterRep2.add(lblRep2);
        panelCenterRep2.add(cbxQ2);
        cbxQ2.setOpaque(false);
        panelCenterRep2.setOpaque(false);
        center.add(panelCenterRep2);
        panelCenterRep3.add(lblRep3);
        panelCenterRep3.add(cbxQ3);
        cbxQ3.setOpaque(false);
        panelCenterRep3.setOpaque(false);
        center.add(panelCenterRep3);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);
          
        theBottom.add(btnValideQuizz);
        theBottom.add(new JLabel("                                                                         "));
        theBottom.add(btnPreviousAnswer);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnValideQuestion);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnNextAnswer);
        theBottom.setOpaque(false);
        underBottom.add(new JLabel(""));
        underBottom.setOpaque(false);
        bottom.add(theBottom);
        bottom.add(underBottom);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);
        
        btnQuitterPlayer.addActionListener(btnQuitterPlayer);
        btnValideQuizz.addActionListener(btnValideQuizz);
        btnValideQuestion.addActionListener(btnValideQuestion);
        btnNextAnswer.addActionListener(btnNextAnswer);
        btnPreviousAnswer.addActionListener(btnPreviousAnswer);
        
        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
                
        this.setTitle("QWIZZ : Answer");
        setLayout(new BorderLayout());
        this.setSize(700,400);  
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public class SwitchBtn extends JButton implements ActionListener
    {
        SwitchBtn(String str)
        {
            super(str);
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("  Suivant  ".equals(this.getText()))
        {
            numQuestion++;
            this.repaint();
        }
        }
    }
}
