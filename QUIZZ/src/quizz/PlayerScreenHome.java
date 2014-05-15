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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static quizz.QUIZZ.connectionScreen;

/**
 *
 * @author Arc
 */
public class PlayerScreenHome extends JFrame {

    public PlayerBtn btnDeco = new PlayerBtn("Déconnexion");
    public JLabel lbl2 = new JLabel("Nom : ");
    public JTextField txtNameQuizz = new JTextField();
    public JLabel lbl3 = new JLabel("Theme : ");
    public JLabel lbl4 = new JLabel("Difficulté : ");
    public JComboBox cbxTheme = new JComboBox();
    public JComboBox cbxDiffilute = new JComboBox();
    public PlayerBtn btnStatPlayer = new PlayerBtn("Statistiques");
    public PlayerBtn btnRankPlayer = new PlayerBtn("Classement");
    public PlayerBtn btnPlayPlayer = new PlayerBtn("Jouer");

    public JPanel top = new JPanel();
    public JPanel center = new JPanel();

    public JPanel centerTop = new JPanel();
    public JPanel centerBottom = new JPanel();
    public JPanel centerUnderBottom = new JPanel();
    public JPanel bottom = new JPanel();

    public JPanel topCenter = new JPanel();
    public JPanel topCenterC = new JPanel();
    public JPanel topEast = new JPanel();
    public JPanel topEastC = new JPanel();
    public JPanel topWest = new JPanel();
    public JPanel topWestC = new JPanel();
    public JPanel topSouth = new JPanel();
    public JPanel centerTopName = new JPanel();
    public JPanel centerTopTheme = new JPanel();
    public JPanel centerTopCheck = new JPanel();

    public JPanel JPlbl8 = new JPanel();
    public JTable tableau;
    public QwizTableModel data;
    TableRowSorter<TableModel> sorter;
    public int selectedRow;
    public String idQuiz;

    public int nb;
    public JPanel bottomBtnStat = new JPanel();
    public JPanel bottomBtnClass = new JPanel();
    public JPanel bottomBtnPlay = new JPanel();
    public JPanel background = new JPanel();

    
    PlayerScreenHome() throws SQLException {
        
        
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Resources\\HomeBG.png"))));
        final java.sql.Statement statement = DBConnect.Connect();

        topCenterC.add(new JLabel(" "));
        topCenterC.add(new JLabel(" "));
        topCenterC.setOpaque(false);
        topCenterC.setLayout(new BoxLayout(topCenterC, BoxLayout.Y_AXIS));
        topCenter.add(topCenterC);
        topCenter.setOpaque(false);
        topEastC.add(btnDeco);
        topEastC.setOpaque(false);
        topEast.add(topEastC);
        topEast.setOpaque(false);
        topEastC.setLayout(new BoxLayout(topEastC, BoxLayout.Y_AXIS));

        topSouth.setLayout(new BoxLayout(topSouth, BoxLayout.Y_AXIS));
        topSouth.setOpaque(false);

        topWest.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topEast.setPreferredSize(new Dimension(150, topCenter.getSize().height));
        topWest.setOpaque(false);

        top.setLayout(new BorderLayout());
        top.add(BorderLayout.CENTER, topCenter);
        top.add(BorderLayout.SOUTH, topSouth);
        top.add(BorderLayout.WEST, topWest);
        top.add(BorderLayout.EAST, topEast);
        top.setOpaque(false);

        btnDeco.addActionListener(btnDeco);

        //CENTER
        cbxTheme.addItem("");
        ResultSet rs = statement.executeQuery("Select * from THEME");
        while (rs.next() == true) {
            cbxTheme.addItem(rs.getString("lblTheme"));
        }

        cbxDiffilute.addItem("");
        rs = statement.executeQuery("Select * from Difficulte");
        while (rs.next() == true) {
            cbxDiffilute.addItem(rs.getString("lbldifficulte"));
        }

        txtNameQuizz.setPreferredSize(new Dimension(190, 25));
        cbxTheme.setPreferredSize(new Dimension(140, 25));
        cbxDiffilute.setPreferredSize(new Dimension(140, 25));
        centerTopName.add(lbl2);
        centerTopName.add(txtNameQuizz);
        centerTopName.setOpaque(false);
        centerTopTheme.add(lbl3);
        centerTopTheme.add(cbxTheme);
        centerTopTheme.setOpaque(false);
        centerTopTheme.add(lbl4);
        centerTopTheme.add(cbxDiffilute);
        centerTopCheck.setOpaque(false);
        centerTop.add(centerTopName);
        centerTop.add(centerTopTheme);
        centerTop.add(centerTopCheck);
        centerTop.setOpaque(false);

        cbxTheme.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    //tableau = null;
                    Object item = e.getItem();
                    if (item.toString().equals("")) {
                        sorter.setRowFilter(null);
                    } else {
                        try {
                            sorter.setRowFilter(RowFilter.regexFilter(item.toString(), 1));
                        } catch (PatternSyntaxException pse) {
                            System.err.println("Bad regex pattern");
                        }
                    }
                }
            }
        });

        cbxDiffilute.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    //tableau = null;
                    Object item = e.getItem();
                    if (item.toString().equals("")) {
                        sorter.setRowFilter(null);
                    } else {
                        try {
                            sorter.setRowFilter(RowFilter.regexFilter(item.toString(), 2));
                        } catch (PatternSyntaxException pse) {
                            System.err.println("Bad regex pattern");
                        }
                    }
                }
            }
        });

        txtNameQuizz.getDocument().addDocumentListener(new DocumentListener() {
            RowFilter<TableModel, Object> rf = null;

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    rf = RowFilter.regexFilter(txtNameQuizz.getText(), 0);
                } catch (java.util.regex.PatternSyntaxException error) {
                    return;
                }
                sorter.setRowFilter(rf);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               try {
                    rf = RowFilter.regexFilter(txtNameQuizz.getText(), 0);
                } catch (java.util.regex.PatternSyntaxException error) {
                    return;
                }
                sorter.setRowFilter(rf);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    rf = RowFilter.regexFilter(txtNameQuizz.getText(), 0);
                } catch (java.util.regex.PatternSyntaxException error) {
                    return;
                }
                sorter.setRowFilter(rf);
            }
        });

        centerBottom.setOpaque(false);
        rs = statement.executeQuery("Select count(nomquiz) "
                + "from QUIZ Q");
        rs.next();
        nb = rs.getInt(1);
        tableau = new JTable(data = new QwizTableModel(nb));
        sorter = new TableRowSorter<TableModel>(tableau.getModel());
        tableau.setRowSorter(sorter);
        rs = statement.executeQuery("SELECT Q.idQuiz, Q.nomQuiz, T.lblTheme, D.lblDifficulte, Q.dateCreaQuiz "
                + "FROM QUIZ Q, THEME T, DIFFICULTE D WHERE Q.idDifficulte = D.idDifficulte "
                + "AND Q.idTheme = T.idTheme ORDER BY Q.nomQuiz");
        int i = 0;
        while (rs.next() == true) {
            data.setValueAt(rs.getString("nomQuiz"), i, 0);
            data.setValueAt(rs.getString("lblTheme"), i, 1);
            data.setValueAt(rs.getString("lblDifficulte"), i, 2);
            data.setValueAt(setDate(rs.getDate("dateCreaQuiz").toString()), i, 3);
            data.setValueAt("" + rs.getInt("idQuiz"), i, 4);
            i++;
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
                }
            }
        });

        JPlbl8.setPreferredSize(new Dimension(670, 230));
        tableau.setPreferredSize(new Dimension(665, tableau.getRowCount() * 16));
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableau.getColumnModel().getColumn(0).setPreferredWidth(250);
        tableau.getColumnModel().getColumn(1).setPreferredWidth(130);
        tableau.getColumnModel().getColumn(2).setPreferredWidth(130);
        tableau.getColumnModel().getColumn(3).setPreferredWidth(130);
        tableau.getColumnModel().getColumn(4).setPreferredWidth(0);
        tableau.getSelectionModel().setSelectionMode(SINGLE_SELECTION);
        tableau.setSelectionBackground(Color.GREEN);
        tableau.setRowSelectionAllowed(true);
        tableau.setColumnSelectionAllowed(false);
        tableau.setCellSelectionEnabled(false);
        tableau.setCellEditor(null);
        JScrollPane scrollPane = new JScrollPane(tableau);
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
        btnStatPlayer.setPreferredSize(new Dimension(120, 50));
        btnStatPlayer.addActionListener(btnStatPlayer);
        btnRankPlayer.setPreferredSize(new Dimension(120, 50));
        btnRankPlayer.addActionListener(btnRankPlayer);
        btnPlayPlayer.setPreferredSize(new Dimension(120, 50));
        btnPlayPlayer.addActionListener(btnPlayPlayer);
        btnDeco.addActionListener(btnDeco);

        bottomBtnStat.add(btnStatPlayer);
        bottomBtnStat.setOpaque(false);
        bottomBtnClass.add(btnRankPlayer);
        bottomBtnClass.setOpaque(false);
        bottomBtnPlay.add(btnPlayPlayer);
        bottomBtnPlay.setOpaque(false);

        bottom.add(bottomBtnStat);
        bottom.add(bottomBtnClass);
        bottom.add(bottomBtnPlay);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        bottom.setOpaque(false);

        background.add(top);
        background.add(center);
        background.add(bottom);
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        this.setTitle("QWIZZ : Accueil");
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

    public static String setDate(String str) {
        char[] Char = new char[10];
        str.getChars(8, 10, Char, 0);
        Char[2] += '/';
        str.getChars(5, 7, Char, 3);
        Char[5] += '/';
        str.getChars(0, 4, Char, 6);
        return String.valueOf(Char);
    }

}
