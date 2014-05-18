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
    
    public Quiz(int id)
    {
        idQuiz = id;
        nbQuestion = 0;
        currentQuestion = 1;
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
