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
public class Quiz
{
    int idQuiz;
    int nbQuestion;
    int currentQuestion;
    int nbRightRep;
    int difficulte;
    int nbTtRightRep;

    public int getNbTtRightRep() {
        return nbTtRightRep;
    }

    public void setNbTtRightRep(int nbTtRightRep) {
        this.nbTtRightRep = nbTtRightRep;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
    
    public Quiz(int id)
    {
        idQuiz = id;
        nbQuestion = 0;
        currentQuestion = 1;
        nbRightRep = 0;
    }
    
    public int getId()
    {
        return idQuiz;
    }    
    
    public void incNbQuestion()
    {
        nbQuestion++;
    }
       
    public void decCurrentQuestion(){
        currentQuestion--;
    }
    
    public void setCurrentQuestion(int i){
        currentQuestion =i;
    }
    
    public void incNbRightRep()
    {
        nbRightRep++;
    }
    
    public void decNbRightRep()
    {
        nbRightRep++;
    }
    
    public int getNbRigthRep()
    {
        return nbRightRep;
    }
        
    public int getNbQuestion()
    {
        return nbQuestion;
    }
    
    public int getCurrentQuestion()
    {
        return currentQuestion;
    }
    
    public void setNbQuestion(int i)
    {
        nbQuestion = i;
    }
    
    public void incCurrentQuestion()
    {
        currentQuestion++;
    }
}
