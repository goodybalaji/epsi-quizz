/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static quizz.QuizzScreenAnswer.quizzTimer;
import static quizz.QUIZZ.BtnColor;
import static quizz.QUIZZ.answer1;
import static quizz.QUIZZ.answer2;
import static quizz.QUIZZ.answer3;
import static quizz.QUIZZ.answer4;
import static quizz.QUIZZ.question;
import static quizz.QUIZZ.quiz;

/**
 *
 * @author Mama
 */
public class QuizzScreenAnswer extends JFrame {

    static public QuizzTimer quizzTimer = new QuizzTimer();
    public static CustomFont CustomFont;
    public ArrayList<JButton> questionBtnList = new ArrayList<JButton>();
    public int i;
    public JLabel lblQuizzName = new JLabel("[Nom du Qwizz]", JLabel.CENTER);

    // public JLabel lblQuizzName = new JLabel("Nom du Qwizz");
    public QuizzBtn btnQuitterPlayer = new QuizzBtn("Abandonner");
    public QuizzBtn btnValideQuizz = new QuizzBtn("Valider Quizz");
    public QuizzBtn btnValideQuestion = new QuizzBtn("Valider Question");
    public QuizzBtn btnNextAnswer = new QuizzBtn("  Suivant  ");
    public QuizzBtn btnPreviousAnswer = new QuizzBtn("Précédent");

    public JLabel lblNbQuestion = new JLabel("       Question : " + quiz.getCurrentQuestion() + "/" + quiz.getNbQuestion(), JLabel.CENTER);
    public JLabel lblQuestion = new JLabel("Question : " + question.getLblQuestion());
    public JLabel lblRep1 = new JLabel("Solution 1 : " + answer1.getLblAnswer());
    public JLabel lblRep2 = new JLabel("Solution 2 : " + answer2.getLblAnswer());
    public JLabel lblRep3;
    public JLabel lblRep4;

    public JLabel lblTimer = new JLabel("XX:YY");
    public static JCheckBox cbxQ1 = new JCheckBox();
    public static JCheckBox cbxQ2 = new JCheckBox();
    public static JCheckBox cbxQ3 = new JCheckBox();
    public static JCheckBox cbxQ4 = new JCheckBox();

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
    public JPanel centerNorth = new JPanel();
    public JPanel centerWest = new JPanel();
    public JPanel centerEast = new JPanel();
    public JPanel panelCenterQuestion = new JPanel();
    public JPanel panelCenterRep1 = new JPanel();
    public JPanel panelCenterRep2 = new JPanel();
    public JPanel panelCenterRep3 = new JPanel();
    public JPanel panelCenterRep4 = new JPanel();
    public JPanel background = new JPanel();
    public String idQuiz;
    public String nameQuiz;

    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();

    QuizzScreenAnswer() {
        java.sql.Statement statement;
        try {
            statement = DBConnect.Connect();
            ResultSet rs = statement.executeQuery("SELECT nomQuiz FROM QUIZ "
                    + "WHERE idquiz =" + quiz.getId());
            rs.next();
            nameQuiz = rs.getString("nomQuiz");
            lblQuizzName.setText(nameQuiz);

            lblTimer = quizzTimer.lbl1;
            this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\QuizAnswer.png"))));
            CustomFont = new CustomFont();
            CFont = CustomFont.getFont("SF Slapstick Comic.ttf");

            rs = statement.executeQuery("Select idQuestion from composer where idQuiz = " + quiz.getId());
            int i = 1;
            while (rs.next() == true) {
                NumBtn btn = new NumBtn("" + i);
                btn.setIdQuestion(rs.getInt("idQuestion"));
                btn.setPreferredSize(new Dimension(28, 28));
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.setFont(btn.getFont().deriveFont(12.0f));
                //listener
                btn.addActionListener(btn);
                questionBtnList.add(btn);
                if (BtnColor[i - 1] == 1) {
                    btn.setBackground(GREEN);
                }
                i++;

            }
            if (quiz.getCurrentQuestion() >= 2) {
                if (BtnColor[quiz.getCurrentQuestion() - 2] == 1) {
                    btnPreviousAnswer.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizzScreenAnswer.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* lblRep3.setVisible(false);
         cbxQ3.setVisible(false);
         if (!quizSolution3.equals("")){
         lblRep3.setVisible(true);
         cbxQ3.setVisible(true);
         }*/
        lblQuizzName.setForeground(WHITE);
        lblQuizzName.setFont(CFont.deriveFont(32.0f));
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

        for (i = 0; i < quiz.getNbQuestion(); i++) {
            topQuestionList1.add(questionBtnList.get(i));
            topQuestionList1.setOpaque(false);
            topQuestionList1.setBorder(new EmptyBorder(0, 0, -3, 0));
        }
        if (quiz.getNbQuestion() > 20) {
            for (i = 20; i <= quiz.getNbQuestion(); i++) {

                topQuestionList2.add(questionBtnList.get(i));
                topQuestionList2.setOpaque(false);
                topSouth.add(topQuestionList2);
            }
        } else {
            topQuestionList1.setBorder(new EmptyBorder(0, 0, 30, 0));
        }
        topSouth.add(topQuestionList1);
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
        top.setBorder(new EmptyBorder(-2, 0, 0, 0));

        panelCenterQuestion.add(lblQuestion);
        panelCenterQuestion.setOpaque(false);
        centerNorth.add(panelCenterQuestion);
        panelCenterRep1.add(lblRep1);
        panelCenterRep1.add(cbxQ1);
        panelCenterRep1.setSize(75, 50);
        cbxQ1.setOpaque(false);
        centerNorth.setOpaque(false);
        panelCenterRep1.setOpaque(false);
        centerWest.add(panelCenterRep1);
        panelCenterRep2.add(lblRep2);
        panelCenterRep2.add(cbxQ2);
        panelCenterRep2.setSize(75, 50);
        cbxQ2.setOpaque(false);
        panelCenterRep2.setOpaque(false);
        centerEast.add(panelCenterRep2);
        centerWest.setOpaque(false);
        centerEast.setOpaque(false);
        if (question.getNbReponse() >= 3) {
            lblRep3 = new JLabel("Solution 3 : " + answer3.getLblAnswer());
            panelCenterRep3.add(lblRep3);
            panelCenterRep3.add(cbxQ3);
            cbxQ3.setOpaque(false);
            panelCenterRep3.setOpaque(false);
            centerWest.add(panelCenterRep3);
            centerWest.setOpaque(false);
            if (question.getNbReponse() == 4) {
                lblRep4 = new JLabel("Solution 4 : " + answer4.getLblAnswer());
                panelCenterRep4.add(lblRep4);
                panelCenterRep4.add(cbxQ4);
                cbxQ4.setOpaque(false);
                panelCenterRep4.setOpaque(false);
                centerEast.add(panelCenterRep4);
                centerEast.setOpaque(false);
            }
        }

        center.add(BorderLayout.NORTH, centerNorth);
        center.add(BorderLayout.WEST, centerWest);
        center.add(BorderLayout.EAST, centerEast);
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

        this.setTitle("QWIZZ !");
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
