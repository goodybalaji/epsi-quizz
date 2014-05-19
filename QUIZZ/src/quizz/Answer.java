/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizz;

/**
 *
 * @author Arc
 */
public class Answer {
    
    public int idAnswer;
    public String lblAnswer;
    public int correction;

    public String getLblAnswer() {
        return lblAnswer;
    }

    public void setLblAnswer(String lblAnswer) {
        this.lblAnswer = lblAnswer;
    }

    public int getCorrection() {
        return correction;
    }

    public void setCorrection(int correction) {
        this.correction = correction;
    }
    
    public Answer(int i){
        idAnswer = i;
    }
    
}
