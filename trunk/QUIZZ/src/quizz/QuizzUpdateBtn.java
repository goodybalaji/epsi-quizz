/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static quizz.QUIZZ.adminScreenHome;
import static quizz.QUIZZ.quiz;
import static quizz.QUIZZ.quizzScreenCreation;
import static quizz.QUIZZ.quizzScreenQuestionCreation;
import static quizz.QUIZZ.quizzScreenQuestionUpdate;
import static quizz.QUIZZ.quizzScreenUpdate;

/**
 *
 * @author Mama
 */
public class QuizzUpdateBtn extends JButton implements ActionListener {

    QuizzUpdateBtn(String str) {
        super(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Suivant".equals(this.getText())) {
            if (quizzScreenUpdate.txtNameQuizz.getText().toString().isEmpty() != true) {

                int idDifficulte = 1;
                if (quizzScreenUpdate.cbxLevel.getSelectedItem().toString().equals("Normal")) {
                    idDifficulte = 2;
                } else if (quizzScreenUpdate.cbxLevel.getSelectedItem().toString().equals("Difficile")) {
                    idDifficulte = 3;
                }

                int idThema = 1;
                if (quizzScreenUpdate.cbxTheme.getSelectedItem().toString().equals("Sport")) {
                    idThema = 1;
                } else if (quizzScreenUpdate.cbxTheme.getSelectedItem().toString().equals("Cinema")) {
                    idThema = 2;
                } else if (quizzScreenUpdate.cbxTheme.getSelectedItem().toString().equals("Serie")) {
                    idThema = 3;
                } else if (quizzScreenUpdate.cbxTheme.getSelectedItem().toString().equals("Histoire")) {
                    idThema = 4;
                }

                try {
                    //création de la variable de connexion
                    final java.sql.Statement statement = DBConnect.Connect();

                    ResultSet rs = statement.executeQuery("Update QUIZ "
                            + "set idDifficulte =" + idDifficulte + ", idTheme = " + idThema
                            + ", nomquiz = '" + quizzScreenUpdate.txtNameQuizz.getText().toString()
                            + "', tempsmaxquiz=" + quizzScreenUpdate.txtTemps.getText().toString()
                            + " where idquiz = " + quiz.getId());
                    rs.next();
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                }

                quizzScreenUpdate.setVisible(false);
                try {
                    quizzScreenQuestionUpdate = new QuizzScreenQuestionUpdate();
                    quizzScreenQuestionUpdate.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuizzUpdateBtn.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(quizzScreenUpdate, "Vous devez donner un nom au QWIZZ avant de pouvoir le créer !!");
            }
        } else if ("  Suivant  ".equals(this.getText())) {
            if (quizzScreenQuestionUpdate.txtQuestion.getText().isEmpty() == false && quizzScreenQuestionUpdate.txtRep1.getText().isEmpty() == false
                    && quizzScreenQuestionUpdate.txtRep2.getText().isEmpty() == false) {
                if (quizzScreenQuestionUpdate.cbxQ1.isSelected() == true
                        || quizzScreenQuestionUpdate.cbxQ2.isSelected() == true
                        || quizzScreenQuestionUpdate.cbxQ3.isSelected() == true
                        || quizzScreenQuestionUpdate.cbxQ4.isSelected() == true) {
                    if (quizzScreenQuestionUpdate.imageQuestion.getText().isEmpty() == true
                            || quizzScreenQuestionUpdate.imageQuestion.getText().equals("http://")) {
                        try {
                            //création de la variable de connexion
                            final java.sql.Statement statement = DBConnect.Connect();
                            //update du quizz

                            ResultSet rs = statement.executeQuery("update QUESTION set lblquestion = '"
                                    + roping(quizzScreenQuestionUpdate.txtQuestion.getText().toString())
                                    + "' where idQuestion = " + quizzScreenQuestionUpdate.idQuestion);

                            int state;
                            //update de la solution 1
                            if (quizzScreenQuestionUpdate.cbxQ1.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep1.getText().toString())
                                    + "', estJuste = " + state
                                    + " where idSolution =" + quizzScreenQuestionUpdate.idSolution1);
                            //création de la solution 2
                            if (quizzScreenQuestionUpdate.cbxQ2.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep2.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution2);
                            //vérification d'une solution 3 et création
                            if (!quizzScreenQuestionUpdate.txtRep3.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ3.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep3.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution3);
                            }
                            //vérification d'une solution 4 et création
                            if (!quizzScreenQuestionUpdate.txtRep4.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ4.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep4.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution4);
                            }
                            quizzScreenQuestionUpdate.dispose();
                            quiz.incCurrentQuestion();
                            quizzScreenQuestionUpdate = new QuizzScreenQuestionUpdate();
                            quizzScreenQuestionUpdate.setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            //création de la variable de connexion
                            final java.sql.Statement statement = DBConnect.Connect();

                            ResultSet rs = statement.executeQuery("update QUESTION set lblquestion = '"
                                    + roping(quizzScreenQuestionUpdate.txtQuestion.getText().toString())
                                    + ", urlquestion ='" + quizzScreenQuestionCreation.imageQuestion.getText().toString()
                                    + "' where idQuestion = " + quizzScreenQuestionUpdate.idQuestion);

                            int state;
                            //création de la solution 1
                            if (quizzScreenQuestionUpdate.cbxQ1.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep1.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution1);
                            //création de la solution 2
                            if (quizzScreenQuestionUpdate.cbxQ2.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep2.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution2);
                            //vérification d'une solution 3 et création
                            if (!quizzScreenQuestionUpdate.txtRep3.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ3.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep3.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution3);
                            }
                            //vérification d'une solution 4 et création
                            if (!quizzScreenQuestionUpdate.txtRep4.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ4.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep4.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution4);
                            }
                            quizzScreenQuestionCreation.dispose();
                            quiz.incCurrentQuestion();
                            quizzScreenQuestionCreation = new QuizzScreenQuestionCreation();
                            quizzScreenQuestionCreation.setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(quizzScreenCreation, "Veuillez sélectionner au moin une réponse valide pour votre question.");
                }
            } else {
                JOptionPane.showMessageDialog(quizzScreenCreation, "Il faut créer une question avec deux réponse au minimum pour qu'elle soit valide");
            }
        } else if ("Finir Correction".equals(this.getText())) {
            if (quizzScreenQuestionUpdate.txtQuestion.getText().isEmpty() == false && quizzScreenQuestionUpdate.txtRep1.getText().isEmpty() == false
                    && quizzScreenQuestionUpdate.txtRep2.getText().isEmpty() == false) {
                if (quizzScreenQuestionUpdate.cbxQ1.isSelected() == true
                        || quizzScreenQuestionUpdate.cbxQ2.isSelected() == true
                        || quizzScreenQuestionUpdate.cbxQ3.isSelected() == true
                        || quizzScreenQuestionUpdate.cbxQ4.isSelected() == true) {
                    if (quizzScreenQuestionUpdate.imageQuestion.getText().isEmpty() == true
                            || quizzScreenQuestionUpdate.imageQuestion.getText().equals("http://")) {
                        try {
                            //création de la variable de connexion
                            final java.sql.Statement statement = DBConnect.Connect();
                            //update du quizz

                            ResultSet rs = statement.executeQuery("update QUESTION set lblquestion = '"
                                    + roping(quizzScreenQuestionUpdate.txtQuestion.getText().toString())
                                    + "' where idQuestion = " + quizzScreenQuestionUpdate.idQuestion);

                            int state;
                            //update de la solution 1
                            if (quizzScreenQuestionUpdate.cbxQ1.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep1.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution1);
                            //création de la solution 2
                            if (quizzScreenQuestionUpdate.cbxQ2.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep2.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution2);
                            //vérification d'une solution 3 et création
                            if (!quizzScreenQuestionUpdate.txtRep3.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ3.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep3.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution3);
                            }
                            //vérification d'une solution 4 et création
                            if (!quizzScreenQuestionUpdate.txtRep4.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ4.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep4.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution4);
                            }
                            adminScreenHome.dispose();
                            adminScreenHome = new AdminScreenHome();
                            adminScreenHome.setVisible(true);
                            quizzScreenQuestionUpdate.dispose();
                            quiz = null;
                        } catch (SQLException ex) {
                            Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            //création de la variable de connexion
                            final java.sql.Statement statement = DBConnect.Connect();

                            ResultSet rs = statement.executeQuery("update QUESTION set lblquestion = '"
                                    + roping(quizzScreenQuestionUpdate.txtQuestion.getText().toString())
                                    + ", urlquestion ='" + quizzScreenQuestionCreation.imageQuestion.getText().toString()
                                    + "' where idQuestion = " + quizzScreenQuestionUpdate.idQuestion);

                            int state;
                            //création de la solution 1
                            if (quizzScreenQuestionUpdate.cbxQ1.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep1.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution1);
                            //création de la solution 2
                            if (quizzScreenQuestionUpdate.cbxQ2.isSelected() == true) {
                                state = 1;
                            } else {
                                state = 0;
                            }
                            rs = statement.executeQuery("update SOLUTION set "
                                    + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep2.getText().toString())
                                    + "', estJuste = " + state + " "
                                    + "where idSolution =" + quizzScreenQuestionUpdate.idSolution2);
                            //vérification d'une solution 3 et création
                            if (!quizzScreenQuestionUpdate.txtRep3.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ3.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep3.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution3);
                            }
                            //vérification d'une solution 4 et création
                            if (!quizzScreenQuestionUpdate.txtRep4.getText().isEmpty()) {
                                if (quizzScreenQuestionUpdate.cbxQ4.isSelected() == true) {
                                    state = 1;
                                } else {
                                    state = 0;
                                }
                                rs = statement.executeQuery("update SOLUTION set "
                                        + "lblsolution = '" + roping(quizzScreenQuestionUpdate.txtRep4.getText().toString())
                                        + "', estJuste = " + state + " "
                                        + "where idSolution =" + quizzScreenQuestionUpdate.idSolution4);
                            }
                            adminScreenHome.dispose();
                            adminScreenHome = new AdminScreenHome();
                            adminScreenHome.setVisible(true);
                            quizzScreenQuestionUpdate.dispose();
                            quiz = null;
                        } catch (SQLException ex) {
                            Logger.getLogger(ConnectionBtn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(quizzScreenCreation, "Veuillez sélectionner au moin une réponse valide pour votre question.");
                }
            } else {
                JOptionPane.showMessageDialog(quizzScreenCreation, "Il faut créer une question avec deux réponse au minimum pour qu'elle soit valide");
            }
        }
    }

    public String roping(String str) {
        String quote = "'";
        char[] Char;
        String modif = str;
        Char = str.toCharArray();
        int inc = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Char[i] == quote.charAt(0)) {
                modif = setQuote(modif, quote, i + inc);
                inc++;
            }
        }
        return modif;
    }

    public String setQuote(String str, String lettre, int index) {
        StringBuilder bMot = new StringBuilder(str);
        bMot.setLength(str.length());
        bMot.insert(index, lettre.charAt(0));
        str = bMot.toString();
        return str;
    }
}
