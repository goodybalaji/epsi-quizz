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


    static public QuizzScreenQuestionCreation questionCreationScreen;
    static public QuizzScreenCreation quizzCreationScreen;
    static public PlayerScreenHome accueilPlayerScreen;
    static public AdminScreenHome accueilAdminScreen;
    static public QuizzScreenQuestionCorrection questionCorrectionScreen;
    static public PlayerScreenStat quizzStatPlayerScreen;  
    static public ConnectionScreen connectionScreen;
    static public PlayerScreenRankQuizz playerScreenRankQuizz;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {



        //questionCreationScreen = new QuestionCreationScreen();
        //questionCreationScreen.setVisible(true);

        //quizzCreationScreen = new QuizzCreationScreen();
        //quizzCreationScreen.setVisible(true);
        

        connectionScreen = new ConnectionScreen();
        connectionScreen.setVisible(true);
        
        /*
        accueilPlayerScreen = new PlayerScreenHome();
        accueilPlayerScreen.setVisible(true);
         */

        
        //accueilAdminScreen = new AccueilAdminScreen();
        //accueilAdminScreen.setVisible(true);

        //questionCorrectionScreen = new QuestionCorrectionScreen();
        //questionCorrectionScreen.setVisible(true);

        //connectionScreen = new AnswerQuizzScreen();
        //connectionScreen.setVisible(true);
        
        playerScreenRankQuizz = new PlayerScreenRankQuizz();
        //playerRankQuizzScreen.setVisible(true);
        
        quizzStatPlayerScreen = new PlayerScreenStat();


    }
}
