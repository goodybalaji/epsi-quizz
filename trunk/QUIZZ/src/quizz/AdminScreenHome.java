/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static quizz.PlayerScreenHome.setDate;
import static quizz.QUIZZ.admin;
import static quizz.QUIZZ.connectionScreen;
import static quizz.QUIZZ.quiz;

/**
 *
 * @author Arc
 */
public class AdminScreenHome extends JFrame {

    public JLabel lbl1 = new JLabel(" ");
    public AdminBtn btnDeco = new AdminBtn("Déconnexion");
    public JTable tableau;
    public QwizTableModel data;
    public int nb;
    public int selectedRow;
    public String idQuiz;
    public AdminBtn btnClassAdmin = new AdminBtn("Classement");
    public AdminBtn btnModifAdmin = new AdminBtn("Modifier");
    public AdminBtn btnDelAdmin = new AdminBtn("Supprimer");
    public AdminBtn btnNewAdmin = new AdminBtn("Nouveau Quizz");
    public AdminBtn btnAddAdmin = new AdminBtn("Ajouter Admin");

    public JPanel top = new JPanel();
    public JPanel topEast = new JPanel();
    public JPanel topEastC = new JPanel();
    public JPanel topCenter = new JPanel();
    public JPanel topCenterC = new JPanel();
    public JPanel topSouth = new JPanel();
    public JPanel topWest = new JPanel();
    public JPanel topWestC = new JPanel();
    public JPanel center = new JPanel();
    public JPanel centerTop = new JPanel();
    public JPanel centerBottom = new JPanel();
    public JPanel bottom = new JPanel();
    public JPanel background = new JPanel();

    public JPanel JPlbl8 = new JPanel();
    public JPanel bottomClassBtn = new JPanel();
    public JPanel bottomModifBtn = new JPanel();
    public JPanel bottomDelBtn = new JPanel();
    public JPanel bottomNewBtn = new JPanel();

    AdminScreenHome(){
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\AdminHome.png"))));
        
        //TOP
        lbl1.setFont(lbl1.getFont().deriveFont(18.0f));

        topCenterC.add(lbl1);
        topCenterC.setLayout(new BoxLayout(topCenterC, BoxLayout.Y_AXIS));
        topCenterC.setOpaque(false);
        topCenter.add(topCenterC);
        topCenter.setOpaque(false);
        topEastC.add(btnDeco);
        topEastC.setOpaque(false);
        topEast.add(topEastC);
        topEast.setOpaque(false);
        topEastC.setLayout(new BoxLayout(topEastC, BoxLayout.Y_AXIS));
        topWestC.add(btnAddAdmin);
        topWestC.setOpaque(false);
        topWest.add(topWestC);
        topWest.setOpaque(false);
        topWestC.setLayout(new BoxLayout(topWestC, BoxLayout.Y_AXIS));

        topSouth.setLayout(new BoxLayout(topSouth, BoxLayout.Y_AXIS));
        topSouth.setOpaque(false);

        topWest.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topWest.setOpaque(false);
        topEast.setPreferredSize(new Dimension(150, topCenter.getSize().height));

        top.setLayout(new BorderLayout());
        top.add(BorderLayout.CENTER, topCenter);
        top.add(BorderLayout.SOUTH, topSouth);
        top.add(BorderLayout.WEST, topWest);
        top.add(BorderLayout.EAST, topEast);
        top.setOpaque(false);

        //CENTER       
        centerTop.setOpaque(false);

        final java.sql.Statement statement;
        try {
            statement = DBConnect.Connect();
            ResultSet rs = statement.executeQuery("Select count(nomquiz) "
                    + "from QUIZ Q "
                    + "Where idAdmin = " + admin.getId());
            rs.next();
            nb = rs.getInt(1);
            tableau = new JTable(data = new QwizTableModel(nb));

            rs = statement.executeQuery("SELECT Q.idQuiz, Q.nomQuiz, T.lblTheme, D.lblDifficulte, Q.dateCreaQuiz "
                    + "FROM QUIZ Q, THEME T, DIFFICULTE D WHERE Q.idDifficulte = D.idDifficulte "
                    + "AND Q.idTheme = T.idTheme And idAdmin = " + admin.getId()
                    + " ORDER BY Q.nomQuiz");
            int i = 0;
            while (rs.next() == true) {
                data.setValueAt(rs.getString("nomQuiz"), i, 0);
                data.setValueAt(rs.getString("lblTheme"), i, 1);
                data.setValueAt(rs.getString("lblDifficulte"), i, 2);
                data.setValueAt(setDate(rs.getDate("dateCreaQuiz").toString()), i, 3);
                data.setValueAt("" + rs.getInt("idQuiz"), i, 4);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminScreenHome.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListSelectionModel listSelectionModel = tableau.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                if (lsm.isSelectionEmpty()) {
                    System.out.println("No rows selected");
                } else {
                    selectedRow = lsm.getMinSelectionIndex();
                    idQuiz = data.getValueAt(selectedRow, 4).toString();
                    quiz = new Quiz(Integer.parseInt(idQuiz));
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableau);
        JPlbl8.setPreferredSize(new Dimension(670, 230));
        tableau.setPreferredSize(new Dimension(665, tableau.getRowCount() * 16));
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableau.getColumnModel().getColumn(0).setPreferredWidth(250);
        tableau.getColumnModel().getColumn(1).setPreferredWidth(130);
        tableau.getColumnModel().getColumn(2).setPreferredWidth(130);
        tableau.getColumnModel().getColumn(3).setPreferredWidth(130);
        tableau.getColumnModel().getColumn(4).setPreferredWidth(0);
        tableau.getSelectionModel().setSelectionMode(SINGLE_SELECTION);
        tableau.setRowSelectionAllowed(true);
        tableau.setColumnSelectionAllowed(false);
        tableau.setCellSelectionEnabled(false);
        tableau.setCellEditor(null);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(665, 215));
        JPlbl8.add(scrollPane);
        JPlbl8.setOpaque(false);
        centerBottom.add(JPlbl8);
        centerBottom.setOpaque(false);
        center.add(centerTop);
        center.add(centerBottom);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);

        //BOTTOM
        btnNewAdmin.addActionListener(btnNewAdmin);
        btnClassAdmin.addActionListener(btnClassAdmin);
        btnModifAdmin.addActionListener(btnModifAdmin);
        btnDelAdmin.addActionListener(btnDelAdmin);
        btnAddAdmin.addActionListener(btnAddAdmin);
        btnDeco.addActionListener(btnDeco);
        btnClassAdmin.setPreferredSize(new Dimension(120, 50));
        btnModifAdmin.setPreferredSize(new Dimension(120, 50));
        btnDelAdmin.setPreferredSize(new Dimension(120, 50));
        btnNewAdmin.setPreferredSize(new Dimension(120, 50));

        bottomClassBtn.add(btnClassAdmin);
        bottomClassBtn.setOpaque(false);
        bottomModifBtn.add(btnModifAdmin);
        bottomModifBtn.setOpaque(false);
        bottomDelBtn.add(btnDelAdmin);
        bottomDelBtn.setOpaque(false);
        bottomNewBtn.add(btnNewAdmin);
        bottomNewBtn.setOpaque(false);

        bottom.add(bottomClassBtn);
        bottom.add(bottomModifBtn);
        bottom.add(bottomDelBtn);
        bottom.add(bottomNewBtn);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);

        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        this.setTitle("QWIZZ : ACCUEIL Admin");
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
