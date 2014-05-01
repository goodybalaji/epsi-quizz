/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Mama
 */



public class QuizzScreenQuestionCreation extends JFrame
{
    public static int numQuestion = 1;
    public JLabel lbl1 = new JLabel(" ");
    public JLabel lbl2 = new JLabel("Question N° "+ numQuestion + " : ");
    public JLabel lblImage = new JLabel("Image (facultatif) : ");
    public JLabel lblNB = new JLabel(" Cochez la (les) réponse(s) correcte(s) ! ");
    public JLabel lbl3 = new JLabel("Réponse n°1 : ");
    public JLabel lbl4 = new JLabel("Réponse n°2 : ");
    public JLabel lbl5 = new JLabel("Réponse N°3 : ");
    public JLabel lbl6 = new JLabel("Réponse N°4 : ");
    public JLabel lbl7 = new JLabel("Réponse N°5 : ");
    public JTextField txtQuestion = new JTextField();
    public JTextField imageQuestion = new JTextField();
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
    public QuizzCreationBtn btnQuitterAdmin = new QuizzCreationBtn("Quitter");
    public QuizzCreationBtn btnNextQuestionCreation = new QuizzCreationBtn("  Suivant  ");    
    public QuizzCreationBtn btnFinishQuestionCreation = new QuizzCreationBtn("Finir Quizz");
    public QuizzCreationBtn btnAddURL = new QuizzCreationBtn("Valider");
    
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
    public JPanel background = new JPanel();
    
    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();
    
    QuizzScreenQuestionCreation()
    {
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\QuestionCreationBG.png"))));
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
        txtQuestion.setPreferredSize(new Dimension( 550, 25));
        imageQuestion.setPreferredSize(new Dimension( 350, 25));
        txtRep1.setPreferredSize(new Dimension( 500, 25));
        txtRep2.setPreferredSize(new Dimension( 500, 25));
        txtRep3.setPreferredSize(new Dimension( 500, 25));
        txtRep4.setPreferredSize(new Dimension( 500, 25));
        txtRep5.setPreferredSize(new Dimension( 500, 25));
        
        imageQuestion.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                imageQuestion.setText("");
            }
        });
        
        topLbl.add(lbl1); 
        topLbl.setOpaque(false);
        top.add(topLbl);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setOpaque(false);
        top.setBorder(new EmptyBorder(0,0,35,0));
        
        panelCenterQuestion.add(lbl2);
        panelCenterQuestion.add(txtQuestion);
        panelCenterQuestion.add(lblImage);
        panelCenterQuestion.add(imageQuestion);
        panelCenterQuestion.add(btnAddURL);
        panelCenterQuestion.add(lblNB);
        panelCenterQuestion.setBorder(new EmptyBorder(0,0,60,0));
        panelCenterQuestion.setOpaque(false);
        center.add(panelCenterQuestion);
        panelCenterRep1.add(lbl3);
        panelCenterRep1.add(txtRep1);
        panelCenterRep1.add(cbxQ1);
        panelCenterRep1.setOpaque(false);
        center.add(panelCenterRep1);        
        panelCenterRep2.add(lbl4);
        panelCenterRep2.add(txtRep2);
        panelCenterRep2.add(cbxQ2);
        panelCenterRep2.setOpaque(false);
        center.add(panelCenterRep2); 
        panelCenterRep3.add(lbl5);
        panelCenterRep3.add(txtRep3);
        panelCenterRep3.add(cbxQ3);
        panelCenterRep3.setOpaque(false);
        center.add(panelCenterRep3); 
        panelCenterRep4.add(lbl6);
        panelCenterRep4.add(txtRep4);
        panelCenterRep4.add(cbxQ4);
        panelCenterRep4.setOpaque(false);
        center.add(panelCenterRep4); 
        panelCenterRep5.setBorder(new EmptyBorder(0,0,100,0));
        panelCenterRep5.setOpaque(false);
        /*panelCenterRep5.add(txtRep5);
        panelCenterRep5.add(cbxQ5);
        center.add(panelCenterRep5);*/ 
        
        btnQuitterAdmin.addActionListener(btnQuitterAdmin);
        btnNextQuestionCreation.addActionListener(btnNextQuestionCreation);
        btnAddURL.addActionListener(btnAddURL);
         btnFinishQuestionCreation.addActionListener( btnFinishQuestionCreation);
       
        center.add(panelCenterRep5);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);
        
        theBottom.add(btnQuitterAdmin);
        theBottom.add(new JLabel("                                                                                                                                     "));
        theBottom.add(btnFinishQuestionCreation);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnNextQuestionCreation);
        theBottom.setOpaque(false);
        underBottom.add(new JLabel(""));
        underBottom.setOpaque(false);
        bottom.add(theBottom);
        bottom.add(underBottom);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);
        
        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        
        this.setTitle("QWIZZ : Création du QUIZ");
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

  
}
