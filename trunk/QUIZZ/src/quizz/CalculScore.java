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

    CalculScore(int nbRigthRep, int difficulte, double timeT, int nbTtRep) {
        score = ((((nbTtRep - nbRigthRep)* difficulte) / (timeT / 0.6)) * difficulte);
    }

    public double getScore() {
        return this.score;
    }
}
