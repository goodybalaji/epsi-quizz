/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 * @author Llauron
 */
public class CalculScore {

    public double score;

    public double getScore() {
        return this.score;
    }

    CalculScore(double nbRepJuste, double coeff, double tpsPasse) {

        score = ((nbRepJuste * coeff) / (tpsPasse / 0.6)) * coeff;

    }

}
