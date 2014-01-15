/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 * @author Mathieu 'Triboulet' RONDOT
 */
public class QUIZZ
{

    static public QuestionCreationScreen questionCreationScreen;
    static public QuizzCreationScreen quizzCreationScreen;
    static public AccueilJoueurScreen accueilPlayerScreen;
    static public AccueilAdminScreen accueilAdminScreen;
    static public QuestionCorrectionScreen questionCorrectionScreen;
    static public PlayerRankQuizzScreen playerRankQuizzScreen;
    static public QuizzStatJoueurScreen quizzStatJoueurScreen;  

    static public AnswerQuizzScreen connectionScreen;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {


        //questionCreationScreen = new QuestionCreationScreen();
        //questionCreationScreen.setVisible(true);
        
        //quizzCreationScreen = new QuizzCreationScreen();
        //quizzCreationScreen.setVisible(true);
        
        accueilPlayerScreen = new AccueilJoueurScreen();
        accueilPlayerScreen.setVisible(true);
        
        //accueilAdminScreen = new AccueilAdminScreen();
        //accueilAdminScreen.setVisible(true);

        
        //questionCorrectionScreen = new QuestionCorrectionScreen();
        //questionCorrectionScreen.setVisible(true);


        //connectionScreen = new AnswerQuizzScreen();
        //connectionScreen.setVisible(true);
        
        playerRankQuizzScreen = new PlayerRankQuizzScreen();
        //playerRankQuizzScreen.setVisible(true);
        
        quizzStatJoueurScreen = new QuizzStatJoueurScreen();

    }
}
