/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static quizz.QUIZZ.quiz;

/**
 *
 * @author Mama
 */
public class QuizzScreenUpdate extends JFrame {

    public JLabel lbl1 = new JLabel(" ");
    public JLabel lbl2 = new JLabel("Nom du Qwizz : ");
    public JLabel lbl3 = new JLabel("Thème :               ");
    public JLabel lbl4 = new JLabel("Difficulté :            ");
    public JLabel lbl5 = new JLabel("Temps (en min) : ");
    public JTextField txtNameQuizz = new JTextField();
    public JComboBox cbxTheme = new JComboBox();
    public JComboBox cbxLevel = new JComboBox();
    public JTextField txtTemps = new JTextField();
    public QuizzUpdateBtn btnQuitterAdmin = new QuizzUpdateBtn("Quitter");
    public QuizzUpdateBtn btnNextQuestion = new QuizzUpdateBtn("Suivant");

    public JPanel top = new JPanel();
    public JPanel topLbl = new JPanel();

    public JPanel center = new JPanel();
    public JPanel panelCenterSpace = new JPanel();
    public JPanel panelCenterName = new JPanel();
    public JPanel panelCenterTheme = new JPanel();
    public JPanel panelCenterLevel = new JPanel();
    public JPanel panelCenterTemp = new JPanel();
    public JPanel background = new JPanel();

    public JPanel bottom = new JPanel();
    public JPanel theBottom = new JPanel();
    public JPanel underBottom = new JPanel();

    public QuizzScreenUpdate() {
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\QuizCreationBG.png"))));

        lbl1.setFont(lbl1.getFont().deriveFont(38.0f));
        txtNameQuizz.setPreferredSize(new Dimension(200, 25));
        txtTemps.setPreferredSize(new Dimension(200, 25));
        cbxLevel.setPreferredSize(new Dimension(198, 25));
        cbxTheme.setPreferredSize(new Dimension(198, 25));

        topLbl.add(lbl1);
        topLbl.setOpaque(false);
        top.add(topLbl);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setOpaque(false);

        try {
            java.sql.Statement statement = DBConnect.Connect();
            ResultSet rs = statement.executeQuery("Select * from THEME");
            while (rs.next() == true) {
                cbxTheme.addItem(rs.getString("lblTheme"));
            }
            rs = statement.executeQuery("Select * from Difficulte");
            while (rs.next() == true) {
                cbxLevel.addItem(rs.getString("lblDifficulte"));
            }
            rs = statement.executeQuery("select * from quiz where idquiz = " + quiz.getId());
            rs.next();
            quiz.setNbQuestion(rs.getInt("nbQuestionQuiz"));
            txtNameQuizz.setText(rs.getString("nomquiz"));
            cbxLevel.setSelectedIndex(rs.getInt("iddifficulte") - 1);
            cbxTheme.setSelectedIndex(rs.getInt("idtheme") - 1);
            txtTemps.setText(rs.getString("tempsmaxquiz"));

        } catch (SQLException ex) {
            Logger.getLogger(QuizzScreenCreation.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelCenterSpace.add(new JLabel(""));
        panelCenterSpace.setOpaque(false);
        center.add(panelCenterSpace);
        panelCenterName.add(lbl2);
        panelCenterName.add(txtNameQuizz);
        panelCenterName.setOpaque(false);
        center.add(panelCenterName);
        panelCenterTheme.add(lbl3);
        panelCenterTheme.add(cbxTheme);
        panelCenterTheme.setOpaque(false);
        center.add(panelCenterTheme);
        panelCenterLevel.add(lbl4);
        panelCenterLevel.add(cbxLevel);
        panelCenterLevel.setOpaque(false);
        center.add(panelCenterLevel);
        panelCenterTemp.add(lbl5);
        panelCenterTemp.add(txtTemps);
        panelCenterTemp.setOpaque(false);
        center.add(panelCenterTemp);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);

        btnQuitterAdmin.addActionListener(btnQuitterAdmin);
        btnNextQuestion.addActionListener(btnNextQuestion);

        theBottom.add(new JLabel("                                                                                                                                                                          "));
        theBottom.add(btnQuitterAdmin);
        theBottom.add(new JLabel(" "));
        theBottom.add(btnNextQuestion);
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

        this.setTitle("QUIZZ : Modification du QUIZZ");
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
