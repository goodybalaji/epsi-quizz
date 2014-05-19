/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

/**
 *
 * @author Mama
 */
public class Question {
    int idQuestion;
    String urlQuestion;
    String lblQuestion;
    int nbReponse;

    public int getIdQuestion() {
        return idQuestion;
    }

    public String getUrlQuestion() {
        return urlQuestion;
    }

    public void setUrlQuestion(String urlQuestion) {
        this.urlQuestion = urlQuestion;
    }

    public String getLblQuestion() {
        return lblQuestion;
    }

    public void setLblQuestion(String lblQuestion) {
        this.lblQuestion = lblQuestion;
    }

    public int getNbReponse() {
        return nbReponse;
    }
    
    public void incNbReponse() {
        ++nbReponse;
    }
    
    Question(int i){
        idQuestion = i;
        nbReponse = 0;
    }
    
}
