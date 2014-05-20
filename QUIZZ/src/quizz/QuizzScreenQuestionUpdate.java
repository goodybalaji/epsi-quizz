package quizz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static quizz.QUIZZ.quiz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mama
 */
public class QuizzScreenQuestionUpdate extends JFrame {

    public JLabel lbl1 = new JLabel(" ");
    public JLabel lbl2 = new JLabel("Question N° " + quiz.getCurrentQuestion() + " : ");
    public JLabel lblImage = new JLabel("Image (facultatif) : ");
    public JLabel lblNB = new JLabel(" Cochez la (les) réponse(s) correcte(s) ! ");
    public JLabel lbl3 = new JLabel("Réponse n°1 : ");
    public JLabel lbl4 = new JLabel("Réponse n°2 : ");
    public JLabel lbl5 = new JLabel("Réponse N°3 : ");
    public JLabel lbl6 = new JLabel("Réponse N°4 : ");
    public JTextField txtQuestion = new JTextField();
    public JTextField imageQuestion = new JTextField();
    public JTextField txtRep1 = new JTextField();
    public JTextField txtRep2 = new JTextField();
    public JTextField txtRep3 = new JTextField();
    public JTextField txtRep4 = new JTextField();
    public JCheckBox cbxQ1 = new JCheckBox();
    public JCheckBox cbxQ2 = new JCheckBox();
    public JCheckBox cbxQ3 = new JCheckBox();
    public JCheckBox cbxQ4 = new JCheckBox();
    public QuizzUpdateBtn btnNextQuestionCreation = new QuizzUpdateBtn("  Suivant  ");
    public QuizzUpdateBtn btnFinishQuestionCreation = new QuizzUpdateBtn("Finir Correction");
    public QuizzUpdateBtn btnAddURL = new QuizzUpdateBtn("Visualiser");

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
    java.sql.Statement statement;
    int idQuestion;
    int idSolution1 = 0;
    int idSolution2 = 0;
    int idSolution3 = 0;
    int idSolution4 = 0;

    QuizzScreenQuestionUpdate() throws SQLException {
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\QuestionCreationBG.png"))));

        statement = DBConnect.Connect();
        ResultSet rs = statement.executeQuery("Select qu.idquestion, qu.lblquestion, qu.urlquestion"
                + " from question qu, composer c, quiz q "
                + "where qu.idquestion = c.idquestion "
                + "and q.idquiz = c.idquiz "
                + "and q.idquiz = " + quiz.getId()
                + " order by idquestion");
        if (quiz.getCurrentQuestion() <= quiz.getNbQuestion()) {
            int i = 0;
            while (i != quiz.getCurrentQuestion()) {
                i++;
                rs.next();
            }
            txtQuestion.setText(rs.getString("lblquestion"));
            imageQuestion.setText(rs.getString("urlquestion"));
            idQuestion = rs.getInt("idquestion");

            rs = statement.executeQuery("select idsolution, lblSolution, estJuste "
                    + "from solution where idquestion = " + idQuestion
                    + " order by idsolution");
            rs.next();
            txtRep1.setText(rs.getString("lblSolution"));
            idSolution1 = rs.getInt("idsolution");
            if (rs.getInt("estJuste") == 1) {
                cbxQ1.setSelected(true);
            }
            rs.next();
            txtRep2.setText(rs.getString("lblSolution"));
            idSolution2 = rs.getInt("idsolution");
            if (rs.getInt("estJuste") == 1) {
                cbxQ2.setSelected(true);
            }
            if (rs.next() == true) {
                txtRep3.setText(rs.getString("lblSolution"));
                idSolution3 = rs.getInt("idsolution");
                if (rs.getInt("estJuste") == 1) {
                    cbxQ3.setSelected(true);
                }
            }
            if (rs.next() == true) {
                txtRep4.setText(rs.getString("lblSolution"));
                idSolution4 = rs.getInt("idsolution");
                if (rs.getInt("estJuste") == 1) {
                    cbxQ4.setSelected(true);
                }
            }

        }
        if (quiz.getCurrentQuestion() == quiz.getNbQuestion()) {
            btnNextQuestionCreation.setEnabled(false);
        }
        lbl1.setFont(lbl1.getFont().deriveFont(24.0f));
        txtQuestion.setPreferredSize(new Dimension(550, 25));
        imageQuestion.setPreferredSize(new Dimension(350, 25));
        txtRep1.setPreferredSize(new Dimension(500, 25));
        txtRep2.setPreferredSize(new Dimension(500, 25));
        txtRep3.setPreferredSize(new Dimension(500, 25));
        txtRep4.setPreferredSize(new Dimension(500, 25));

       

        topLbl.add(lbl1);
        topLbl.setOpaque(false);
        top.add(topLbl);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setOpaque(false);
        top.setBorder(new EmptyBorder(0, 0, 35, 0));

        panelCenterQuestion.add(lbl2);
        panelCenterQuestion.add(txtQuestion);
        panelCenterQuestion.add(lblImage);
        panelCenterQuestion.add(imageQuestion);
        panelCenterQuestion.add(btnAddURL);
        panelCenterQuestion.add(lblNB);
        panelCenterQuestion.setBorder(new EmptyBorder(0, 0, 60, 0));
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
        panelCenterRep5.setBorder(new EmptyBorder(0, 0, 100, 0));
        panelCenterRep5.setOpaque(false);
        /*panelCenterRep5.add(txtRep5);
         panelCenterRep5.add(cbxQ5);
         center.add(panelCenterRep5);*/

     
        btnNextQuestionCreation.addActionListener(btnNextQuestionCreation);
        btnAddURL.addActionListener(btnAddURL);
        btnFinishQuestionCreation.addActionListener(btnFinishQuestionCreation);

        center.add(panelCenterRep5);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);

        theBottom.add(new JLabel("                                                                                                                                                  "));
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

        this.setTitle("QWIZZ : Modification du QUIZ");
        setLayout(new BorderLayout());
        this.setSize(700, 400);
        this.setResizable(false);
        this.getContentPane().add(BorderLayout.SOUTH, bottom);
        this.getContentPane().add(BorderLayout.NORTH, top);
        this.getContentPane().add(BorderLayout.CENTER, center);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
