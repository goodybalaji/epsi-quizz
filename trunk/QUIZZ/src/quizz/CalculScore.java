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
    
    public double nbRepJuste;
    public double coeffRepJuste;
    public double tpsPasse;
    public double coeffDifficulte;
    public double score;
    
    
    public double calculScore(int nbRepJuste, int coeffRepJuste, int tpsPasse, int coeffDifficulte){
        
        score = ((nbRepJuste*coeffRepJuste)/(tpsPasse/0.6))*coeffDifficulte;
        
        return score;
    }
    
    
        

    
}
