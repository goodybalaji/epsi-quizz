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
    
    public Quiz(int id)
    {
        idQuiz = id;
        nbQuestion = 0;
    }
    
    public int getId()
    {
        return idQuiz;
    }    
    
    public void incNbQuestion()
    {
        nbQuestion++;
    }
    
    public int getNbQuestion()
    {
        return nbQuestion;
    }
}
